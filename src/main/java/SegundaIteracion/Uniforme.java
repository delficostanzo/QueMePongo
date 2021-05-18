package SegundaIteracion;

import java.util.ArrayList;
import java.util.List;

public class Uniforme {

    List <Prenda> uniformeActual =  new ArrayList<>();

    Uniforme(Prenda prendaSuperior, Prenda prendaInferior, Prenda prendaCalzado){
        if(prendaSuperior.categoriaDePrenda() != Categoria.SUPERIOR){
            //throw new CategoriaException(Categoria.SUPERIOR, prendaSuperior.categoriaDePrenda());
            throw new CategoriaException("Debe seleccionar una prenda de categoria superior"+
                    "su tipo actual es: "+ prendaSuperior.categoriaDePrenda().toString());
        }
        this.uniformeActual.add(prendaSuperior);

        if(prendaInferior.categoriaDePrenda() != Categoria.INFERIOR){
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
