/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import java.util.Objects;

public class Alumno extends Autor  {
   // private int dni;
   // private String apellidos;
   // private String nombres;
   // private String clave;
    private String cx;

    public Alumno(int dni, String apellidos, String nombres, String clave, String cx) {
        super(dni, apellidos, nombres, clave);
//        this.dni = dni;
//        this.apellidos = apellidos;
//        this.nombres = nombres;
//        this.clave = clave;
        this.cx = cx;
    }
    
    

   /* public int verDni() {
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
    */
    public String verCx() {
        return cx;
    }

    public void asignarCx(String cx) {
        this.cx = cx;
    }

    @Override
    public boolean equals(Object obj) {

        
        if (!super.equals(obj)){
   
            if(obj instanceof Alumno){

                return Objects.equals(this.cx, ((Alumno)obj).verCx());
            }
            else
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.cx);
        return hash;
    }

  
    
    @Override
    public void mostrar() {
//        System.out.println("Alumno: " + this.verApellidos() + ", " + this.verNombres());
//        System.out.println("DNI: " + this.verDni());
//        System.out.println("CX: " + this.verCx());
        //System.out.println("[" + this.verDni()+"] "+ this.verApellidos() +", "+this.verNombres()+ "\n");
        super.mostrar();
        System.out.println("CX: " + this.verCx() + "\n");
    }
}
