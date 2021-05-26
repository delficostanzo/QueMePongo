package QuintaIteracion;

import SegundaIteracion.CategoriaException;

import java.util.Arrays;
import java.util.List;

public enum TipoPrenda{

    ZAPATOS(Categoria.CALZADO, Arrays.asList(Material.LANA, Material.TELA, Material.JEAN)),
    MUSCULOSA(Categoria.SUPERIOR,Arrays.asList(Material.ALGODON, Material.POLIESTER));

    //CAMISA_MANGASCORTAS(Categoria.SUPERIOR),
    //CAMISA_MANGASLARGAS(Categoria.SUPERIOR),
    //PANTALON(Categoria.INFERIOR),
    //ANTEOJOSDESOL(Categoria.ACCESORIO),
    //PANUELO(Categoria.ACCESORIO),
    //ZAPATILLAS(Categoria.CALZADO);

    private Categoria categoria;
    private List<Material> materialesDisponibles;

    TipoPrenda(Categoria categoriaCorrecta, List<Material> materialesSolicitados){
        if(categoriaCorrecta == null){
            throw new CategoriaException("Debe seleccionar una categoria indicada para el nuevo tipo de prenda");
        }
        this.categoria = categoriaCorrecta;
        this.materialesDisponibles = materialesSolicitados;
    }
    public Categoria getCategoria(){
        return categoria;
    }
    public boolean admiteMaterial(Material material){
        return this.materialesDisponibles.contains(material);
    }
}