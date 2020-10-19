/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public abstract class Autor {
    private int dni;
    private String apellidos;
    private String nombres;
    private String clave;
    private ArrayList<MiembroEnGrupo> miembroEnGrupos = new ArrayList<>();

    public Autor(int dni, String apellidos, String nombres, String clave) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.clave = clave;
    }

    public int verDni() {
        return dni;
    }

    public void asignarDni(int dni) {
        this.dni = dni;
    }

    public String verApellidos() {
        return apellidos;
    }

    public void asignarApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String verNombres() {
        return nombres;
    }

    public void asignarNombres(String nombres) {
        this.nombres = nombres;
    }

    public String verClave() {
        return clave;
    }

    public void asignarClave(String clave) {
        this.clave = clave;
    }

//    public void asignarMiembrosEnGrupo(ArrayList<MiembroEnGrupo> miembroEnGrupos) {
//        this.miembroEnGrupos = miembroEnGrupos;
//    }
    
    
    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
    }

//    public void verGrupos() {
//        for (MiembroEnGrupo g : miembroEnGrupos) {
//            System.out.println(g.verAutor());
//            System.out.println(g.verGrupo());
//            System.out.println(g.verRol());
//        }
//    }
    
    public void agregarGrupo (Grupo grupo, Rol rol) {
        MiembroEnGrupo nuevoGrupo = new MiembroEnGrupo(this, grupo, rol);
//        for(MiembroEnGrupo meg : miembroEnGrupos) {
//            if (meg.verGrupo().equals(grupo)) {
//                System.out.println("YA EXISTE");
//            }
//            else {
//                System.out.println("NO EXISTE");
//            }
//        }
       if(!miembroEnGrupos.contains(nuevoGrupo)){
            miembroEnGrupos.add(nuevoGrupo);
            grupo.agregarMiembro(this, rol);
        }
        else {
            System.out.println("YA EXISTE");
        }
    }
    
    public void verGrupos () {
        System.out.println("Grupos:");
        for (MiembroEnGrupo meg : miembroEnGrupos) {
            System.out.println(meg.verGrupo().verNombre() + ", " +meg.verGrupo().verDescripcion());
            System.out.println(meg.verRol());
        }
    }
    
    public void mostrar() {
        System.out.println("[" + this.verDni()+"] "+ this.verApellidos() +", "+this.verNombres());
        this.verGrupos();
    }
}