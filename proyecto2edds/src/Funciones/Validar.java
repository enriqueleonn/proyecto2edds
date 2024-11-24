/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

/**
 *
 * @author Enrique León
 */
public class Validar {
    private boolean validarnumeros (String num) {
        return num.matches ("[0-9]*");
    }
    
    public int ValidarNumeros (String numero) {
        if (validarnumeros (numero)== true) {
            int num = Integer.parseInt(numero);
            return num;
        }
        else{
            return -1;
        }
    }
    
    public boolean validarIndice (int max, int min, int indice){
        return indice >= min && indice<= max; 
    }
}
