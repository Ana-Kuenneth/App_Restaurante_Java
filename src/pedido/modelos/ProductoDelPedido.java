/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedido.modelos;

import java.util.Objects;
import productos.modelos.Producto;

/**
 * Clase destinada a guardar las cualidades de los objetos del tipo Producto
 * para una relacion de asociación bidireccional de cardinalidad muchos a muchos entre Pedido y Producto
 * @author Ana Kuenneth
 */
public class ProductoDelPedido {
    //Atributos / Variables de instancia
    private int cantidad;
    private Producto unProducto;

    /**
     * Constructor
     * Instancia objetos del tipo ProductoDelPedido
     * @param cantidad cantidad
     * @param unProducto unProducto
     */
    public ProductoDelPedido(Producto unProducto, int cantidad) {
        this.unProducto = unProducto;
        this.cantidad = cantidad;
    }
    
    //Métodos
    //Métodos GET/SET
    /**
     * Muestra la cantidad de producto solicitado en un pedido
     * @return cantidad
     */
    public int verCantidad() {
        return cantidad;
    }
    /**
     * Asigna la cantidad de producto
     * @param cantidad cantidad
     */
    public void asignarCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Muestra el producto solicitado en un pedido
     * @return unProducto
     */
    public Producto verUnProducto() {
        return unProducto;
    }
    /**
     * Aasigna el producto solicitado en un pedido
     * @param unProducto unProducto
     */
    public void asignarUnProducto(Producto unProducto) {
        this.unProducto = unProducto;
    }

    
    /**
     * Mètodo hashcode
     * Establece y devuelve el código hash del objeto a partir de su producto (producto del pedido)
     * Producto debe ser único para cada objeto del tipo ProductoDelPedido
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.unProducto);
        return hash;
    }

    /**
     * Método equals
     * Compara dos objetos del tipo ProductoDelPedido a partir de sus Productos
     * @param obj obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductoDelPedido other = (ProductoDelPedido) obj;
        return Objects.equals(this.unProducto, other.unProducto);
    }

    //Método auxiliar para control por pantalla TP6
    /**
     * Devuelve la instancia de ProductoDelPedido en forma de String
     * @return pedido
     */
    @Override
    public String toString() {
        return "ProductoDelPedido{" + "cantidad=" + cantidad + ", unProducto=" + unProducto + '}' + "\n";
    }
}
