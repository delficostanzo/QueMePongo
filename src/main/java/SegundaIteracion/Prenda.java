package SegundaIteracion;

import SegundaIteracion.CategoriaException;
import SegundaIteracion.ColorException;
import SegundaIteracion.MaterialException;
import SegundaIteracion.TipoException;

public class Prenda {
    private TipoPrenda tipoSeleccionado;
    private Material materialSeleccionado;
    private Color colorPrincipalSeleccionado;
    private Color colorSecundarioSeleccionado;
    private Trama tramaSeleccionada;


    Prenda(TipoPrenda tipoSolicitado, Color colorPrincipalSolicitado, Color colorSecundarioSolicitado, Material materialSolicitado, Trama tramaSolicitada) {
        //como requerimento primero lo que cargamos es el tipo de prenda solicitado:
        if (tipoSolicitado == null) {
            throw new TipoException("Debes seleccionar un tipo de atuendo a utilizar");
        }
        this.tipoSeleccionado = tipoSolicitado;


        if (colorPrincipalSolicitado == null) {
            throw new ColorException("Debes seleccionar un color de prenda");
        }
        this.colorPrincipalSeleccionado = colorPrincipalSolicitado;
        //puede ser null el color secundario, no deberia generar ninguna excepcion
        this.colorSecundarioSeleccionado = colorSecundarioSolicitado;

        if (materialSolicitado == null) {
            throw new MaterialException("Debes seleccionar un tipo de material para la prenda");
        }
        this.materialSeleccionado = materialSolicitado;

        //trama
        if (tramaSolicitada == null) {
            tramaSolicitada = Trama.LISA;
        }
        this.tramaSeleccionada = tramaSolicitada;

    }

    public Categoria categoriaDePrenda() {
        return tipoSeleccionado.getCategoria();
    }

    //POR AHORA no se lo agrego ya que que considermanos que el colorSecundario no tendria que mutar, pero en caso de q pudiera no estaria de mas

    //void indicarColorSecundario(Color colorAagregar) {
    //    this.colorSecundarioSeleccionado = colorAagregar;
    //    }
}



//deseo utlizar este tipo de color, ya que en base a este puedo seleccionar un rango de colores en base a la combincaion de colores primarios
class Color{
    int rojo;
    int azul;
    int amarillo;

    public Color(int rojonSeleccionado, int azulSeleccionado, int amarilloSeleccionado) {
        this.rojo = rojonSeleccionado;
        this.azul = azulSeleccionado;
        this.amarillo = amarilloSeleccionado;
    }
}

// como no hay comportamiento respecto al material, por ahora me parece q lo mas certero es utilizar enums
enum Material {
    TELA, LANA, CUERO, JEAN
}


// el tipo se relaciona siempre con una categoria de prenda, ya q la categoria de la prenda, siempre dependera del tipo
enum TipoPrenda{

    ZAPATOS(Categoria.CALZADO),
    MUSCULOSA(Categoria.SUPERIOR),
    CAMISA_MANGASCORTAS(Categoria.SUPERIOR),
    CAMISA_MANGASLARGAS(Categoria.SUPERIOR),
    PANTALON(Categoria.INFERIOR),
    ANTEOJOSDESOL(Categoria.ACCESORIO),
    PANUELO(Categoria.ACCESORIO),
    ZAPATILLAS(Categoria.CALZADO);

    private Categoria categoria;

    TipoPrenda(Categoria categoriaCorrecta){
        if(categoriaCorrecta == null){
            throw new CategoriaException("Debe seleccionar una categoria indicada para el nuevo tipo de prenda");
        }
        this.categoria = categoriaCorrecta;
    }
    Categoria getCategoria(){
        return categoria;
    }
}


enum Trama{
    LISA,RAYADA,LUNARES,CUADROS,ESTAMPADO
}
