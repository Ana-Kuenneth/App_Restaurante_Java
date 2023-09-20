/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.modelos;

import java.util.ArrayList;
import usuarios.modelos.Clientes;
import usuarios.modelos.Empleados;
import usuarios.modelos.Encargados;
import usuarios.modelos.Productos;

import usuarios.modelos.Usuario;

/**
 *
 * @author estudiante
 */
public class ControladorPrincipal
{
    
    public static void main (String[] args)
    {
        
        ArrayList<Clientes> clientes = new ArrayList<>();
        ArrayList<Empleados> empleados = new ArrayList<>();
        ArrayList<Encargados> encargados = new ArrayList<>();
        ArrayList<Productos> productos = new ArrayList<>();
        ArrayList<Usuario> usuario = new ArrayList<>();
        
        Clientes cliente1 = new Clientes("c1@gmail.com","c1","c1","c1");
        Clientes cliente2 = new Clientes("c2@gmail.com","c2","c2","c2");
        Clientes cliente3 = new Clientes("c3@gmail.com","c3","c3","c3");
        
        Empleados empleado1 = new Empleados("em1@gmail.com","em1","em1","em1");
        Empleados empleado2 = new Empleados("em2@gmail.com","em2","em2","em2");
        Empleados empleado3 = new Empleados("em3@gmail.com","em3","em3","em3");

        Encargados encargado1 = new Encargados("en1@gmail.com","en1","en1","en1");
        Encargados encargado2 = new Encargados("en1@gmail.com","en1","en1","en1");
        Encargados encargado3 = new Encargados("en1@gmail.com","en1","en1","en1");

        Productos producto1 = new Productos("p1","Disponible",123,"p1",1.2f,"Postre");
        Productos producto2 = new Productos("p2","No disponible",123,"p2",1.2f,"Postre");
        Productos producto3 = new Productos("p3","Disponible",123,"p3",1.2f,"Postre");
        
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente2);
        
        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);
        
        encargados.add(encargado1);
        encargados.add(encargado2);
        encargados.add(encargado2);
        
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        
        
        for (Clientes unCliente : clientes) 
        {
            
            System.out.println(unCliente.verNombre());
            System.out.println(unCliente.verApellido());
            System.out.println(unCliente.verCorreo());
            System.out.println(unCliente.verClave());
            
        }
        
        for (Empleados unEmpleado : empleados) 
        {
            
            System.out.println(unEmpleado.verNombre());
            System.out.println(unEmpleado.verApellido());
            System.out.println(unEmpleado.verCorreo());
            System.out.println(unEmpleado.verClave());
            
            
        }
        
        for (Encargados unEncargado : encargados) 
        {
            
            System.out.println(unEncargado.verNombre());
            System.out.println(unEncargado.verApellido());
            System.out.println(unEncargado.verCorreo());
            System.out.println(unEncargado.verClave());
            
            
        }
        
        for (Productos unProducto : productos) 
        {
            
            System.out.println(unProducto.verNombre());
            System.out.println(unProducto.verEstado());
            System.out.println(unProducto.verDescripcion());
            System.out.println(unProducto.verEstado());
            System.out.println(unProducto.verCategoria());
            System.out.println(unProducto.verPrecio());
            
        }
        
    }
}
    
