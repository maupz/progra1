/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mauricio.jimenez
 */

public class Calculadora {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        // Variables 
        int opcion = 0;
        Scanner input = new Scanner(System.in);
        
        float n1, n2, resultado;
        String res;
        final float zero = 0;
        // Arreglo-lista para el historial
        ArrayList<String> Historial = new ArrayList<>(); 
        
        while (opcion != 6) {
            // Imprimir menu de opciones
            Calculadora.limpiarPantalla();
            System.out.println("˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜CALCULADORA˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
            System.out.println("1. + SUMA");
            System.out.println("2. - RESTA");
            System.out.println("3. * MULTIPLICACIÓN");
            System.out.println("4. / DIVISIÓN");
            System.out.println("5. VER HISTORIAL DE RESULTADOS");
            System.out.println("6. SALIR");
            
            // Leer opción en la consola
            System.out.println("\nIntroduzca el número de la opción que desee realizar ");
            opcion = input.nextInt();
            
            // Saltar a la opción del menú
            // Leer valores, calcular, almacenar y mostrar resultado, 
            switch (opcion) {
              case 1:
                /* SUMA */
                System.out.println("SUMA");
                System.out.print("sumando 1 = ");
                n1 = input.nextFloat();
                System.out.print("sumando 2 = ");
                n2 = input.nextFloat();
                resultado = n1 + n2;
                res = String.valueOf(n1) + " + " + String.valueOf(n2)+ " = " + String.valueOf(resultado);
                Historial.add(res);
                System.out.println("resultado = " + resultado);
                Calculadora.presioneEnterParaContinuar();
                break;
              case 2:
                /* RESTA */
                System.out.println("RESTA");
                System.out.print("minuendo = ");
                n1 = input.nextFloat();
                System.out.print("sustraendo = ");
                n2 = input.nextFloat();
                resultado = n1 - n2;
                res = String.valueOf(n1) + " - " + String.valueOf(n2)+ " = " + String.valueOf(resultado);
                Historial.add(res);
                System.out.println("resultado = " + resultado);
                Calculadora.presioneEnterParaContinuar();
                break;
              case 3:
                /* MULTIPLICACIÓN */
                System.out.println("MULTIPLICACIÓN");
                System.out.print("factor 1 = ");
                n1 = input.nextFloat();
                System.out.print("factor 2 = ");
                n2 = input.nextFloat();
                resultado = n1 * n2;
                res = String.valueOf(n1) + " x " + String.valueOf(n2)+ " = " + String.valueOf(resultado);
                Historial.add(res);
                System.out.println("resultado = " + resultado);
                Calculadora.presioneEnterParaContinuar();
                break;
              case 4:
                /* DIVISIÓN */
                System.out.println("DIVISIÓN");
                System.out.print("dividendo = ");
                n1 = input.nextFloat();
                System.out.print("divisor = ");
                n2 = input.nextFloat();
                if (n2 != zero) {
                    resultado = n1 / n2;
                    res = String.valueOf(n1) + " / " + String.valueOf(n2)+ " = " + String.valueOf(resultado);
                    Historial.add(res);
                    System.out.println("resultado = " + resultado);
                } else {
                    res = String.valueOf(n1) + " / " + String.valueOf(n2)+ " = ERROR";
                    Historial.add(res);
                    System.out.println("resultado = ERROR");
                }
                Calculadora.presioneEnterParaContinuar();
                break;
              case 5:
                /* HISTORIAL */
                System.out.println("HISTORIAL");
                Historial.forEach((n) -> System.out.println(n));
                Calculadora.presioneEnterParaContinuar();
                break;
              case 6:
                /* SALIR */
                System.out.println("¡FIN!");
                break;
              default:
                System.out.println("La opción introducida es inválida. Intente de nuevo");
            }
        }
    }
    
    // Funcion para limpiar la pantalla
    public static void limpiarPantalla() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    public static void presioneEnterParaContinuar() { 
        System.out.println("Presione Enter para continuar...");
        try
        {
            System.in.read();
        }  
        catch(IOException e)
        {}  
    }
}