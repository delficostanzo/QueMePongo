package QuintaIteracion;

public class Borrador {
    //para la prenda tendria q validar que se pueda crear una prenda, en base de eso generara una prenda, sino tirara error
    //al ser un borrador algo q despues podemos modificar, establecemos los setters para luego poder realizar modificaciones

    private TipoPrenda tipoSeleccionado;
    private Material materialSeleccionado;
    private Color colorPrincipalSeleccionado;
    private Color colorSecundarioSeleccionado;
    private Trama tramaSeleccionada;
    int temperatura;

    Prenda crearPrenda(){
        return new Prenda(tipoSeleccionado,materialSeleccionado,tramaSeleccionada,colorPrincipalSeleccionado,colorSecundarioSeleccionado,temperatura);

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
    void seleccionarTemperatura(int temperaturaSeleccionada){
        this.temperatura = temperaturaSeleccionada;
    }

}