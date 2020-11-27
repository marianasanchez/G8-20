package idiomas.modelos;

import java.util.ArrayList;
import interfaces.IGestorIdiomas;
import java.util.Collections;
import java.util.List;
import publicaciones.modelos.GestorPublicaciones;

public class GestorIdiomas implements IGestorIdiomas{
    private List<Idioma> idiomas = new ArrayList<> ();
    public static final String EXITO = "El nuevo 'Idioma' fue creado con éxito";
    public static final String REPETIDO = "ERROR. El nuevo 'Idioma' ya fue creado";
    public static final String INVALIDO = "ERROR. El nombre ingresado es inválido";
    public static final String INSTANCIADO = "ERROR. Un objeto de esta clase ya ha sido creado";
    public static final String BORRADO_EXITO = "Se ha borrado con éxito el tipo seleccionado";
    public static final String BORRADO_INEXISTENTE = "No se encuentra el tipo seleccionado";
    public static final String EXISTE_PUB = "ERROR. Existe una publicación asociada a ese tipo";
    
    private static GestorIdiomas instancia;
    
    public static GestorIdiomas crear () {
        if (instancia == null){
            instancia = new GestorIdiomas();
        }
//        else{
//            System.out.println(INSTANCIADO);
//        }
        return instancia;
    }
    

    public String nuevoIdioma(String nombre) {
        if ((nombre != null) && (!nombre.isBlank())){
            Idioma i = new Idioma(nombre);
            if (!this.idiomas.contains(i)){
               this.idiomas.add(i);
               return EXITO;
            }
            else {
                return REPETIDO;
            }
        }
        else {
            return INVALIDO;
        }
    }

    public List<Idioma> verIdiomas() {
        Collections.sort(idiomas);
        return idiomas;
    }

    
    public Idioma verIdioma(String nombre) {
        for (Idioma i : idiomas){
            if (i.verNombre() == nombre){
                return i;
            }
        }
        return null;
    }

    @Override
    public String borrarIdioma(Idioma idioma) {
        GestorPublicaciones gp1 = GestorPublicaciones.crear();
        if (idiomas.contains(idioma)){
            if(gp1.hayPublicacionesConEsteIdioma(idioma)){
                return EXISTE_PUB;
            }
            idiomas.remove(idioma);
            return BORRADO_EXITO;
        }
        return BORRADO_INEXISTENTE;
    }

    @Override
    public List<Idioma> buscarIdiomas(String nombre) {
             List<Idioma> busquedaIdiomas = new ArrayList<>();
        for (Idioma i : idiomas){
            if (i.verNombre().contains(nombre)){
                busquedaIdiomas.add(i);
            }
        }
        Collections.sort(busquedaIdiomas);
        return busquedaIdiomas;
    }

    @Override
    public boolean existeEsteIdioma(Idioma idioma) {
        if(idiomas.contains(idioma)){
            return true;
        }
        return false;
    }
}
