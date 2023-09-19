/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public class Productos {
    //Atributos
    private String nombre;
    private String estado;
    
    //Constructor
    public Productos(String nombre, String estado) {
        this.nombre = nombre;
        this.estado = estado;
    }
    
    //Metodos
    //Metodos GET/SET
    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String verEstado() {
        return estado;
    }

    public void asignarEstado(String estado) {
        this.estado = estado;
    }

}
