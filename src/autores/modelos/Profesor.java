/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

public class Profesor {
    private int dni;
    private String apellidos;
    private String nombres;
    private String clave;
    private String cargo;

    public Profesor(int dni, String apellidos, String nombres, String clave, String cargo) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.clave = clave;
        this.cargo = cargo;
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

    public String verCargo() {
        return cargo;
    }

    public void asignarCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public void mostrar() {
        System.out.println("Profesor: " + this.verApellidos() + ", " + this.verNombres());
        System.out.println("DNI: " + this.verDni());
        System.out.println("Cargo: " + this.verCargo());
        System.out.println("Clave: " + this.verClave() + "\n");
    }
}
