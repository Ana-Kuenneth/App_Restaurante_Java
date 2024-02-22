/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedido.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import usuarios.modelos.Cliente;

/**
 * Atributos y comportamientos de los objetos creados como pedidos
 * @author Ana Kuenneth
 */
public class Pedido implements Comparable<Pedido>{
    //Atributos de la clase / Variables de instancia
    private int numero;
    public Estado estado = Estado.CREADO;
    private LocalDateTime fechaYhora;
    private Cliente unCliente;
    private List<ProductoDelPedido> pdp = new ArrayList<>();
    
    /**
     * Constructor
     * Instancia objetos del tipo Pedido
     * @param numero Número de pedido
     * @param fechaYhora Fecha y hora del pedido
     * @param unCliente Cliente que realiza el pedido
     * @param pdp Lista de productos que forman parte del pedido
     */
    public Pedido(int numero, LocalDateTime fechaYhora, List<ProductoDelPedido> pdp, Cliente unCliente) {
        this.numero = numero;
        this.fechaYhora = fechaYhora;
        this.pdp = pdp;
        this.unCliente = unCliente;
    }

    //Métodos
    //Métodos GET/SET
    /**
     * Muestra el número de pedido
     * @return numero
     */
    public int verNumero() {
        return numero;
    }
    /**
     * Asigna el numero de pedido
     * @param numero numero 
     */
    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Devuelve la fecha del pedido
     * @return fecha en la que se hizo el pedido
     */
    public LocalDate verFecha() {
        return fechaYhora.toLocalDate();
    }
    /**
     * Devuelve la hora del pedido
     * @return hora en la se hizo el pedido
     */
    public LocalTime verHora() {
        return fechaYhora.toLocalTime();
    }
    /**
     * Asigna la fecha y la hora en la que se hizo el pedido
     * @param fechaYhora fecha y hora
     */
    public void asignarFechaYhora(LocalDateTime fechaYhora) {
        this.fechaYhora = fechaYhora;
    }
    
    /**
     * Devuelve el cliente que hizo el pedido
     * @return un cliente
     */
    public Cliente verUnCliente() {
        return unCliente;
    }
    /**
     * Asigna el cliente del pedido
     * @param unCliente cliente del pedido
     */
    public void asignarUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }
    
//    Se eliminan los métodos GET/SET de Estado
    
    /**
     * Muestra el producto del pedido
     * @return pdp - producto del pedido
     */
    public List<ProductoDelPedido> verPdp() {
        return pdp;
    }
    /**
     * Asigna el producto del pedido
     * @param pdp producto del pedido
     */
    public void asignarPdp(List<ProductoDelPedido> pdp) {
        this.pdp = pdp;
    }
    
    
    /**
     * Muestra los atributos del producto creado.
     */
    public void mostrar(){
        String patronFecha = "dd/MM/yyyy";
        String patronHora = "HH:mm";
    
        System.out.println("Nro: " + this.verNumero());
        System.out.print("Fecha: " + this.verFecha().format(DateTimeFormatter.ofPattern(patronFecha)));
        System.out.println("\tHora: "+this.verHora().format(DateTimeFormatter.ofPattern(patronHora)));
        System.out.println("Cliente: "+this.unCliente.verApellido()+", "+this.unCliente.verNombre());
        System.out.println("Estado: " +this.estado);
        System.out.println("\tPedido\t\tCantidad");
        System.out.println("\t================================");
        System.out.print("\t");
        for(ProductoDelPedido p : pdp){
            System.out.print((p.verUnProducto().verDescripcion())+"\t\t"+(p.verCantidad())+"\n");
            System.out.print("\t");
        }
    }

    /**
     * Método hashCode
     * Establece y devuelve el código hash del objeto a partir de su numero (numero del pedido)
     * Número debe ser único para cada objeto del tipo Pedido
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.numero;
        return hash;
    }
    
    /**
     * Método equals
     * Compara dos objetos del tipo Pedido a partir de sus números
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
        final Pedido other = (Pedido) obj;
        return this.numero == other.numero;
    }

    
    /**
     * Compara las categorías y las descripciones de los productos por separado
     * Envía el producto ordenado por categoría y luego por la descripción
     * @param o Objeto del tipo producto a comparar
     * @return Resultado de la comparación (-1, 0, 1)
     */
    @Override
    public int compareTo(Pedido o) {
        if(o.numero != this.verNumero()){
            if(o.numero > this.verNumero()){
                return -1;
            } 
            else{
                return 1;
            }
        }
        return 0;
    }   

    /**
     * Devuelve la instancia de Pedido en forma de String
     * @return pedido
     */
    @Override
    public String toString() {
        return "Pedido{" + "numero=" + numero + ", estado=" + estado + ", fechaYhora=" + fechaYhora + ", unCliente=" + unCliente + ", pdp=" + pdp + '}' + "\n";
    }
}
