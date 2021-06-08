package SextaIteracion;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String username; // cada usuario se diferencia a traves de un nombre y apellido (por ahora)
    private String password;
    List<Guardarropas> guardarropasActual= new ArrayList<>();

    // En estos dos metodos (sugerirAgregadoDeAtuendo y sugerirQuitadoDeAtuendo) se puede ver que son medio code smell (Duplicated method), pero como son dos diferentes
    // tipos de operaciones, consideramos que estaba bien. (Puede ser que en el futuro se modifiquen)


    public void sugerirAgregadoDeAtuendo(Usuario usuario, Prenda prendaSugerido, Guardarropas guardarropas) {
        usuario.agregarSugerencia(guardarropas,new Agregar(prendaSugerido));
    }

    public void sugerirQuitadoDeAtuendo(Usuario usuario, Prenda prendaSugerido, Guardarropas guardarropas) {
        usuario.agregarSugerencia(guardarropas,new Quitar(prendaSugerido));
    }

    // La sugerencia se agrega en la lista de modificaciones sugeridas de un guardarropas en particular.
    private void agregarSugerencia(Guardarropas guardarropas, Modificacion modificacion){
        guardarropas.modificacionesSugeridas.add(modificacion);
    }

}