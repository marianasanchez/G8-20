package autores.modelos;

import interfaces.IGestorAutores;
import java.util.ArrayList;

public class GestorAutores implements IGestorAutores{
    private ArrayList<Autor> autores = new ArrayList<>();
    public static final String EXITO = "El nuevo 'Autor' fue creado con éxito";
    public static final String REPETIDO = "ERROR. El nuevo 'Autor' ya fue creado";
    public static final String INVALIDO = "ERROR. El autor ingresado es inválido";
    public static final String INSTANCIADO = "ERROR. Un objeto de esta clase ya ha sido creado";
    public static final String MODIFICADO = "El 'Autor' fue modificado";
    public static final String INEXISTENTE = "ERROR. El 'Autor' no existe";
    public static final String CLAVES_DISTINTAS = "ERROR. Las claves no coinciden";
    public static final String NO_PROFESOR = "ERROR. El autor ingresado no es un profesor";
    public static final String NO_ALUMNO = "ERROR. El autor ingresado no es un alumno";
    
    private static GestorAutores instancia;
    
    public static GestorAutores crear() {
        if(instancia == null){
            instancia = new GestorAutores();
        }
        return instancia;
    }

    @Override
    public String nuevoAutor(int dni, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida) {
        if((apellidos != null) && (nombres != null) && (cargo != null)&& (clave != null) && (dni != 0) && (!apellidos.isBlank()) && (!nombres.isBlank()) && (!cargo.toString().isBlank())&& (!clave.isBlank())){
            if(!clave.equals(claveRepetida)){
                return CLAVES_DISTINTAS;
            }
            else{
               Autor p = new Profesor(dni, apellidos, nombres, clave, cargo);
               if(!this.autores.contains(p)){
                   this.autores.add(p);
                   return EXITO;
               }
               else{
                   return REPETIDO;
               }
            }
        }
        return INVALIDO;
    }

    @Override
    public String nuevoAutor(int dni, String apellidos, String nombres, String cx, String clave, String claveRepetida) {
        if((apellidos != null) && (nombres != null) && (cx != null) && (dni != 0)&& (clave != null) && (!apellidos.isBlank()) && (!nombres.isBlank()) && (!cx.isBlank())&& (!clave.isBlank())){
            if(!clave.equals(claveRepetida)){
                return CLAVES_DISTINTAS;
            }
            else{
               Autor a = new Alumno(dni, apellidos, nombres, clave, cx);
               if(!this.autores.contains(a)){
                   this.autores.add(a);
                   return EXITO;
               }
               else{
                   return REPETIDO;
               }
            }
        }
        return INVALIDO;
    }

    @Override
    public String modificarAutor(Autor autor, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida) {
        if((apellidos != null) && (nombres != null) && (!apellidos.isBlank()) && (!nombres.isBlank())){
            if(autor instanceof Profesor){
                if(clave.equals(claveRepetida)){
                    for(Autor a : autores){
                        if(a.equals(autor)){
                            a.asignarApellidos(apellidos);
                            a.asignarNombres(nombres);
                            ((Profesor)a).asignarCargo(cargo);
                            a.asignarClave(clave);
                            return MODIFICADO;
                        }
                    }
                    return INEXISTENTE;
                }
                return CLAVES_DISTINTAS;
            }
            return NO_PROFESOR;
        }
        return INVALIDO;
    }

    @Override
    public String modificarAutor(Autor autor, String apellidos, String nombres, String cx, String clave, String claveRepetida) {
        if(autor instanceof Alumno){
            if(clave.equals(claveRepetida)){
                for(Autor a : autores){
                    if(a.equals(autor)){
                        a.asignarApellidos(apellidos);
                        a.asignarNombres(nombres);
                        ((Alumno)a).asignarCx(cx);
                        a.asignarClave(clave);
                        return MODIFICADO;
                    }
                }
                return INEXISTENTE;
            }
            return CLAVES_DISTINTAS;
        }
        return NO_ALUMNO;
    }

    @Override
    public boolean existeEsteAutor(Autor autor) {
        for(Autor a : autores){
            if(a.equals(autor)){
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Autor> verAutores() {
        return autores;
    }

    @Override
    public ArrayList<Profesor> verProfesores() {
        ArrayList<Profesor> profesores = new ArrayList<>();
        
        for(Autor a : autores){
            if(a instanceof Profesor){
                profesores.add((Profesor)a);
            }
        }
        return profesores;
    }

    @Override
    public ArrayList<Alumno> verAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        
        for(Autor a : autores){
            if(a instanceof Alumno){
                alumnos.add((Alumno)a);
            }
        }
        return alumnos;
    }

    @Override
    public Autor verAutor(int dni) {
        for(Autor a : autores){
            if(a.verDni() == dni){
                return a;
            }
        }
        return null;
    }
    public void BorrarAutor(int dni) {
        for(Autor a : autores){
            if(a.verDni() == dni){
                autores.remove(a);
                return;
            }
        }
    }
}
