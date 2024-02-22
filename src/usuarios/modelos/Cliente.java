/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedido.modelos.Pedido;

/**
 * Atributos y comportamientos de los objetos creados como clientes
 * @author estudiante
 */
public class Cliente extends Usuario{
    //Atributos heredados de la super clase Usuario (correo, clave, apellido, nombre)
    ArrayList<Pedido> pedidos = new ArrayList<>();
    
    /**
     * Constructor
     * @param correo Correo electrónico del cliente
     * @param clave Contraseña de ingreso del cliente
     * @param apellido Apellido cliente
     * @param nombre Nombre Cliente
     */
    public Cliente(String correo, String apellido, String nombre, String clave) {
        super(correo, apellido, nombre, clave);
    }

    //Métodos
    //Métodos GET/SET heredados
    //Método mostrar() heredado
    
    /**
     * Método hashCode
     * Establece y devuelve el código hash del objeto a partir de su correos (correo electrónico del cliente)
     * Email debe ser único para cada objeto del tipo Cliente
     * @return hash
     */
    @Override
    public int hashCode() {
        return super.hashCode(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    /**
     * Método equals
     * Compara dos objetos del tipo Cliente a partir de sus correos
     * @param obj obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    /**
     * Método abstracto implementado
     * Devuelve una lista de pedidos
     * @return pedidos
     */
    public ArrayList<Pedido> verPedidos() {
        return this.pedidos;
    }
    
    /**
     * Agrega el pedido recibido a la lista de pedidos del cliente
     * Si ya está lo reemplaza. Si no está lo agrega
     * @param pedido pedido
     */
    public void agregarPedido(Pedido pedido){
        if(!this.pedidos.contains(pedido)){
            this.pedidos.add(pedido);
        }
        else{
            this.pedidos.remove(pedido);
            this.pedidos.add(pedido);
        }
    }
    
    /**
     * Cancela el pedido del cliente. Lo elimina de la lista
     * @param pedido pedido
     */
    public void cancelarPedido(Pedido pedido){
        this.pedidos.remove(pedido);
        if (!pedidos.contains(pedido)){
            pedidos.add(pedido);
        }
    }
}
