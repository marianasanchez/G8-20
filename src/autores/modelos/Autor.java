package autores.modelos;

import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;
import java.util.ArrayList;
import java.util.List;

    public abstract class Autor implements Comparable<Autor> {
    private int dni;
    private String apellidos;
    private String nombres;
    private String clave;
    private List<MiembroEnGrupo> miembroEnGrupos = new ArrayList<>();

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
    
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        return hash;
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass().getSuperclass() != obj.getClass().getSuperclass()) {
            return false;
        }
        Autor other = (Autor) obj;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.dni;
        return hash;
    }

    public void agregarGrupo (Grupo grupo, Rol rol) {
        for (MiembroEnGrupo meg : miembroEnGrupos) {
            if((meg.verGrupo().equals(grupo)) && (meg.verRol().equals(rol))){
                return;
            }
            else if((meg.verGrupo().equals(grupo)) && (!meg.verRol().equals(rol))){
                meg.asignarRol(rol);
            }
        }
        miembroEnGrupos.add(new MiembroEnGrupo(this, grupo, rol));
        grupo.agregarMiembro(this, rol);
    }
    
    public void quitarGrupo (Grupo grupo) {
        for (MiembroEnGrupo meg : miembroEnGrupos) {
            if(meg.verGrupo().equals(grupo)){
                miembroEnGrupos.remove(meg);
//                this.quitarGrupo(grupo);
                grupo.quitarMiembro(this);
            }
        }
    }
    
    public void verGrupos () {
        System.out.println("Grupos:");
        for (MiembroEnGrupo meg : miembroEnGrupos) {
            System.out.println(meg.verGrupo().verNombre() + ", " +meg.verGrupo().verDescripcion());
            System.out.println(meg.verRol());
        }
    }
    
    public List<Grupo> mostrarGrupos(){
        List<Grupo> grupos = new ArrayList<> ();
        for (MiembroEnGrupo meg : miembroEnGrupos) {
            grupos.add(meg.verGrupo());
        }
        return grupos;
    }
    
    public List<MiembroEnGrupo> mostrarMiembroEnGrupos(){
        return miembroEnGrupos;
    }
    
    public boolean esSuperAdministrador() {
        for (MiembroEnGrupo meg : miembroEnGrupos) {
            if(meg.verGrupo().verNombre().equals("Super Administradores")){
                return true;
            }
        }
        return false;
    }
    
    public void mostrar() {
        System.out.println("[" + this.verDni()+"] "+ this.verApellidos() +", "+this.verNombres());
        this.verGrupos();
    }
    
    public Rol verRol(Autor autor, Grupo grupo){
        for(MiembroEnGrupo meg : miembroEnGrupos){
            if(autor.equals(meg.verAutor()) && grupo.equals(meg.verGrupo())){
                return meg.verRol();
            }
        }
        return null;
    }
    
    public void setRol(Autor autor, Grupo grupo, Rol rol){
        System.out.println("SET ROL");
        for(MiembroEnGrupo meg : miembroEnGrupos){
            if(grupo.equals(meg.verGrupo())){
                meg.asignarRol(rol);
                System.out.println(meg.verAutor().verNombres());
                System.out.println(meg.verGrupo().verNombre());
                System.out.println(meg.verRol());
            }
        }
    }
    
    public void setMiembroEnGrupos (List<MiembroEnGrupo> megs){
        this.miembroEnGrupos.clear();
        for(MiembroEnGrupo meg : megs){
            this.miembroEnGrupos.add(meg);
        }
    }
}