package SextaIteracion;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Guardarropas {
    private String criterio; // por ahora es un string porque si fuera una clase no tiene ningun comportamiento
    private List<Prenda> prendas= new ArrayList<>();
    private GeneradorSugerencias generador;
    private List<Usuario> usuariosPermitidos = new ArrayList<>();
    List <Modificacion> modificacionesSugeridas = new ArrayList<>();

    public void agregarUsuario(Usuario usuario){
        usuariosPermitidos.add(usuario);
    }

    //CONSIDERAMOS QUE EL GUARDARROPAS HACE LO RELACIONADO CON LAS DECISIONES RESPECTO DE LAS MODIFICACIONES SUGERIDAS

    // Nosotros consideramos que lo q va a hacer es ir quitando de a una de la lista de modificiones
    // Por lo tanto va a rechazar o aceptar la primera modificacion de la lista propuesta.
    // Como no aclara si cuando se rechaza se quita de la lista, nosotros lo vamos a considerar q si se elimina

    public String alertaTormenta(){
        return "ESTA LLOVIENDO, SALI CON PARAGUAS GIL";
    }

    public String alertaGranizo(){
        return "NO SALGAS EN AUTO";
    }



    public void aceptarPropuestaDeModificacion() {
        Modificacion propuestaActual = analizarPrimeraModificacion();
        propuestaActual.aceptar(this);
        eliminarPropuestaDeModificacion();
    }

    public void rechazarPropuestaDeModificacion(){
        eliminarPropuestaDeModificacion();
    }

    public void agregarPrenda(Prenda prenda){
        prendas.add(prenda);
    }

    public void quitarPrenda(Prenda prenda){
        prendas.remove(prenda);
    }

    /// METODOS INTERNOS DE LA CLASE ///
    //como vamos a analizar a partir del primero de la lista de sugerencias de
    // modificacion, borramos por indices, teniendo que borrar el primero
    private void eliminarPropuestaDeModificacion(){
        modificacionesSugeridas.remove(0);
    }

    private Modificacion analizarPrimeraModificacion(){
        // Primero analizamos si hay modificaciones sugeridas en la lista. Si no hay, tira una excepcion.
        if(modificacionesSugeridas == null){
            throw new NullPointerException("No hay sugerencias de modificaciones disponibles");
        }
        // Si hay modificaciones sugeridas, retorna la primera en la lista.
        return modificacionesSugeridas.get(0);
    }

    public Atuendo sugerirAtuendo(ServicioMetereologicoAccuWeather apiClima) {

        //primero filtramos las que serian prendas aptas a la temperatura actual, para que se realize una sugerencia consistente
        List<Prenda> prendasAptas = this.prendasAptasATemperatura(apiClima);

        List<Prenda> prendasSuperiores = this.prendasSegunCategoria(prendasAptas, Categoria.SUPERIOR);
        List<Prenda> prendasInferiores = this.prendasSegunCategoria(prendasAptas, Categoria.INFERIOR);
        List<Prenda> prendasCalzado = this.prendasSegunCategoria(prendasAptas, Categoria.CALZADO);
        List<Prenda> prendasAccesorio = this.prendasSegunCategoria(prendasAptas, Categoria.ACCESORIO);
        //se me ocurrio que la sugerencia se forma a partir de una lista de prendas, las cuales se eligen al azar en base a cada categoria,
        // y asi crea la sugerencia
        Prenda superior = prendasSuperiores.get(new Random().nextInt(prendasSuperiores.size()));
        Prenda inferior = prendasInferiores.get(new Random().nextInt(prendasInferiores.size()));
        Prenda calzado = prendasCalzado.get(new Random().nextInt(prendasCalzado.size()));
        Prenda accesorio = prendasAccesorio.get(new Random().nextInt(prendasAccesorio.size()));

        return new Atuendo(superior,inferior,calzado,accesorio);
    }

    //SEXTA ITERACION

    public List<String> mostrarAlertas(List<String> alertas){
        return alertas;
    }






















    private List<Prenda> prendasSegunCategoria(List<Prenda> prendas, Categoria categoria){
        //aca no queda muy lindo xq queda como un code smell, ya que le estamos preguntando de que categoria es que no sseria lo indicado, pero por ahora es una alternativa
        return prendas.stream().filter(prenda-> prenda.categoriaDePrenda() == categoria).collect(Collectors.toList());
    }


    public List<Prenda> prendasAptasATemperatura(ServicioMetereologicoAccuWeather apiClima){

        BigDecimal temperaturaActual = apiClima.obtenerTemperatura("Buenos Aires, Argentina");
        return obtenerAtuendosSegunTemperatura(temperaturaActual);

    }
    private List<Prenda> obtenerAtuendosSegunTemperatura(BigDecimal temperatura){
        return prendas.stream().filter(prenda -> prenda.temperaturaValida(temperatura)).collect(Collectors.toList());
    }
}