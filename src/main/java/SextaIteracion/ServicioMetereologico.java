package SextaIteracion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ServicioMetereologico {
    BigDecimal obtenerTemperatura(String direccion);
}


class ServicioMetereologicoAccuWeather implements  ServicioMetereologico{
    private AccuWeatherAPI apiClima;
    private List<Guardarropas> guardarropasObservers = new ArrayList<>();
    private List<String> alertasDeHoy = new ArrayList<>();
    //TODO posible que haya una lista de acciones (notificar, mail,recalular)


    ServicioMetereologicoAccuWeather(AccuWeatherAPI apiActual){
        this.apiClima = apiActual;
    }

    public void ejecutarSugerenciaDiaria(){
        guardarropasObservers.forEach(guardarropas -> guardarropas.sugerirAtuendo(this));
    }

    // por ahora para mostrar las alertas que hubieron en el dia pensamos directamente mostrando la lista
    public List<String> mostrarAlertasDeHoy(){
        return alertasDeHoy;
    }

    public void actualizarAlertasMetereologicas(){
        alertasDeHoy = this.mostrarAlertasMetereologicas();
        guardarropasObservers.forEach(guardarropas -> guardarropas.mostrarAlertas(alertasDeHoy));
        this.posiblesAlertas();
        this.ejecutarSugerenciaDiaria();
    }

    //por ahora queda asi. TODO: queda ver si en realidad le enviamos un mail al usuario
    private void posiblesAlertas(){
        if(guardarropasObservers.contains("STORM")){
            guardarropasObservers.forEach(guardarropas -> guardarropas.alertaTormenta());
        }
        if(guardarropasObservers.contains("HAIL")){
            guardarropasObservers.forEach(guardarropas -> guardarropas.alertaGranizo());
        }
    }

    public void notificarTormenta(){
        // si en la lista de alertas hay tormenta, que le sugiera al usuario que lleve paraguas
    }

    public List<String> mostrarAlertasMetereologicas() {
        List<Map<String, Object>> alertas = apiClima.getWeather("Buenos Aires");
        return (List<String>) alertas.get(0).get("CurrentAlerts");
    }







    public BigDecimal obtenerTemperatura(String direccion){

        Map<String, Object> condicionesClimaticas = consultarApi(direccion);
        if(condicionesClimaticas.get("Unit").equals("F")){
            return  (BigDecimal) condicionesClimaticas.get("Value") ; //lo deberia multiplicar por 5/8
        }
        return (BigDecimal) condicionesClimaticas.get("Value");
    }
    private Map<String, Object> consultarApi(String direccion){
        return (Map<String, Object>) apiClima.getWeather(direccion).get(0).get("Temperature");
    }
}