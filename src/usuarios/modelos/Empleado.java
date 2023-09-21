/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public class Empleado extends Usuario{
    //Atributos heredados
    
    //Constructor
    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
    //Métodos
    @Override
    public void mostrar(){
        System.out.println("*** EMPLEADO: " + this.verNombre() + " " + this.verApellido()+" ***"); 
        System.out.println("Correo electronico: " + this.verCorreo()+". Clave: "+ this.verClave());
    }
}
