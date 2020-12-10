package lugares.modelos;

import java.util.Objects;

public class Lugar implements Comparable<Lugar>{
    private String nombre;

    public Lugar(String nombre) {
        this.nombre = nombre;
    }
    
    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
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
        final Lugar other = (Lugar) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    public String toString() {
        return "Lugar: " + this.nombre;
    }
    
    public void Mostrar() {
        System.out.println(this.toString());
    }

    @Override
    public int compareTo(Lugar l) {
        return this.verNombre().compareTo(l.verNombre());
    }
}
