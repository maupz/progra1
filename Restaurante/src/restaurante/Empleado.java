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
public class Empleado {
    
    // Atributos
    private String nombre;
    private String apellido;
    private String telefono;
    private String rol;
    private String horario;
   
    // Constructores
    public Empleado(String nombre, String apellido, String telefono, String rol, String horario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.rol = rol;
        this.horario = horario;
    }
    
    // Constructor default
    public Empleado() {
        this.nombre = "Juan";
        this.apellido = "Pérez";
        this.telefono = "111";
        this.rol = "Cocinero";
        this.horario = "Mañana y tarde";
        
    }
    
    // Menú de opciones para empleados
    public static void menuEmpleados(ArrayList<Empleado> listaEmpleados) {
            // Variables 
        int opcion = 0;
        int indice = 0;
        Scanner input = new Scanner(System.in);
        
        while (opcion != 5) {
            // Imprimir menu de opciones
            Restaurante.limpiarPantalla();
            System.out.println("˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
            System.out.println("Información del Personal" + "\n");

            System.out.println("1. Mostrar lista de empleados");
            System.out.println("2. Ver detalles de empleado");
            System.out.println("3. Agregar empleado");
            System.out.println("4. Editar empleado");
            System.out.println("5. Remover empleado");
            System.out.println("6. -> REGRESAR <-");
            
            // Leer opción en la consola
            System.out.println("\nIntroduzca la opción que desee: ");
            opcion = input.nextInt();
            String entrada;
            
            // Saltar a la opción del menú
            switch (opcion) {
              case 1:
                mostrarListaEmpleados(listaEmpleados);
                break;
              case 2:
                System.out.println("Introduzca el NÚMERO de empleado que desee CONSULTAR: ");
                indice = input.nextInt();
                mostrarInfoEmpleado(listaEmpleados,indice);
                break;
              case 3:
                agregarEmpleado(listaEmpleados);
                break;
              case 4:
                System.out.println("Introduzca el NÚMERO de empleado que desee EDITAR: ");
                indice = input.nextInt();
                editarEmpleado(listaEmpleados,indice);
                break;
              case 5:
                System.out.println("regresar...");
                break;
              default:
                System.out.println("La opción introducida es inválida. Intente de nuevo");
            }
        }
    }
    
    
    /**
     * Desplegar una lista de empleados
     * @param listaEmpleados
     */
    public static void mostrarListaEmpleados(ArrayList<Empleado> listaEmpleados){
        Restaurante.limpiarPantalla();
        System.out.println("+++++++++++++++++++");
        System.out.println("LISTA DE EMPLEADOS:");
        
        int i=0;
        for (Empleado empleado : listaEmpleados) {
            System.out.println(i + ". " + empleado.getNombre());
            i++;
        }
        Restaurante.presioneEnterParaContinuar();
    }
    
     /**
     * Desplegar detalles de un empleado
     * @param listaEmpleados
     * @param indice
     */
    public static void mostrarInfoEmpleado(ArrayList<Empleado> listaEmpleados, int indice){
        Restaurante.limpiarPantalla();
        System.out.println("+++++++++++++++++++");
        System.out.println("DETALLES DEL EMPLEADO" + indice);
        
        Empleado emp = listaEmpleados.get(indice);
        System.out.println("Nombre:" + emp.getNombre());
        System.out.println("Apellido:" + emp.getApellido());
        System.out.println("Telefono:" + emp.getTelefono());
        System.out.println("Rol:" + emp.getRol());
        System.out.println("Horario:" + emp.getHorario());
        
        Restaurante.presioneEnterParaContinuar();
    }
    
     /**
     * Agregar un empleado
     * @param listaEmpleados
     */
    public static void agregarEmpleado(ArrayList<Empleado> listaEmpleados){
        Restaurante.limpiarPantalla();
        
        Scanner input = new Scanner(System.in);
        System.out.println("AGREGAR NUEVO EMPLEADO");
        //Empleado nuevoEmpleado = new Empleado();
        System.out.println("Introduzca el nombre del nuevo empleado: ");
        String nom = input.next();
        System.out.println("Introduzca el apellido del nuevo empleado: ");
        String ap = input.next();
        System.out.println("Introduzca el teléfono del nuevo empleado: ");
        String tel = input.next();
        System.out.println("Introduzca el rol del nuevo empleado: ");
        String r = input.next();
        System.out.println("Introduzca el horario del nuevo empleado: ");
        String h = input.next();
        Empleado nuevoEmpleado = new Empleado(nom, ap, tel, r, h);
        listaEmpleados.add(nuevoEmpleado);
        System.out.println("-> Nuevo empleado agregado");
        
        Restaurante.presioneEnterParaContinuar();
    }
    
    /**
     * Editar detalles de un empleado
     * @param listaEmpleados
     * @param indice
     */
    private static void editarEmpleado(ArrayList<Empleado> listaEmpleados, int indice) {
        Restaurante.limpiarPantalla();
        
        Scanner input = new Scanner(System.in);
        System.out.println("EDITAR EMPLEADO NÚMERO " + indice);
        //Empleado nuevoEmpleado = new Empleado();
        System.out.println("Introduzca el NUEVO NOMBRE del empleado: ");
        String nom = input.next();
        System.out.println("Introduzca el NUEVO APELLIDO del empleado: ");
        String ap = input.next();
        System.out.println("Introduzca el NUEVO TELÉFONO del empleado: ");
        String tel = input.next();
        System.out.println("Introduzca el NUEVO ROL del empleado: ");
        String r = input.next();
        System.out.println("Introduzca el NUEVO HORARIO del empleado: ");
        String h = input.next();
        Empleado nuevoEmpleado = new Empleado(nom, ap, tel, r, h);
        
        listaEmpleados.remove(indice);
        listaEmpleados.add(indice, nuevoEmpleado);
        
        System.out.println("-> Empleado EDITADO");
        
        Restaurante.presioneEnterParaContinuar();
    }
    /**
     * Get the value of horario
     *
     * @return the value of horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Set the value of horario
     *
     * @param horario new value of horario
     */
    public void setHorario(String horario) {
        this.horario = horario;
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
        /**
     * Get the value of rol
     *
     * @return the value of rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * Set the value of rol
     *
     * @param rol new value of rol
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

}
