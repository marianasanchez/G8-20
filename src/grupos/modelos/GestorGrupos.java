/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import interfaces.IGestorGrupos;
import java.util.ArrayList;

public class GestorGrupos implements IGestorGrupos{
    private ArrayList<Grupo> grupos = new ArrayList<>();
    public static final String EXITO = "El nuevo 'Grupo' fue creado con éxito";
    public static final String REPETIDO = "ERROR. El nuevo 'Grupo' ya fue creado";
    public static final String INVALIDO = "ERROR. El nombre ingresado es inválido";
    public static final String INSTANCIADO = "ERROR. Un objeto de esta clase ya ha sido creado";
    public static final String MODIFICADO = "El 'Grupo' fue modificado";
    public static final String INEXISTENTE = "ERROR. El 'Grupo' no existe";
    
    private static GestorGrupos instancia;
    
    public static GestorGrupos crear() {
        if (instancia == null){
            instancia = new GestorGrupos();
        }
        else {
            System.out.println(INSTANCIADO);            
        }
        return instancia;
    }

    @Override
    public String nuevoGrupo(String nombre, String descripcion) {
        if ((nombre != null) && (descripcion != null) && (!nombre.isBlank()) && (!descripcion.isBlank())){
            Grupo g = new Grupo (nombre, descripcion);
            if (!this.grupos.contains(g)){
                this.grupos.add(g);
                return EXITO;
            }
            else {
                return REPETIDO;
            }
        }
        return INVALIDO;
    }

    @Override
    public String modificarGrupo(Grupo grupo, String descripcion) {
        if(instancia.existeEsteGrupo(grupo)){
            for (Grupo g : grupos) {
                if(g.equals(grupo)){
                    g.asignarDescripcion(descripcion);
                    return MODIFICADO;
                }
            }
        }
        return INEXISTENTE;
    }

    @Override
    public ArrayList<Grupo> verGrupos() {
        return grupos;
    }

    @Override
    public Grupo verGrupo(String nombre) {
        for (Grupo g : grupos){
            if (g.verNombre() == nombre) {
                return g;
            }
        }
        return null;
    }

    @Override
    public boolean existeEsteGrupo(Grupo grupo) {
        if(grupos.contains(grupo)){
            return true;
        }
        return false;
    }
    
}