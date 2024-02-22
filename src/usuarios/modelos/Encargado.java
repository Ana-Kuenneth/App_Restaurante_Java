/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.List;
import pedido.modelos.GestorPedidos;
import pedido.modelos.Pedido;

/**
 * Atributos y comportamientos de los objetos creados como encargados
 * @author estudiante
 */
public class Encargado extends Usuario{
    //Atributos heredados de la super clase Usuario (correo, clave, apellido, nombre)

    /**
     * Constructor
     * Instancia objetos del tipo Encargados
     * @param correo Correo electrónico del encargado
     * @param clave Contraseña del encargado
     * @param apellido Apellido encargado
     * @param nombre Nombre encargado
     */
    public Encargado(String correo, String apellido, String nombre, String clave) {
        super(correo, apellido, nombre, clave);
    }

    //Métodos
    //Métodos GET/SET heredados
    //Método mostrar() heredado
       
    /**
     * Método hashCode
     * Establece y devuelve el código hash del objeto a partir de su correos (correo electrónico del encargado)
     * Email debe ser único para cada objeto del tipo Encargado
     * @return hash
     */
    @Override
    public int hashCode() {
        return super.hashCode(); 
    }
    
    /**
     * Método equals
     * Compara dos objetos del tipo Encargado a partir de sus correos
     * @param obj obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); 
    }
    
    /**
     * Método que devuelve todos los pedidos creados 
     * Se utiliza el patrón Singleton
     * @return pedidos
     */
    @Override
    public List<Pedido> verPedidos() {
        GestorPedidos gp = GestorPedidos.crear();
        return gp.verPedidos();
    }
}
