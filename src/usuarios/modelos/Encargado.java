/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 * Clase destinada a manejar los encargados del restaurante, que pueden ingresar y revisar los pedidos de comida
 * @author Ana Kuenneth
 */
public class Encargado extends Usuario{
    /**
     * Atributos heredados
     * @param correo Correo electrónico del encargado para ingresar al sistema
     * @param clave Contraseña del encargado para ingresar al sistema
     * @param apellido Apellido del encargado
     * @param nombre Nombre del encargado
     */
    
    /**
     * Constructor
     * Crea una instancia del tipo Encargado
     * @param correo Correo electrónico del encargado
     * @param clave Contraseña del encargado
     * @param apellido Apellido del encargado
     * @param nombre Nombre del encargado
     */
    public Encargado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
    
    //Métodos
    //Métodos GET/SET heredados
    
    @Override
    /**
     * Muestra la información del encargado
     */
    public void mostrar(){
        System.out.print("*** ENCARGADO: "); 
        super.mostrar();
    }
    
}
