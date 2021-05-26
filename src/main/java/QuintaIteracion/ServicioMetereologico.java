package QuintaIteracion;

import CuartaIteracion.Categoria;
import CuartaIteracion.Prenda;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;

public interface ServicioMetereologico {
    BigDecimal obtenerTemperatura(String direccion);
}



class ServicioMetereologicoAccuWeather implements  ServicioMetereologico{
    private AccuWeatherAPI apiClima;

    ServicioMetereologicoAccuWeather(AccuWeatherAPI apiActual){
        this.apiClima = apiActual;
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