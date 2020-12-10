package grupos.modelos;

public enum Rol {
    ADMINISTRADOR("Administrador"),
    COLABORADOR("Colaborador");
    
    private String valor;
    
    private Rol(String valor){
        this.valor = valor;
    }
    
    public static Rol getADMINISTRADOR() {    
        return ADMINISTRADOR;
    }

    public static Rol getCOLABORADOR() {
        return COLABORADOR;
    }

    @Override
    public String toString() {
        return this.valor; //To change body of generated methods, choose Tools | Templates.
    }
    
    public static Rol toRol(String s) {
        switch (s) {
            case "ADMINISTRADOR":
                return ADMINISTRADOR;
            default:
                return COLABORADOR;
        }
    }
}
