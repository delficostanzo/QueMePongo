package SextaIteracion;

//Consideramos el caso de la superclase abstracta, pero quiza como a futuro puedan cambiar el estado interno, decidimos mejor dejarlo
//como una interfaz donde el estado interno depende de cada clase que la implemente


public interface Modificacion {
    void aceptar(Guardarropas guardarropas);
}

class Agregar implements Modificacion{

    Prenda prendaActual;

    public Agregar(Prenda prenda){
        this.prendaActual = prenda;
    }

    public void aceptar(Guardarropas guardarropas){
        guardarropas.agregarPrenda(prendaActual);
    }

}


class Quitar implements Modificacion{

    Prenda prendaActual;

    public Quitar(Prenda prenda){
        this.prendaActual = prenda;
    }

    public void aceptar(Guardarropas guardarropas){
        guardarropas.quitarPrenda(prendaActual);
    }

}
