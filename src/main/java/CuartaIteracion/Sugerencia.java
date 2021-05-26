package CuartaIteracion;


import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Sugerencia {

    Prenda superior;
    Prenda inferior;
    Prenda calzado;
    Prenda accesorio;

    // AUNQUE ESTO A FUTURO PODRIA CAMBIAR, YA QUE PODRIA HABER SUGERENCIAS DE MAS PRENDAS.
    // la validez de la sugerencia se realiza en el atuendo que verifica que haya un en las prendas una categoria por prenda
    public Sugerencia(List<Prenda> prendas){

        //primero filtramos las que serian prendas aptas a la temperatura actual, para que se realize una sugerencia consistente
        List<Prenda> prendasAptas =  prendasAptasPorTemperatura(prendas);

        List<Prenda> prendasSuperiores = this.prendasSegunCategoria(prendasAptas,Categoria.SUPERIOR);
        List<Prenda> prendasInferiores = this.prendasSegunCategoria(prendasAptas,Categoria.INFERIOR);
        List<Prenda> prendasCalzado = this.prendasSegunCategoria(prendasAptas,Categoria.CALZADO);
        List<Prenda> prendasAccesorio = this.prendasSegunCategoria(prendasAptas,Categoria.ACCESORIO);

        //se me ocurrio que la sugerencia se forma a partir de una lista de prendas, las cuales se eligen al azar en base a cada categoria,
        // y asi crea la sugerencia
        this.superior = prendasSuperiores.get(new Random().nextInt(prendasSuperiores.size()));
        this.inferior = prendasInferiores.get(new Random().nextInt(prendasInferiores.size()));
        this.calzado = prendasCalzado.get(new Random().nextInt(prendasCalzado.size()));
        this.superior = prendasAccesorio.get(new Random().nextInt(prendasAccesorio.size()));

    }

    public Atuendo devolverAtuendo(){
        //luego cuando quiera crear un atuendo con la sugerencia, lo retorno, donde en tal caso la validacion se realizara en el atuendo
        return new Atuendo(superior,inferior,calzado,accesorio);
    }


    private List<Prenda> prendasSegunCategoria(List<Prenda> prendas,Categoria categoria){
        //aca no queda muy lindo xq queda como un code smell, ya que le estamos preguntando de que categoria es que no sseria lo indicado, pero por ahora es una alternativa
        return prendas.stream().filter(prenda-> prenda.categoriaDePrenda() == categoria).collect(Collectors.toList());
    }





    //esto nos valida la tematica de que si las prendas cumplen con el tema de la temperatura correcta.
    //para lo cual por temas de diseño vemos conveniente utilizar la API recomendada por la catedra, la cual nos permite realizar
    //los calculos de forma mas simple y no tener que adaptarla nosotros que podria conllevar a un diseño mas complejo y que posiblemente
    //tenga un costo mucho mayor

    private List <Prenda> prendasAptasPorTemperatura(List <Prenda> prendas){
        return prendas.stream().filter(prenda -> this.prendaConTemperaturaValida(prenda)).collect(Collectors.toList());
    }
    private boolean prendaConTemperaturaValida(Prenda prenda){
        return prenda.getTemperaturaAdecuada() > this.temperaturaActual();
    }

    //aca utilizaremos la API mencionada, donde obtendremos el valor de la temperatura actual
    private BigDecimal temperaturaActual(){
        AccuWeatherAPI apiUtilizada = new AccuWeatherAPI();
        List<Map<String, Object>> condicionesClimaticas = apiUtilizada.getWeather("Buenos Aires, Argentina");
        Map<String, Object> temperaturaActual = (Map<String, Object>) condicionesClimaticas.get(0).get("Temperature");
        return (BigDecimal) temperaturaActual.get("Value");

    }


}