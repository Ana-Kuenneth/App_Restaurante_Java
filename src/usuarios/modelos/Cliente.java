/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 * Clase destinada a manejar los clientes del restaurante, que pueden ingresar y hacer pedidos de comida
 * @author Ana Kuenneth
 */
public class Cliente extends Usuario{
    /**
     * Atributos heredados
     * @param correo Correo electrónico del cliente para ingresar al sistema
     * @param clave Contraseña del cliente para ingresar al sistema
     * @param apellido Apellido del cliente
     * @param nombre Nombre del cliente
     */
    
    /**
     * Constructor
     * Crea una instancia del tipo Cliente
     * @param correo Correo electrónico del cliente
     * @param clave Contraseña del cliente
     * @param apellido Apellido del cliente
     * @param nombre Nombre del cliente
     */
    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
    
    //Métodos
    //Métodos GET/SET heredados
    
    @Override
    /**
     * Muestra la información del cliente
     */
    public void mostrar(){
        System.out.print("*** CLIENTE: "); 
        super.mostrar();
    }
}
