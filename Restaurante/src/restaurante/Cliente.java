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
public class Cliente {
    private String nombre;
    private String apellido;
    private String telefono;

    
    public Cliente(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    
    // Constructor default
    public Cliente() {
        this.nombre = "Juan";
        this.apellido = "Pérez";
        this.telefono = "111";
    }
    
    // Menú de opciones para empleados
    public static void menuClientes(ArrayList<Cliente> listaClientes) {
            // Variables 
        int opcion = 0;
        int indice = 0;
        Scanner input = new Scanner(System.in);
        
        while (opcion != 5) {
            // Imprimir menu de opciones
            Restaurante.limpiarPantalla();
            System.out.println("˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
            System.out.println("Información de los Clientes" + "\n");

            System.out.println("1. Mostrar lista de clientes");
            System.out.println("2. Ver detalles de un cliente");
            System.out.println("3. Agregar cliente");
            System.out.println("4. Editar cliente");
            System.out.println("5. Remover cliente");
            System.out.println("6. -> REGRESAR <-");
            
            // Leer opción en la consola
            System.out.println("\nIntroduzca la opción que desee: ");
            opcion = input.nextInt();
            String entrada;
            
            // Saltar a la opción del menú
            switch (opcion) {
              case 1:
                mostrarListaClientes(listaClientes);
                break;
              case 2:
                System.out.println("Introduzca el NÚMERO de cliente que desee CONSULTAR: ");
                indice = input.nextInt();
                mostrarInfoClientes(listaClientes,indice);
                break;
              case 3:
                agregarCliente(listaClientes);
                break;
              case 4:
                System.out.println("Introduzca el NÚMERO de cliente que desee EDITAR: ");
                indice = input.nextInt();
                editarCliente(listaClientes,indice);
                break;
              case 5:
                System.out.println("Introduzca el NÚMERO de cliente que desee ELIMINAR: ");
                indice = input.nextInt();
                eliminarCliente(listaClientes,indice);
                System.out.println("Regresar...");
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
     * @param listaClientes
     */
    public static void mostrarListaClientes(ArrayList<Cliente> listaClientes){
        Restaurante.limpiarPantalla();
        System.out.println("+++++++++++++++++++");
        System.out.println("LISTA DE CLIENTES:");
        
        int i=0;
        for (Cliente cliente : listaClientes) {
            System.out.println(i + ". " + cliente.getNombre());
            i++;
        }
        Restaurante.presioneEnterParaContinuar();
    }
    
     /**
     * Desplegar detalles de un empleado
     * @param listaClientes
     * @param indice
     */
    public static void mostrarInfoClientes(ArrayList<Cliente> listaClientes, int indice){
        Restaurante.limpiarPantalla();
        System.out.println("+++++++++++++++++++");
        System.out.println("DETALLES DEL CLIENTE" + indice);
        
        Cliente cliente = listaClientes.get(indice);
        System.out.println("Nombre:" + cliente.getNombre());
        System.out.println("Apellido:" + cliente.getApellido());
        System.out.println("Telefono:" + cliente.getTelefono());
        
        Restaurante.presioneEnterParaContinuar();
    }
    
     /**
     * Agregar un empleado
     * @param listaClientes
     */
    public static void agregarCliente(ArrayList<Cliente> listaClientes){
        Restaurante.limpiarPantalla();
        
        Scanner input = new Scanner(System.in);
        System.out.println("AGREGAR NUEVO CLIENTE");
        //Empleado nuevoEmpleado = new Cliente();
        System.out.println("Introduzca el nombre del nuevo cliente: ");
        String nom = input.next();
        System.out.println("Introduzca el apellido del nuevo cliente: ");
        String ap = input.next();
        System.out.println("Introduzca el teléfono del nuevo cliente: ");
        String tel = input.next();
        Cliente nuevoCliente = new Cliente(nom, ap, tel);
        listaClientes.add(nuevoCliente);
        System.out.println("-> Nuevo cliente agregado");
        
        Restaurante.presioneEnterParaContinuar();
    }
    
    /**
     * Editar detalles de un empleado
     * @param listaClientes
     * @param indice
     */
    private static void editarCliente(ArrayList<Cliente> listaClientes, int indice) {
        Restaurante.limpiarPantalla();
        
        Scanner input = new Scanner(System.in);
        System.out.println("EDITAR CLIENTE NÚMERO " + indice);
        //Empleado nuevoEmpleado = new Cliente();
        System.out.println("Introduzca el NUEVO NOMBRE del cliente: ");
        String nom = input.next();
        System.out.println("Introduzca el NUEVO APELLIDO del cliente: ");
        String ap = input.next();
        System.out.println("Introduzca el NUEVO TELÉFONO del cliente: ");
        String tel = input.next();
        Cliente nuevoCliente = new Cliente(nom, ap, tel);
        
        listaClientes.remove(indice);
        listaClientes.add(indice, nuevoCliente);
        
        System.out.println("-> Cliente EDITADO");
        
        Restaurante.presioneEnterParaContinuar();
    }
    
    /**
     * Editar detalles de un empleado
     * @param listaEmpleados
     * @param indice
     */
    private static void eliminarCliente(ArrayList<Cliente> listaClientes, int indice) {
        Restaurante.limpiarPantalla();
        
        listaClientes.remove(indice);
        
        System.out.println("-> Cliente Eliminado <-");
        
        Restaurante.presioneEnterParaContinuar();
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
     * Get the value of Apellido
     *
     * @return the value of Apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Set the value of Apellido
     *
     * @param Apellido new value of Apellido
     */
    public void setApellido(String Apellido) {
        this.apellido = Apellido;
    }

    /**
     * Get the value of Nombre
     *
     * @return the value of Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of Nombre
     *
     * @param Nombre new value of Nombre
     */
    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }
}