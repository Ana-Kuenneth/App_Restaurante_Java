/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.List;
import java.util.Objects;
import pedido.modelos.Pedido;

/**
 * Atributos y comportamientos de los objetos creados como usuarios
 * @author estudiante
 */
public abstract class Usuario implements Comparable<Usuario>{
    //Atributos / Variables de instancia
    private String correo;
    private String apellido;
    private String nombre;
    private String clave;

    /**
     * Constructor
     * Instancia objetos del tipo Usuario
     * @param correo Correo electrónico del usuario
     * @param clave Contraseña del usuario
     * @param apellido Apellido del usuario
     * @param nombre Nombre del usuario
     */
    public Usuario(String correo, String apellido, String nombre, String clave) {
        this.correo = correo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.clave = clave;
    }

    //Métodos
    //Métodos GET/SET
    /**
     * Devuelve el correo electrónico de un usuario
     * @return correo
     */
    public String verCorreo() {
        return correo;
    }
    /**
     * Asigna el correo electrónico de un usuario
     * @param correo correo
     */
    public void asignarCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Devuelve la constraseña de un usuario
     * @return clave
     */
    public String verClave() {
        return clave;
    }
    /**
     * Asigna la contraseña de un usuario
     * @param clave clave
     */
    public void asignarClave(String clave) {
        this.clave = clave;
    }

    /**
     * Devuelve el apellido de un usuario
     * @return apellido
     */
    public String verApellido() {
        return apellido;
    }
    /**
     * Asigna el apellido de un usuario
     * @param apellido apellido
     */
    public void asignarApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Devuelve el nombre de un usuario
     * @return nombre
     */
    public String verNombre() {
        return nombre;
    }
    /**
     * Asigna el nombre de un usuario
     * @param nombre nombre
     */
    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Muestra los atributos del objeto Usuario creado
     */
    public void mostrar(){
        System.out.println(this.verApellido()+ " " +this.verNombre());
        System.out.println("Correo: " + this.verCorreo());
    }

    /**
     * Método hashCode
     * Establece y devuelve el código hash del objeto a partir de su correos (correo electrónico del Usuario)
     * Email debe ser único para cada objeto del tipo Usuario
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.correo);
        return hash;
    }

    /**
     * Método equals
     * Compara dos objetos del tipo Usuario a partir de sus correos
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
        if (getClass().getSuperclass() != obj.getClass().getSuperclass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.correo, other.correo);
    }

    @Override
    /**
     * 
     */
    public String toString() {
        return "Usuario{" + "correo=" + this.verCorreo() + ", apellido=" + this.verApellido() + ", nombre=" + this.verNombre() + ", clave=" + this.verClave()  + '}' + "\n" ;
    }
    
    
    /**
     * Método abstracto que permite ver un conjunto de pedidos
     * @return Lista de pedidos que realizó el Usuario
     */
    public abstract List<Pedido> verPedidos();
    
    /**
     * Método encargado del ordenamiento de los usuarios
     * @param o Un usuario
     * @return resultado de la comparacion de los usuarios para el ordenamiento
     */
    @Override
    public int compareTo(Usuario o) {
        if(o.apellido.compareTo(this.verApellido()) == 0){
            return o.nombre.compareToIgnoreCase(this.verNombre())*(-1);
        }
        else{
            return o.apellido.compareTo(this.verApellido())*(-1);
        }
    }   
}
