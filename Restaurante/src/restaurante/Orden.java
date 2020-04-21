/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mauricio.jimenez
 */
public class Orden {;
    // Elementos que componen una orden
    private float total;
    private String nombreCliente;
    ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    
    // Constructor default
    public Orden() {
        this.total = 0;
    }
    
    // Constructor default
    public Orden(String nombreCliente, float total) {
        this.nombreCliente = nombreCliente;
        this.total = total;
    }
    
    // Menú de opciones para empleados
    public static void menuOrdenes(ArrayList<Orden> listaOrdenes) {
        // Variables 
        int opcion = 0;
        int indice = 0;
        Scanner input = new Scanner(System.in);
        
        while (opcion != 5) {
            // Imprimir menu de opciones
            Restaurante.limpiarPantalla();
            System.out.println("˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
            System.out.println("Información de las Órdenes" + "\n");

            System.out.println("1. Mostrar lista de Órdenes");
            System.out.println("2. Consultar detalles de una orden (Crear Órdenes Primero)");
            System.out.println("3. Nueva orden");
            System.out.println("4. Editar orden");
            System.out.println("5. Eliminar orden");
            System.out.println("6. -> REGRESAR <-");
            
            // Leer opción en la consola
            System.out.println("\nIntroduzca la opción que desee: ");
            opcion = input.nextInt();
            String entrada;
            
            // Saltar a la opción del menú
            switch (opcion) {
              case 1:
                mostrarListaOrdenes(listaOrdenes);
                break;
              case 2:
                System.out.println("Introduzca el NÚMERO de ORDEN que desee CONSULTAR: ");
                indice = input.nextInt();
                mostrarInfoOrden(listaOrdenes,indice);
                break;
              case 3:
                nuevaOrden(listaOrdenes);
                break;
              case 4:
                System.out.println("Introduzca el NÚMERO de ORDEN que desee EDITAR: ");
                indice = input.nextInt();
                editarOrden(listaOrdenes,indice);
                break;
              case 5:
                System.out.println("Introduzca el NÚMERO de ORDEN que desee ELIMINAR: ");
                indice = input.nextInt();
                eliminarOrden(listaOrdenes,indice);
                break;
              case 6: 
                System.out.println("Regresar...");
                break;
              default:
                System.out.println("La opción introducida es inválida. Intente de nuevo");
            }
        }
    }
    
    
    /**
     * Desplegar una lista de empleados
     * @param listaProductos
     */
    public static void mostrarListaOrdenes(ArrayList<Orden> listaOrdenes){
        Restaurante.limpiarPantalla();
        System.out.println("+++++++++++++++++++");
        System.out.println("LISTA DE ORDENES:");
        
        int i=0;
        for (Orden orden : listaOrdenes) {
            System.out.println(i + ". " + orden.getNombreCliente());
            i++;
        }
        Restaurante.presioneEnterParaContinuar();
    }
    
     /**
     * Desplegar detalles de una orden
     * @param listaOrdenes
     * @param indice
     */
    public static void mostrarInfoOrden(ArrayList<Orden> listaOrdenes, int indice){
        Restaurante.limpiarPantalla();
        System.out.println("+++++++++++++++++++");
        System.out.println("DETALLES DE LA ORDEN" + indice);
        
        Orden orden = listaOrdenes.get(indice);
        System.out.println("Nombre:" + orden.getNombreCliente());
        System.out.println("Total:" + orden.getTotal());
        
        Restaurante.presioneEnterParaContinuar();
    }
    
     /**
     * Crear una orden
     * @param listaOrdenes
     */
    public static void nuevaOrden(ArrayList<Orden> listaOrdenes){
        Restaurante.limpiarPantalla();
        
        Scanner input = new Scanner(System.in);
        System.out.println("CREAR NUEVA ORDEN");
        //Empleado nuevoEmpleado = new Cliente();
        System.out.println("Introduzca el NOMBRE del CLIENTE de esta orden: ");
        String nombre = input.next();
        Orden nuevaOrden = new Orden(nombre, 0);
        listaOrdenes.add(nuevaOrden);
        System.out.println("-> Nueva orden agregada");
        
        Restaurante.presioneEnterParaContinuar();
    }
    
    /**
     * Editar detalles de un empleado
     * @param listaProductos
     * @param indice
     */
    private static void editarOrden(ArrayList<Orden> listaOrdenes, int indice) {
        Restaurante.limpiarPantalla();
        
        Scanner input = new Scanner(System.in);
        System.out.println("EDITAR ORDEN NÚMERO " + indice);
        System.out.println("Introduzca el NOMBRE  del CLIENTE: ");
        String nom = input.next();
        System.out.println("Introduzca el PRECIO TOTAL de la ORDEN: ");
        float total = input.nextFloat();
        Orden nuevaOrden = new Orden(nom, total);
        
        listaOrdenes.set(indice, nuevaOrden);
        //listaProductos.remove(indice);
        //listaProductos.add(indice, nuevoProducto);
        
        System.out.println("-> ORDEN EDITADA ");
        
        Restaurante.presioneEnterParaContinuar();
    }
    
    /**
     * Editar detalles de un orden
     * @param listaOrdenes
     * @param indice
     */
    private static void eliminarOrden(ArrayList<Orden> listaOrdenes, int indice) {
        Restaurante.limpiarPantalla();
        
        listaOrdenes.remove(indice);
        
        System.out.println("-> ORDEN ELIMINADA <-");
        
        Restaurante.presioneEnterParaContinuar();
    }
    /**
     * Get the value of total
     *
     * @return the value of total
     */
    public float getTotal() {
        return total;
    }

    /**
     * Set the value of total
     *
     * @param total new value of total
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * Get the value of Nombre
     *
     * @return the value of Nombre
     */
    public String getNombreCliente() {
        return this.nombreCliente;
    }

    /**
     * Set the value of Nombre
     *
     * @param Nombre new value of Nombre
     */
    public void setNombreCliente(String Nombre) {
        this.nombreCliente = Nombre;
    }    
}
