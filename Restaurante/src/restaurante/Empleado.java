/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;
    
/**
 *
 * @author mauricio.jimenez
 */
public class Empleado {
    
    private String nombre;
    private String apellido;
    private String telefono;
    private String horario;

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

}
