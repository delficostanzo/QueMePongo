package SextaIteracion;

import QuintaIteracion.Atuendo;
import QuintaIteracion.Prenda;

import java.util.List;

public interface GeneradorSugerencias {
    public List<Atuendo> generarSugerenciasDesde(List <Prenda> prendasAptas);
    //al no haber implementado el QMP3, por recomendacion de franco para implementar la logica de la combinacion de las prendas
    //para formar una sugerencia utilizamos esta interfaz, en el cual alguna clase la implementa
}