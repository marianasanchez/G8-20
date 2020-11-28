package interfaces;

import autores.modelos.Alumno;
import autores.modelos.Autor;
import autores.modelos.Cargo;
import autores.modelos.Profesor;
import grupos.modelos.Grupo;
import java.util.Comparator;
import java.util.List;

public interface IGestorAutores {
    public String nuevoAutor (int dni, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida);
    public String nuevoAutor (int dni, String apellidos, String nombres, String cx, String clave, String claveRepetida);
    public String modificarAutor (Autor autor, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida);
    public String modificarAutor (Autor autor, String apellidos, String nombres, String cx, String clave, String claveRepetida);
    public boolean existeEsteAutor (Autor autor);
    public Autor verAutor (int dni);
    public String borrarAutor(Autor autor);
    public List<Profesor> buscarProfesores(String apellidos);
    public List<Profesor> buscarProfesores(String apellidos, Comparator<Profesor> apellidoCmp, Comparator<Profesor> nombreCmp);
    public List<Alumno> buscarAlumnos(String apellidos);
    public List<Alumno> buscarAlumnos(String apellidos, Comparator<Alumno> apellidoCmp, Comparator<Alumno> nombreCmp);
    public List<Autor> verAutores();
    public List<Autor> verAutores(Comparator<Autor> apellidoCmp, Comparator<Autor> nombreCmp);
    public List<Profesor> verProfesores();
    public List<Profesor> verProfesores(Comparator<Profesor> apellidoCmp, Comparator<Profesor> nombreCmp);
    public List<Alumno> verAlumnos();
    public List<Alumno> verAlumnos(Comparator<Alumno> apellidoCmp, Comparator<Alumno> nombreCmp);
    public boolean hayAutoresConEsteGrupo(Grupo grupo);
}
