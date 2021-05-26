package QuintaIteracion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface GeneradorSugerencias {
    public List<Atuendo> generarSugerenciasDesde(List <Prenda> prendasAptas);
    //al no haber implementado el QMP3, por recomendacion de franco para implementar la logica de la combinacion de las prendas
    //para formar una sugerencia utilizamos esta interfaz, en el cual alguna clase la implementa
}