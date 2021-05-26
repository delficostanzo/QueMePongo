package QuintaIteracion;

import QuintaIteracion.Exceptions.CategoriaException;

public class Atuendo {
    Prenda superior;
    Prenda inferior;
    Prenda calzado;
    Prenda accesorio;

    public Atuendo(Prenda superior, Prenda inferior, Prenda calzado, Prenda accesorio) {

        validadorPrenda(superior, Categoria.SUPERIOR);
        validadorPrenda(inferior,Categoria.INFERIOR);
        validadorPrenda(calzado,Categoria.CALZADO);
        validadorPrenda(accesorio,Categoria.ACCESORIO);

        this.superior = superior;
        this.inferior = inferior;
        this.calzado = calzado;
        this.accesorio = accesorio;
    }
    private void validadorPrenda(Prenda prendaActual, Categoria categoriaActual){
        if(prendaActual == null){
            throw new NullPointerException("No hay una prenda seleccionada");
        }
        if(prendaActual.categoriaDePrenda() != categoriaActual) {
            throw new CategoriaException("Seleccionaste un tipo de prenda no indicada");
        }
    }
}