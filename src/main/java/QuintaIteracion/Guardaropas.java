package QuintaIteracion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Guardaropas {
    private String criterio; // por ahora es un string porque si fuera una clase no tiene ningun comportamiento
    private List<Prenda> prendas= new ArrayList<>();
    private ServicioMetereologico apiClima;
    private GeneradorSugerencias generador;
    private List<Usuario> usuariosPermitidos = new ArrayList<>();

    public void agregarUsuario(Usuario usuario){
        usuariosPermitidos.add(usuario);
    }

    public Atuendo sugerirAtuendo() {

        //primero filtramos las que serian prendas aptas a la temperatura actual, para que se realize una sugerencia consistente
        List<Prenda> prendasAptas = prendasAptasATemperatura();

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
    private List<Prenda> prendasSegunCategoria(List<Prenda> prendas, Categoria categoria){
        //aca no queda muy lindo xq queda como un code smell, ya que le estamos preguntando de que categoria es que no sseria lo indicado, pero por ahora es una alternativa
        return prendas.stream().filter(prenda-> prenda.categoriaDePrenda() == categoria).collect(Collectors.toList());
    }


    public List<Prenda> prendasAptasATemperatura(){

        BigDecimal temperaturaActual = apiClima.obtenerTemperatura("Buenos Aires, Argentina");
        return obtenerAtuendosSegunTemperatura(temperaturaActual);

    }
    private List<Prenda> obtenerAtuendosSegunTemperatura(BigDecimal temperatura){
        return prendas.stream().filter(prenda -> prenda.temperaturaValida(temperatura)).collect(Collectors.toList());
    }
}