package QuintaIteracion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Usuario {

    private String username; // cada usuario se diferencia a traves de un nombre y apellido (por ahora)
    private String password;
    Guardaropas guardarropasActual;

    public Atuendo sugerirAtuendo() {
        return guardarropasActual.sugerirAtuendo();
    }

}