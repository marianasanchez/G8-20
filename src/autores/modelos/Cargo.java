/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

/**
 *
 * @author rodrigo
 */
public enum Cargo {
    TITULAR,
    ASOCIADO,
    ADJUNTO,
    JTP,
    ADG;
    
    public static Cargo getTITULAR() {    
        return TITULAR;
    }

    public static Cargo getASOCIADO() {
        return ASOCIADO;
    }

    public static Cargo getADJUNTO() {
        return ADJUNTO;
    }

    public static Cargo getJTP() {
        return JTP;
    }

    public static Cargo getADG() {
        return ADG;
    }
    
    public static String toString(Cargo c) {
        switch (c) {
            case TITULAR:
                return "TITULAR";
            case ASOCIADO:
                return "ASOCIADO";
            case ADJUNTO:
                return "ADJUNTO";
            case JTP:
                return "JTP";
            case ADG:
                return "ADG";
            default:
                return "";
        }
    }
    
    public static Cargo toCargo(String s) {
        switch (s) {
            case "TITULAR":
                return TITULAR;
            case "ASOCIADO":
                return ASOCIADO;
            case "ADJUNTO":
                return ADJUNTO;
            case "JTP":
                return JTP;
            case "ADG":
                return ADG;
            default:
                return TITULAR;
        }
    }
}
