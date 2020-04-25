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
    public static void menuOrdenes(ArrayList<Orden> listaOrdenes, ArrayList<Producto> listaProductos) {
        // Variables 
        int opcion = 0;
        int indice = 0;
        int numOrden = 0;
        int numProducto = 0;
        Scanner input = new Scanner(System.in);
        
        while (opcion != 8) {
            // Imprimir menu de opciones
            Restaurante.limpiarPantalla();
            System.out.println("˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
            System.out.println("Información de las Órdenes" + "\n");

            System.out.println("1. Mostrar lista de Órdenes");
            System.out.println("2. Consultar detalles de una orden (Crear Órdenes Primero)");
            System.out.println("3. Nueva orden");
            System.out.println("4. Editar orden");
            System.out.println("5. Agregar PRODUCTO a ORDEN");
            System.out.println("6. Eliminar PRODUCTO de ORDEN");
            System.out.println("7. Eliminar orden");
            System.out.println("8. -> REGRESAR <-");
            
            // Leer opción en la consola
            System.out.println("\nIntroduzca la opción que desee: ");
            opcion = input.nextInt();
            String entrada;
            
            // Saltar a la opción del menú
            switch (opcion) {
              case 1:
                mostrarListaOrdenes(listaOrdenes);
                Restaurante.presioneEnterParaContinuar();
                break;
              case 2:
                mostrarListaOrdenes(listaOrdenes);
                System.out.println("Introduzca el NÚMERO de ORDEN que desee CONSULTAR: ");
                indice = input.nextInt();
                mostrarInfoOrden(listaOrdenes,indice);
                Restaurante.presioneEnterParaContinuar();
                break;
              case 3:
                nuevaOrden(listaOrdenes);
                Restaurante.presioneEnterParaContinuar();
                break;
              case 4:
                mostrarListaOrdenes(listaOrdenes);
                System.out.println("Introduzca el NÚMERO de ORDEN que desee EDITAR: ");
                indice = input.nextInt();
                editarOrden(listaOrdenes,indice);
                Restaurante.presioneEnterParaContinuar();
                break;
              case 5:
                mostrarListaOrdenes(listaOrdenes);
                System.out.println("Introduzca el NUMERO DE ORDEN a la que desea agregar un producto: ");
                numOrden = input.nextInt();
                Producto.mostrarListaProductos(listaProductos);
                System.out.println("Introduzca el NUMERO DE PRODUCTO que desea agregar a la orden: ");
                numProducto = input.nextInt();
                agregarProductoAOrden(listaOrdenes,listaProductos, numOrden, numProducto);
                Restaurante.presioneEnterParaContinuar();
                break;
              case 6:
                mostrarListaOrdenes(listaOrdenes);
                System.out.println("Introduzca el NUMERO DE ORDEN a la que desea quitar un producto: ");
                numOrden = input.nextInt();
                Orden orden = listaOrdenes.get(numOrden);
                ArrayList<Producto> listaProductosOrden = orden.getListaProductos();
                Producto.mostrarListaProductos(listaProductosOrden);
                System.out.println("Introduzca el NUMERO DE PRODUCTO que desea eliminar de la orden: ");
                numProducto = input.nextInt();
                eliminarProductoDeOrden(listaOrdenes,listaProductos, numOrden, numProducto);
                Restaurante.presioneEnterParaContinuar();
                break;
              case 7:
                System.out.println("Introduzca el NÚMERO de ORDEN que desee ELIMINAR: ");
                indice = input.nextInt();
                eliminarOrden(listaOrdenes,indice);
                break;
              case 8: 
                System.out.println("Regresar...");
                break;
              default:
                System.out.println("La opción introducida es inválida. Intente de nuevo");
            }
        }
    }
    
    
    /**
     * Desplegar una lista de empleados
     * @param listaOrdenes
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
    }
    
     /**
     * Desplegar detalles de una orden
     * @param listaOrdenes
     * @param numOrden
     */
    public static void mostrarInfoOrden(ArrayList<Orden> listaOrdenes, int numOrden){
        Restaurante.limpiarPantalla();
        System.out.println("+++++++++++++++++++");
        System.out.println("DETALLES DE LA ORDEN" + numOrden);
        
        Orden orden = listaOrdenes.get(numOrden);
        ArrayList<Producto> listaProductos = orden.getListaProductos();
        
        System.out.println("Nombre:" + orden.getNombreCliente());
        System.out.println("Total:" + orden.calcularTotal(orden));
        Producto.mostrarListaProductos(listaProductos);
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
        
        
    }
    
    /**
     * Agregar producto a una orden 
     * @param listaProductos
     * @param indice
     */
    private static void agregarProductoAOrden(ArrayList<Orden> listaOrdenes, ArrayList<Producto> listaProductos, int numOrden, int numProducto) {
        System.out.println("Agregando producto " + numProducto +  " a la orden número: " + numOrden);
        
        try
        {
            Orden orden = listaOrdenes.get(numOrden);
            Producto producto = listaProductos.get(numProducto);
            ArrayList<Producto> productosDeLaOrden = orden.getListaProductos();
            productosDeLaOrden.add(producto);
            orden.setListaProductos(productosDeLaOrden);
            listaOrdenes.set(numOrden, orden);
            System.out.println("-> Producto añadido ");
            
        }  
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("Posible error en los parámetros de entrada");
        } 
    }
    
    
    /**
     * Eliminar producto de una orden 
     * @param listaOrdenes
     * @param listaProductos
     * @param numOrden
     * @param numProducto
     */
    private static void eliminarProductoDeOrden(ArrayList<Orden> listaOrdenes, ArrayList<Producto> listaProductos, int numOrden, int numProducto) {
        System.out.println("Eliminando producto " + numProducto +  " de la orden número: " + numOrden);
        
        try
        {
            Orden orden = listaOrdenes.get(numOrden);
            Producto producto = listaProductos.get(numProducto);
            ArrayList<Producto> productosDeLaOrden = orden.getListaProductos();
            productosDeLaOrden.remove(numProducto);
            orden.setListaProductos(productosDeLaOrden);
            listaOrdenes.set(numOrden, orden);
            System.out.println("-> Producto eliminado de la orden ");
            
        }  
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("Posible error en los parámetros de entrada");
        } 
    }
    
    /**
     * Editar detalles de una orden 
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
        
        
    }
    /**
     * Get the value of total
     *
     * @return the value of total
     */
    public float getTotal() {
        return this.total;
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
     * Calculate the value of total
     *
     * @param orden
     * @return 
     */
    public float calcularTotal(Orden orden) {
        ArrayList<Producto> listaProductosOrden = orden.getListaProductos();
        this.total = 0;
        listaProductosOrden.forEach ( (prod) -> this.total = this.total + prod.getPrecio() );
        return this.total;
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
    
    /**
     * Obtener la lista de productos de una orden
     *
     * @return listaProductos
     */
    public ArrayList<Producto> getListaProductos() {
        return this.listaProductos;
    }

    /**
     * Definir lista de productos de la orden
     *
     * @param Nombre new value of Nombre
     */
    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    } 
     
}
