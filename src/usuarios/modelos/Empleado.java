/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 * Clase destinada a manejar los empleados del restaurante, que pueden ingresar y revisar los pedidos de comida
 * @author Ana Kuenneth
 */
public class Empleado extends Usuario{
    /**
     * Atributos heredados
     * @param correo Correo electrónico del empleado para ingresar al sistema
     * @param clave Contraseña del empleado para ingresar al sistema
     * @param apellido Apellido del empleado
     * @param nombre Nombre del empleado
     */
    
    /**
     * Constructor
     * Crea una instancia del tipo Empleado
     * @param correo Correo electrónico del empleado
     * @param clave Contraseña del empleado
     * @param apellido Apellido del empleado
     * @param nombre Nombre del empleado
     */
    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
    //Métodos
    @Override
    /**
     * Muestra la información del empleado
     */
    public void mostrar(){
        System.out.print("*** EMPLEADO: "); 
        super.mostrar();
    }
}
