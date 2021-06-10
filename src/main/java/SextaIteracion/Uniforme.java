package SextaIteracion;


import QuintaIteracion.Categoria;
import QuintaIteracion.Exceptions.CategoriaException;
import QuintaIteracion.Prenda;

import java.util.ArrayList;
import java.util.List;


//pense en utilizar borradores, pero como no establece que los uniformes puedan ser cambiados luego, entonces me parece bien usar asi el uniforme
public class Uniforme {

    List <QuintaIteracion.Prenda> uniformeActual =  new ArrayList<>();

    Uniforme(QuintaIteracion.Prenda prendaSuperior, QuintaIteracion.Prenda prendaInferior, Prenda prendaCalzado){
        if(prendaSuperior.categoriaDePrenda() != QuintaIteracion.Categoria.SUPERIOR){
            //throw new CategoriaException(Categoria.SUPERIOR, prendaSuperior.categoriaDePrenda());
            throw new CategoriaException("Debe seleccionar una prenda de categoria superior"+
                    "su tipo actual es: "+ prendaSuperior.categoriaDePrenda().toString());
        }
        this.uniformeActual.add(prendaSuperior);

        if(prendaInferior.categoriaDePrenda() != QuintaIteracion.Categoria.INFERIOR){
            //throw new CategoriaException(Categoria.INFERIOR, prendaInferior.categoriaDePrenda());
            throw new CategoriaException("Debe seleccionar una prenda de categoria inferior"+
                    "su tipo actual es: "+ prendaInferior.categoriaDePrenda().toString());
        }
        this.uniformeActual.add(prendaInferior);
        if(prendaCalzado.categoriaDePrenda() != Categoria.CALZADO){
            //throw new CategoriaException(Categoria.CALZADO, prendaCalzado.categoriaDePrenda());
            throw new CategoriaException("Debe seleccionar una prenda de categoria calzado"+
                    "su tipo actual es: "+ prendaCalzado.categoriaDePrenda().toString());
        }
        this.uniformeActual.add(prendaCalzado);


    }

    //los uniformes todavia no tienen comportamiento x lo tanto no se lo declaramos

}