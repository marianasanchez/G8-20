/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.Autor;

import java.util.Objects;
/**
 *
 * @author rodrigo
 */
public class MiembroEnGrupo {
    //private Profesor profesor;
    private Autor autor;
    private Grupo grupo;
    private Rol rol;

    public MiembroEnGrupo(Autor autor, Grupo grupo, Rol rol) {
        //this.profesor = profesor;
        this.autor = autor;
        this.rol = rol;
        this.grupo = grupo;
    }
    
    public MiembroEnGrupo(Grupo grupo, Rol rol) {
        //this.profesor = profesor;
        this.rol = rol;
        this.grupo = grupo;
    }
    
    public MiembroEnGrupo(Autor autor, Rol rol) {
        //this.profesor = profesor;
        this.autor = autor;
        this.rol = rol;
    }

    public Rol verRol() {
        return rol;
    }

    public void asignarRol(Rol rol) {
        this.rol = rol;
    }

//    public Profesor verProfesor() {
//        return profesor;
//    }
//
//    public void asignarProfesor(Profesor profesor) {
//        this.profesor = profesor;
//    }
    
     public Autor verAutor() {
        return autor;
    }

    public void asignarAutor(Autor autor) {
        this.autor = autor;
    }

    public Grupo verGrupo() {
        return grupo;
    }

    public void asignarGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.autor);
        return hash;
    }

    @Override
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
        final MiembroEnGrupo other = (MiembroEnGrupo) obj;
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        return true;
    }
}
