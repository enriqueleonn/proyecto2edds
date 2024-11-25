/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

/**
 * La clase Validar proporciona métodos para validar números y 
 * verificar índices dentro de un rango específico.
 * 
 * @author Enrique León
 */
public class Validar {
    /**
     * Valida si una cadena contiene solo dígitos numéricos.
     * 
     * @param num La cadena a validar.
     * @return true si la cadena solo contiene dígitos; false en caso contrario.
     */
    private boolean validarnumeros (String num) {
        return num.matches ("[0-9]*");
    }
    /**
     * Valida y convierte una cadena a un número entero.
     * 
     * @param numero La cadena que representa un número.
     * @return El número entero si la cadena es válida; -1 si no es válida.
     */
    public int ValidarNumeros (String numero) {
        if (validarnumeros (numero)== true) {
            int num = Integer.parseInt(numero);
            return num;
        }
        else{
            return -1;
        }
    }
    /**
     * Verifica si un índice está dentro de un rango definido por valores mínimo y máximo.
     * 
     * @param max El valor máximo del rango.
     * @param min El valor mínimo del rango.
     * @param indice El índice a validar.
     * @return true si el índice está dentro del rango; false en caso contrario.
     */
    public boolean validarIndice (int max, int min, int indice){
        return indice >= min && indice<= max; 
    }
}
