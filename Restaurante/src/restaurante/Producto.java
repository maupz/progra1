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
 * @author Leno
 */
public class Producto {
    private String nombre;
    private float precio;
    
    public Producto(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;

    }
    
    // Constructor default
    public Producto() {
        this.nombre = "Arroz con Pollo";
        this.precio = 5000;
    }
    
    // Menú de opciones para empleados
    public static void menuProductos(ArrayList<Producto> listaProductos) {
            // Variables 
        int opcion = 0;
        int indice = 0;
        Scanner input = new Scanner(System.in);
        
        while (opcion != 5) {
            // Imprimir menu de opciones
            Restaurante.limpiarPantalla();
            System.out.println("˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
            System.out.println("Información de los Productos" + "\n");
            // TODO: Cambiar orden de las opciones, agregar primero.
            System.out.println("1. Mostrar lista de Productos");
            System.out.println("2. Ver detalles de un Productos (Agregar Productos Primero)");
            System.out.println("3. Agregar Productos");
            System.out.println("4. Editar Productos");
            System.out.println("5. Remover Productos");
            System.out.println("6. -> REGRESAR <-");
            
            // Leer opción en la consola
            System.out.println("\nIntroduzca la opción que desee: ");
            opcion = input.nextInt();
            String entrada;
            
            // Saltar a la opción del menú
            switch (opcion) {
              case 1:
                mostrarListaProductos(listaProductos);
                break;
              case 2:
                System.out.println("Introduzca el NÚMERO de producto que desee CONSULTAR: ");
                indice = input.nextInt();
                mostrarInfoProducto(listaProductos,indice);
                break;
              case 3:
                agregarProducto(listaProductos);
                break;
              case 4:
                System.out.println("Introduzca el NÚMERO de producto que desee EDITAR: ");
                indice = input.nextInt();
                editarProducto(listaProductos,indice);
                break;
              case 5:
                System.out.println("Introduzca el NÚMERO de producto que desee ELIMINAR: ");
                indice = input.nextInt();
                eliminarProducto(listaProductos,indice);
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
    public static void mostrarListaProductos(ArrayList<Producto> listaProductos){
        Restaurante.limpiarPantalla();
        System.out.println("+++++++++++++++++++");
        System.out.println("LISTA DE PRODUCTOS:");
        
        int i=0;
        for (Producto producto : listaProductos) {
            System.out.println(i + ". " + producto.getNombre());
            i++;
        }
        Restaurante.presioneEnterParaContinuar();
    }
    
     /**
     * Desplegar detalles de un empleado
     * @param listaProductos
     * @param indice
     */
    public static void mostrarInfoProducto(ArrayList<Producto> listaProductos, int indice){
        Restaurante.limpiarPantalla();
        System.out.println("+++++++++++++++++++");
        System.out.println("DETALLES DEL PRODUCTO" + indice);
        
        Producto producto = listaProductos.get(indice);
        System.out.println("Nombre:" + producto.getNombre());
        System.out.println("Precio:" + producto.getPrecio());
        
        Restaurante.presioneEnterParaContinuar();
    }
    
     /**
     * Agregar un empleado
     * @param listaProductos
     */
    public static void agregarProducto(ArrayList<Producto> listaProductos){
        Restaurante.limpiarPantalla();
        
        Scanner input = new Scanner(System.in);
        System.out.println("AGREGAR NUEVO PRODUCTO");
        //Empleado nuevoEmpleado = new Cliente();
        System.out.println("Introduzca el nombre del nuevo producto: ");
        String nom = input.next();
        System.out.println("Introduzca el precio del nuevo producto: ");
        float precio = input.nextFloat();
        Producto nuevoProducto = new Producto(nom, precio);
        listaProductos.add(nuevoProducto);
        System.out.println("-> Nuevo producto agregado");
        
        Restaurante.presioneEnterParaContinuar();
    }
    
    /**
     * Editar detalles de un empleado
     * @param listaProductos
     * @param indice
     */
    private static void editarProducto(ArrayList<Producto> listaProductos, int indice) {
        Restaurante.limpiarPantalla();
        
        Scanner input = new Scanner(System.in);
        System.out.println("EDITAR PRODUCTO NÚMERO " + indice);
        //Empleado nuevoEmpleado = new Cliente();
        System.out.println("Introduzca el NUEVO NOMBRE  del producto: ");
        String nom = input.next();
        System.out.println("Introduzca el NUEVO PRECIO del producto: ");
        float precio = input.nextFloat();
        Producto nuevoProducto = new Producto(nom, precio);
        
        listaProductos.remove(indice);
        listaProductos.add(indice, nuevoProducto);
        
        System.out.println("-> Producto EDITADO");
        
        Restaurante.presioneEnterParaContinuar();
    }
    
    /**
     * Editar detalles de un empleado
     * @param listaProductos
     * @param indice
     */
    private static void eliminarProducto(ArrayList<Producto> listaProductos, int indice) {
        Restaurante.limpiarPantalla();
        
        listaProductos.remove(indice);
        
        System.out.println("-> Producto Eliminado <-");
        
        Restaurante.presioneEnterParaContinuar();
    }
    /**
     * Get the value of Apellido
     *
     * @return the value of Apellido
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Set the value of Apellido
     *
     * @param precio new value of Apellido
     */
    public void setPrecio(float precio) {
        this.precio = precio;
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