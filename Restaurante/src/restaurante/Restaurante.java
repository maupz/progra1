/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mauricio.jimenez
 */
public class Restaurante {

    /**
     * @param args the command line arguments
     */
    private String nombreRestaurante;
    private String telefono;  
    private String direccion;
    

    

    
    // Rutina principal del Restaurante
    // Menú de Bienvenida
    public static void main(String[] args) {
        // Variables y listas de objetos
        Restaurante miRestaurante = new Restaurante();
        // Crear listas de elementos del restaurante AQUÍ:
        // Crear lista de empleados
        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        ArrayList<Orden> listaOrdenes = new ArrayList<Orden>();
        // lista Empleados;
        // lista Clientes;
        // lista Productos;
        // lista Órdenes;
        
        int opcion = 0;
        
        while (opcion != 6) {
            // Imprimir menu de opciones
            Restaurante.limpiarPantalla();
            System.out.println("-----------------------------------------------");
            System.out.println("¡Bienvenido al Restaurante " + miRestaurante.getNombreRestaurante() + "!\n");

            System.out.println("1. Información del Restaurante");
            System.out.println("2. Administración de Empleados");
            System.out.println("3. Administración de Clientes Frecuentes");
            System.out.println("4. Administración de Productos");
            System.out.println("5. -> ÓRDENES AQUÍ <-");
            System.out.println("6. Salir");
            
            
            // Leer opción en la consola
            System.out.println("\nIntroduzca la opción a la que desea ingresar: ");

            Scanner input = new Scanner(System.in);
            opcion = input.nextInt();
            
            // Saltar a la opción del menú
            switch (opcion) {
              case 1:
                miRestaurante.menuRestaurante();
                break;
              case 2:
                Empleado.menuEmpleados(listaEmpleados);
                break;
              case 3:
                Cliente.menuClientes(listaClientes);
                break;
              case 4:
                Producto.menuProductos(listaProductos);
                break;
              case 5:
                Orden.menuOrdenes(listaOrdenes,listaProductos);
                break;
              case 6:
                System.out.println("¡GRACIAS POR SU VISITA!");
                break;
              default:
                System.out.println("La opción introducida es inválida. Intente de nuevo");
            }
        }
    }
    
     /**
     * Imprimir Menú de edición de atributos del restaurante
     *
     */
    public void menuRestaurante() {
            // Variables 
        int opcion = 0;
        Scanner input = new Scanner(System.in);
        
        while (opcion != 5) {
            // Imprimir menu de opciones
            Restaurante.limpiarPantalla();
            System.out.println("˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
            System.out.println("Información del Restaurante " + this.getNombreRestaurante() + "\n");

            System.out.println("1. Mostrar información del restaurante");
            System.out.println("2. Cambiar nombre del Restaurante");
            System.out.println("3. Editar número de teléfono");
            System.out.println("4. Editar dirección");
            System.out.println("5. -> REGRESAR <-");
            
            // Leer opción en la consola
            System.out.println("\nIntroduzca la opción que desee: ");
            opcion = input.nextInt();
            String entrada;
            
            // Saltar a la opción del menú
            switch (opcion) {
              case 1:
                System.out.println("Nombre del Restaurante: " + this.getNombreRestaurante());
                System.out.println("Teléfono: " + this.getTelefono());
                System.out.println("Dirección: " + this.getDireccion() );
                Restaurante.presioneEnterParaContinuar();
                break;
              case 2:
                System.out.println("Introduzca el nuevo nombre del restaurante: ");
                entrada = input.next();
                this.setNombreRestaurante(entrada);
                System.out.println("Nuevo nombre registrado: " + this.getNombreRestaurante());
                Restaurante.presioneEnterParaContinuar();
                break;
              case 3:
                System.out.println("Introduzca el nuevo número de teléfono: ");
                this.setTelefono(input.next());
                System.out.println("Nuevo teléfono registrado: " + this.getTelefono());
                Restaurante.presioneEnterParaContinuar();
                break;
              case 4:
                System.out.println("Introduzca la nueva dirección: ");
                String detalle = input.next();
                this.setDireccion(detalle);
                System.out.println("Nueva dirección registrada: " + this.getDireccion());
                Restaurante.presioneEnterParaContinuar();
                break;
              case 5:
                System.out.println("regresar...");
                break;
              default:
                System.out.println("La opción introducida es inválida. Intente de nuevo");
            }
        }
    }

    public Restaurante() {
        this.nombreRestaurante = "Hummus";
        this.telefono = "22860101";  
        this.direccion = "Pérez Zeledón";
    }

    /**"
     * Get the value of nombreRest
     *
     * @return the value of nombreRest
     */
    
    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    /**
     * Set the value of nombreRest
     *
     * @param nombreRest new value of nombreRest
     */
    public void setNombreRestaurante(String nombreRest) {
        this.nombreRestaurante = nombreRest;
    }
    
    /**
     * Get the value of telefono
     *
     * @return the value of telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Set the value of telefono
     *
     * @param telefono new value of telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**
     * Get the value of direccion
     *
     * @return the value of direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Set the value of direccion
     *
     * @param direccion new value of direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    public static void limpiarPantalla() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
