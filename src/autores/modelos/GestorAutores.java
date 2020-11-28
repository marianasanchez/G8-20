package autores.modelos;

import static grupos.modelos.GestorGrupos.BORRADO_EXITO;
import static grupos.modelos.GestorGrupos.BORRADO_INEXISTENTE;
import static grupos.modelos.GestorGrupos.EXISTE_PUB;
import grupos.modelos.Grupo;
import interfaces.IGestorAutores;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import publicaciones.modelos.GestorPublicaciones;

public class GestorAutores implements IGestorAutores{
    private List<Autor> autores = new ArrayList<>();
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
    public String borrarAutor(Autor autor) {
        GestorPublicaciones gp1 = GestorPublicaciones.crear();
        if (autores.contains(autor)){
            if(gp1.hayPublicacionesConEsteAutor(autor)){
                return EXISTE_PUB;
            }
            autores.remove(autor);
            return BORRADO_EXITO;
        }
        return BORRADO_INEXISTENTE;
    }

    @Override
    public List<Profesor> buscarProfesores(String apellidos) {
        this.verProfesores();
        return null;
    }

    @Override
    public List<Profesor> buscarProfesores(String apellidos, Comparator<Profesor> apellidoCmp, Comparator<Profesor> nombreCmp) {
        List<Profesor> busquedaProfesores = new ArrayList<>();
        for(Profesor p : this.verProfesores(apellidoCmp, nombreCmp)){
            if(p.verApellidos().contains(apellidos)){
                busquedaProfesores.add(p);
            }
        }
        return busquedaProfesores;
    }
    
    @Override
     public List<Profesor> verProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        for(Autor a : autores){
            if(a instanceof Profesor){
                profesores.add((Profesor)a);
            }
        }
        return profesores;
    }
   
    @Override
    public List<Profesor> verProfesores(Comparator<Profesor> apellidoCmp, Comparator<Profesor> nombreCmp) {
        List<Profesor> profesores = new ArrayList<>();
        for(Autor a : autores){
            if(a instanceof Profesor){
                profesores.add((Profesor)a);
            }
        }
        profesores.sort(apellidoCmp);

        List<String> apellidosAux = new ArrayList<>();
        for(Profesor p : profesores){
            if (!apellidosAux.contains(p.verApellidos())){
                apellidosAux.add(p.verApellidos());
            }
        }
        
        List<Profesor> profesoresOrdenados = new ArrayList<>();
        int i;
        for (i = 0; i < apellidosAux.size(); i++){
            List<Profesor> profesoresAux = new ArrayList<>();
            for(Profesor p : profesores){
                if(p.verApellidos().equals(apellidosAux.get(i))){
                    profesoresAux.add(p);
                }
            }
            profesoresAux.sort(nombreCmp);
            profesoresOrdenados.addAll(profesoresAux);
        }
        
        return profesoresOrdenados;

//        String  aux = null;
//        List<Profesor>  arrayaux = new ArrayList<>();
//        List<Profesor>  arrayaux2 = new ArrayList<>();
//        for(Profesor p : profesores){
//            if(profesores.indexOf(p) == 0){
//                arrayaux.add(p);
//                aux = p.verApellidos();
//            }
//            else{
//                 if(!p.verApellidos().equals(aux)){
//                    arrayaux2.addAll(arrayaux);
//                    arrayaux.clear();
//                    arrayaux.add(p);
//                    aux=p.verApellidos();
//                 }
//                else{
//                    arrayaux.add(p);
//                    arrayaux.sort(nombreCmp);
//                }
//            }
//        }
//        
//        return arrayaux2;
    }

   
    @Override
    public List<Alumno> buscarAlumnos(String apellidos, Comparator<Alumno> apellidoCmp, Comparator<Alumno> nombreCmp) {
        List<Alumno> busquedaAlumnos = new ArrayList<>();
        for(Alumno a : this.verAlumnos(apellidoCmp, nombreCmp)){
            if(a.verApellidos().contains(apellidos)){
                busquedaAlumnos.add(a);
            }
        }
        return busquedaAlumnos;
    }

    @Override
    public List<Alumno> buscarAlumnos(String apellidos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Autor> verAutores(Comparator<Autor> apellidoCmp, Comparator<Autor> nombreCmp) {
        autores.sort(apellidoCmp);

        List<String> apellidosAux = new ArrayList<>();
        for(Autor a : autores){
            if (!apellidosAux.contains(a.verApellidos())){
                apellidosAux.add(a.verApellidos());
            }
        }
        
        List<Autor> autoresOrdenados = new ArrayList<>();
        int i;
        for (i = 0; i < apellidosAux.size(); i++){
            List<Autor> autoresAux = new ArrayList<>();
            for(Autor a : autores){
                if(a.verApellidos().equals(apellidosAux.get(i))){
                    autoresAux.add(a);
                }
            }
            autoresAux.sort(nombreCmp);
            autoresOrdenados.addAll(autoresAux);
        }
        
        return autoresOrdenados;
    }

    @Override
    public List<Alumno> verAlumnos(Comparator<Alumno> apellidoCmp, Comparator<Alumno> nombreCmp) {
        List<Alumno> alumnos = new ArrayList<>();
        for(Autor a : autores){
            if(a instanceof Alumno){
                alumnos.add((Alumno)a);
            }
        }
        alumnos.sort(apellidoCmp);

        List<String> apellidosAux = new ArrayList<>();
        for(Alumno a : alumnos){
            if (!apellidosAux.contains(a.verApellidos())){
                apellidosAux.add(a.verApellidos());
            }
        }
        
        List<Alumno> alumnosOrdenados = new ArrayList<>();
        int i;
        for (i = 0; i < apellidosAux.size(); i++){
            List<Alumno> alumnosAux = new ArrayList<>();
            for(Alumno a : alumnos){
                if(a.verApellidos().equals(apellidosAux.get(i))){
                    alumnosAux.add(a);
                }
            }
            alumnosAux.sort(nombreCmp);
            alumnosOrdenados.addAll(alumnosAux);
        }
        
        return alumnosOrdenados;
    }
    
    

    @Override
    public boolean hayAutoresConEsteGrupo(Grupo grupo) {
        for(Autor a  : autores){
            if(a.mostrarGrupos().contains(grupo)){
                return true;
            }
        }
        return false;
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
    public List<Autor> verAutores() {
        return autores;
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
                return ;
            }
        }
    }
}
