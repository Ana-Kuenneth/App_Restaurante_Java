/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public class Encargado extends Usuario{
    //Atributos heredados
    
    //Constructor
    public Encargado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
    //Métodos
    @Override
    public void mostrar(){
        System.out.println("*** ENCARGADO: " + this.verNombre() + " " + this.verApellido()+" ***"); 
        System.out.println("Correo electronico: " + this.verCorreo()+". Clave: "+ this.verClave());
    }
    
}
