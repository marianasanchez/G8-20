/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Carlos
 */
import java.util.ArrayList;
import idiomas.modelos.Idioma;

public interface IGestorIdiomas {
      public String nuevoIdioma (String nombre);
    public ArrayList<Idioma> verIdiomas();
    public Idioma verIdioma (String nombre);
}
