/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasclaves.modelos;

import interfaces.IGestorPalabrasClaves;
import java.util.ArrayList;

public class GestorPalabrasClaves implements IGestorPalabrasClaves{
    private ArrayList<PalabraClave> palabrasClaves = new ArrayList<>();
    public static final String EXITO = "La nueva 'Palabra Clave' fue creado con éxito";
    public static final String REPETIDO = "La nueva 'Palabra Clave' ya fue creado";
    public static final String INVALIDO = "El nombre ingresado es inválido";
    public static final String INSTANCIADO = "Un objeto de esta clase ya ha sido creado";
    
    private static GestorPalabrasClaves instancia;
    
    public static GestorPalabrasClaves crear(){
        if (instancia == null){
            instancia = new GestorPalabrasClaves();
        }
        else {
            System.out.println(INSTANCIADO);            
        }
        return instancia;
    }

    @Override
    public String nuevaPalabraClave(String nombre) {
        if ((nombre != null) && (!nombre.isBlank())){
            PalabraClave pc = new PalabraClave(nombre);
            if (!this.palabrasClaves.contains(pc)){
               this.palabrasClaves.add(pc);
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

    @Override
    public ArrayList<PalabraClave> verPalabrasClaves() {
        return palabrasClaves;
    }

    @Override
    public PalabraClave verPalabraClave(String nombre) {
        for (PalabraClave pc : palabrasClaves){
            if (pc.verNombre() == nombre){
                return pc;
            }
        }
        return null;
    }
    
    
}
