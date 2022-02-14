/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoets;

/**
 *
 * @author Mohamed O. Haroun Zarkik
 */
public class DNIchecker {
    final String LETRAS_DNI= "TRWAGMYFPDXBNJZSQVHLCKE";
    
    /**
     * Constructor sin párametros.
     */
    public DNIchecker(){}
    
    /**
     * Función que devolverá el cáracter número 9 de la String, en principio letra del DNI
     * @param DNI String que contendrá el DNI.
     * @return char que contendrá la letra en el DNI anterior.
     */
    public char extraerLetraDNI (String DNI) {
        return DNI.charAt(8);
    }
    
    /**
     * Función que devolverá las primeras 8 letras de la String, en principio parte numérica del DNI.
     * @param DNI String que contendrá el DNI.
     * @return integer que contendrá la parte numérica del DNI.
     */
    public int extraerNumeroDNI (String DNI) {
        return Integer.parseInt(DNI.substring(0, 8));
    }
    
    /**
     * Función que devolverá la letra válida para un número dado.
     * @param numerosDNI integer que contendrá un número, en principio parte numérica del DNI.
     * @return letra que deberá tener tal secuencia de numérica para un DNI válido.
     */
    public char calcularLetraDNI (int numerosDNI) {
        return LETRAS_DNI.charAt(numerosDNI % 23);
    }
    
    /**
     * Función que responderá si un DNI es válido o no.
     * @param DNI String que contendrá el DNI a revisar.
     * @return boolean que tendrá la respuesta a que si el DNI es válido.
     */
    public boolean validarDNI (String DNI) {
        if (DNI.length() != 9) return false;
        for (int i = 0; i < 8; i++) {
            if (Character.isDigit(DNI.charAt(i)) == false) return false;
        }
        if (Character.isLetter(DNI.charAt(8)) == false) return false;
        char letra = Character.toUpperCase(extraerLetraDNI(DNI));
        int numero = extraerNumeroDNI(DNI);
        char letra2 = calcularLetraDNI(numero);
        if (((calcularLetraDNI(numero) == letra))) return true;
        else return false;
    }
}
