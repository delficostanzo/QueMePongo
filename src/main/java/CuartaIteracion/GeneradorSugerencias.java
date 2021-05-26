package CuartaIteracion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface GeneradorSugerencias {
    public List<Sugerencia> generarSugerenciasDesde(List <Prenda> prendasAptas);
    //al no haber implementado el QMP3, por recomendacion de franco para implementar la logica de la combinacion de las prendas
    //para formar una sugerencia utilizamos esta interfaz, en el cual alguna clase la implementa
}


//ponemos esta clase como ejemplo que implementa la interfaz


class Sugeridor implements GeneradorSugerencias{
    //lo de las prendas aptas lo modelo aca
    private boolean temperaturaValida(Prenda prenda){
        return prenda.getTemperaturaAdecuada() < this.temperaturaActual();
    }



    //ACA UTILIZO lo de las prendas aptas. Aca podemos encontrar ademas un patron de tipo adapter ya que estan trabajando dos
    //estructuras que son incompatibles entre ellas
    //y aca finalmente definimos el tema de las prendas aptas


    public List <Prenda> prendasAptas(List <Prenda> prendas){
        return prendas.stream().filter(prenda -> this.temperaturaValida(prenda)).collect(Collectors.toList());
    }
    private int temperaturaActual(){
        AccuWeatherAPI apiClima = new AccuWeatherAPI();
        List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather("Buenos Aires, Argentina");
        Map<String, Object> temperaturaActual = (Map<String, Object>) condicionesClimaticas.get(0).get("Temperature");
        int temperatura = (int) temperaturaActual.get("Value");
        return temperatura;
    }


    public List<Sugerencia> generarSugerenciasDesde(List <Prenda> prendas){
        //esto validaria que sean aptas con la temperatura actual
        List<Prenda> prendasAptas = this.prendasAptas(prendas);
        //.... aplica toda la logica de las sugerencias
        return new ArrayList<Sugerencia>(); //esta logica no importa todavia
    }
}