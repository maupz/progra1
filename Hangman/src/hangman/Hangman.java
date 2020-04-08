/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mauricio.jimenez
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Variables
        boolean gameOver = false, win = false;
        boolean letraEncontrada = false;
        int intentos = 5, letrasDescubiertas = 0;
        
        // Bienvenida
        System.out.println("Hangman!\n\nIntroduzca una palabra para jugar: ");
        Scanner in = new Scanner(System.in);
        String palabra = in.nextLine();
        System.out.println("La palabra a adivinar es: "+palabra);
        System.out.println("\nIniciando juego... Tiene 5 intentos.");
        
        // Crear arreglo de caracteres del tamano del string + variable de Juego
        char[] arrPalabra = new char[palabra.length()];
        char[] arrJugador = new char[palabra.length()];
        Arrays.fill(arrJugador, '_');
        
        // Llenar el arreglo con los caracteres del string 
        for (int i = 0; i < palabra.length(); i++) { 
            arrPalabra[i] = palabra.charAt(i); 
        }
        
        // Condiciones para seguir jugando
        while ( (gameOver == false) && (win == false) && (intentos > 0) ) {
            System.out.println("Introduzca un caracter: ");
            char caracter = in.next().charAt(0);
            letraEncontrada = false;
            
            // Buscar caracteres en el arreglo
            for (int j = 0; j< arrPalabra.length; j++) {
                if ( (arrPalabra[j] == caracter))  {
                    arrJugador[j] = caracter;
                    letrasDescubiertas++;
                    letraEncontrada = true;
                    System.out.println("Letra descubierta: "+caracter);
                    // Imprimir arrJugador
                    System.out.println(java.util.Arrays.toString(arrJugador));
                }
            }
            if (!letraEncontrada) {
                intentos--;
                System.out.println("¡Esa letra no está! Intentos restantes: "+intentos);
                // Imprimir arrJugador
                System.out.println(java.util.Arrays.toString(arrJugador));
            }
            
            // Determinar sin perdió o ganó
            if (intentos == 0){ 
                gameOver = true;
                System.out.println("¡perdiste! :( ");
                break;
            }
            if (letrasDescubiertas == arrPalabra.length) { 
                win = true;
                System.out.println("¡GANASTE! :) ");
                break;
            }
        }
    }
    
}
