package CuartaIteracion;

import SegundaIteracion.*;

public class RepoPrenda {
    //para la prenda tendria q validar que se pueda crear una prenda, en base de eso generara una prenda, sino tirara error

    private TipoPrenda tipoSeleccionado;
    private Material materialSeleccionado;
    private Color colorPrincipalSeleccionado;
    private Color colorSecundarioSeleccionado;
    private Trama tramaSeleccionada;

    Prenda crearPrenda(){
        return new Prenda(tipoSeleccionado,materialSeleccionado,tramaSeleccionada,colorPrincipalSeleccionado,colorSecundarioSeleccionado);

    }

    public void modificarTipoSeleccionado(TipoPrenda tipoNuevo) {
        this.tipoSeleccionado = tipoNuevo;
    }

    public void modificarColorPrincipalSeleccionado(Color colorPrincipalNuevo) {
        this.colorPrincipalSeleccionado = colorPrincipalNuevo;
    }

    public void modificarColorSecundarioSeleccionado(Color colorSecundarioNuevo) {
        this.colorSecundarioSeleccionado = colorSecundarioNuevo;
    }

    public void modificarMaterialSeleccionado(Material materialNuevo) {
        this.materialSeleccionado = materialNuevo;
    }

    public void modificarTramaSeleccionado(Trama tramaNuevo) {
        this.tramaSeleccionada = tramaNuevo;
    }

}