/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

public class Profesor extends Autor{
   // private int dni;
    //private String apellidos;
    //private String nombres;
    //private String clave;
    private Cargo cargo;

    public Profesor(int dni, String apellidos, String nombres, String clave, Cargo cargo) {
        super(dni, apellidos, nombres, clave);
        //this.dni = dni;
        //this.apellidos = apellidos;
        //this.nombres = nombres;
        //this.clave = clave;
        this.cargo = cargo;
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
    public Cargo verCargo() {
        return cargo;
    }

    public void asignarCargo(Cargo cargo) {
        this.cargo = cargo;
    }

//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 53 * hash + this.dni;
//        return hash;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Profesor other = (Profesor) obj;
//        if (this.dni != other.dni) {
//            return false;
//        }
//        return true;
//    }
    
    @Override
    public void mostrar() {
       /* System.out.println("Profesor: " + this.verApellidos() + ", " + this.verNombres());
        System.out.println("DNI: " + this.verDni());
        System.out.println("Cargo: " + this.verCargo());
        System.out.println("Clave: " + this.verClave() + "\n");*/
        //System.out.println("[" + this.verDni()+"] "+ this.verApellidos() +", "+this.verNombres()+ "\n");
        super.mostrar();
        System.out.println("Cargo: " + this.verCargo()+ "\n");
    }
}
