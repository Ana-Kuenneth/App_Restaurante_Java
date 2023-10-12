/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import java.util.ArrayList;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
import productos.modelos.Producto;

/**
 * Ejecuta la aplicación de registro de pedidos y ventas para un restaurante.
 * 
 * @author Ana Kuenneth
 */
public class ControladorPrincipal
{
    /**
     * Metodo principal o main del proyecto.
     * @param args 
     */
    public static void main (String[] args)
    {
        /**
         * Instancia de vectores dinamicos para cada tipo de objetos
         */
        //ArrayLists
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Encargado> encargados = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();
        
        /**
         * Instancia objetos de las clases Clientes, Empleado, Encargado y Producto
         */
        //Instanciar las clases
        Cliente cliente1 = new Cliente("c1@gmail.com","c1","c1","c1");
        Cliente cliente2 = new Cliente("c2@gmail.com","c2","c2","c2");
        Cliente cliente3 = new Cliente("c3@gmail.com","c3","c3","c3");
        
        Empleado empleado1 = new Empleado("em1@gmail.com","em1","em1","em1");
        Empleado empleado2 = new Empleado("em2@gmail.com","em2","em2","em2");
        Empleado empleado3 = new Empleado("em3@gmail.com","em3","em3","em3");

        Encargado encargado1 = new Encargado("en1@gmail.com","en1","en1","en1");
        Encargado encargado2 = new Encargado("en1@gmail.com","en1","en1","en2");
        Encargado encargado3 = new Encargado("en1@gmail.com","en1","en1","en3");

        Producto producto1 = new Producto(1,"Postre","p1","Disponible",1.2f);
        Producto producto2 = new Producto(2,"Postre","p2","Disponible",1.2f);
        Producto producto3 = new Producto(3,"Postre","p2","Disponible",1.2f);
        
        /**
         * Se agregan las instancias creadas en cada vector dinámico creado
         */
        //Agregado de elementos
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        
        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);
        
        encargados.add(encargado1);
        encargados.add(encargado2);
        encargados.add(encargado3);
        
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        
        /**
         * Secuencias de iteración para recorrer los vectores y mostrar cada uno de sus elementos
         */
        //Recorrer los ArrayLists y mostrarlos
        for (Cliente unCliente : clientes) {
            unCliente.mostrar();
        }
        
        for (Empleado unEmpleado : empleados) {
            unEmpleado.mostrar();
        }
        
        for (Encargado unEncargado : encargados) {
            unEncargado.mostrar();
        }
        
        for (Producto unProducto : productos) {
            unProducto.mostrar();
        }
        
        /**
         * Se prueba el método toString de la clase Producto
         */
        System.out.println(producto1);
        
    }
}
    
