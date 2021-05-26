package QuintaIteracion;

import QuintaIteracion.Exceptions.*;

import java.math.BigDecimal;

public class Prenda {
    private TipoPrenda tipoSeleccionado;
    private Material materialSeleccionado;
    private Trama tramaSeleccionada;
    private Color colorPrincipalSeleccionado;
    private Color colorSecundarioSeleccionado;
    BigDecimal temperaturaAdecuada;


    public boolean temperaturaValida(BigDecimal temperatura){
        return temperaturaAdecuada.intValue() < temperatura.intValue() ;
    }



    Prenda(TipoPrenda tipoSolicitado, Material materialSolicitado, Trama tramaSolicitada, Color colorPrincipalSolicitado, Color colorSecundarioSolicitado, BigDecimal temperatura) {
        //como requerimento primero lo que cargamos es el tipo de prenda solicitado:
        if (tipoSolicitado == null) {
            throw new TipoException("Debes seleccionar un tipo de atuendo a utilizar");
        }
        this.tipoSeleccionado = tipoSolicitado;


        if (materialSolicitado == null) {
            throw new MaterialException("Debes seleccionar un tipo de material para la prenda");
        }
        if(!tipoSolicitado.admiteMaterial(materialSolicitado)){
            throw new TipoException("Debes seleccionar un material consistente con el tipo de prenda");
        }
        this.materialSeleccionado = materialSolicitado;



        //trama
        if (tramaSolicitada == null) {
            tramaSolicitada = Trama.LISA;
        }else {
            this.tramaSeleccionada = tramaSolicitada;
        }



        if (colorPrincipalSolicitado == null) {
            throw new ColorException("Debes seleccionar un color de prenda");
        }
        this.colorPrincipalSeleccionado = colorPrincipalSolicitado;
        //puede ser null el color secundario, no deberia generar ninguna excepcion
        this.colorSecundarioSeleccionado = colorSecundarioSolicitado;
        this.temperaturaAdecuada = temperatura;
    }


    Categoria categoriaDePrenda() {
        return tipoSeleccionado.getCategoria();
    }

    //POR AHORA no agrego el metodo de cambiar color secundario ya que que considermanos que el colorSecundario no tendria que mutar, pero en caso de q pudiera no estaria de mas

}


