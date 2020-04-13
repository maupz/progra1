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
    
    private String nombre;
    private String apellido;
    private String telefono;
    private String horario;
    private String rol;

   
    // Constructores
    public Empleado(String nombre, String apellido, String telefono, String horario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.horario = horario;
    }

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
        Scanner input = new Scanner(System.in);
        
        while (opcion != 5) {
            // Imprimir menu de opciones
            Restaurante.limpiarPantalla();
            System.out.println("˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
            System.out.println("Información del Personal" + "\n");

            System.out.println("1. Mostrar lista de empleados");
            System.out.println("2. Agregar empleado");
            System.out.println("3. Editar empleado");
            System.out.println("4. Remover empleado");
            System.out.println("5. -> REGRESAR <-");
            
            // Leer opción en la consola
            System.out.println("\nIntroduzca la opción que desee: ");
            opcion = input.nextInt();
            String entrada;
            
            // Saltar a la opción del menú
            switch (opcion) {
              case 1:
                mostrarListaEmpleados(listaEmpleados);
                Restaurante.presioneEnterParaContinuar();
                break;
              case 2:
                Empleado nuevoEmpleado = new Empleado();
                listaEmpleados.add(nuevoEmpleado);
                System.out.println("-> Nuevo empleado estándar agregado");
                Restaurante.presioneEnterParaContinuar();
                break;
              /*case 3:
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
                break;*/
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
        
        int i=1;
        for (Empleado empleado : listaEmpleados) {
            System.out.println(i + ". " + empleado.getNombre());
            i++;
        }
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
