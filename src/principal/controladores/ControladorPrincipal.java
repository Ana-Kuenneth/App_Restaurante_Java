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
 *
 * @author estudiante
 */
public class ControladorPrincipal
{
    
    public static void main (String[] args)
    {
        //ArrayLists
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Encargado> encargados = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();
        
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

        Producto producto1 = new Producto("p1","Disponible",123,"p1",1.2f,"Postre");
        Producto producto2 = new Producto("p2","No disponible",123,"p2",1.2f,"Postre");
        Producto producto3 = new Producto("p3","Disponible",123,"p3",1.2f,"Postre");
        
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
        
        //Recorrer los ArrayLists y mostrarlos
        for (Cliente unCliente : clientes) {
            System.out.println("*** CLIENTE: " + unCliente.verNombre() + " " + unCliente.verApellido()+" ***"); 
            System.out.println("Correo electronico: " + unCliente.verCorreo()+". Clave: "+ unCliente.verClave());
        }
        
        for (Empleado unEmpleado : empleados) {
            System.out.println("*** EMPLEADO: " + unEmpleado.verNombre() + " " + unEmpleado.verApellido()+" ***"); 
            System.out.println("Correo electronico: " + unEmpleado.verCorreo()+". Clave: "+ unEmpleado.verClave());
        }
        
        for (Encargado unEncargado : encargados) {
            System.out.println("*** ENCARGADO: " + unEncargado.verNombre() + " " + unEncargado.verApellido()+" ***"); 
            System.out.println("Correo electronico: " + unEncargado.verCorreo()+". Clave: "+ unEncargado.verClave());
        }
        
        for (Producto unProducto : productos) {
            System.out.println("*** PRODUCTO: " + unProducto.verNombre() + " ***"); 
            System.out.println("Codigo: " + unProducto.verCodigo());
            System.out.println("Categoria: " + unProducto.verCategoria());
            System.out.println("Descripcion: "+unProducto.verDescripcion());
            System.out.println("Estado: " + unProducto.verEstado());
            System.out.println("Precio: $"+unProducto.verPrecio());
        }
        
    }
}
    
