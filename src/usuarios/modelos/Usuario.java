/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 * Clase destinada a manejar los usuarios del restaurante (Clientes, Encargados, Empleados), que pueden ingresar a la aplicación, hacer y revisar los pedidos de comida
 * @author Ana Kuenneth
 */
public class Usuario {
    /**
     * Atributos de la clase / Variables de instacia de la clase Usuario
     * @param correo Correo electrónico del usuario para poder ingresar a la aplicación.
     * @param clave Clave o contraseña de acceso del usuario a la aplicación.
     * @param apellido Apellido del usuario de la aplicación.
     * @param nombre Nombre del usuario de la aplicación.
    */
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;

    /**
     * Constructor
     * Crea una instancia del tipo Usuario
     * @param correo Correo electrónico del usuario
     * @param clave Contraseña del usuario
     * @param apellido Apellido del usuario
     * @param nombre Nombre del usuario
     */
    public Usuario(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    
    //Metodos GET/SET
    /**
     * Metodo GET para ver el nombre del usuario
     * @return El nombre del usuario
     */
    public String verNombre() {
        return nombre;
    }
    /**
     * Metodo SET para asignar el nombre del usuario
     * @param nombre El nombre del usuario
     */
    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo GET para ver el correo electrónico del usuario
     * @return El correo electrónico del usuario
     */
    public String verCorreo() {
        return correo;
    }
    /**
     * Metodo SET para asigar el correo electrónico del usuario
     * @param correo El correo electrónico del usuario
     */
    public void asignarCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo GET para ver la clave del usuario
     * @return La contraseña del usuario
     */
    public String verClave() {
        return clave;
    }
    /**
     * Metodo SET para asignar la clave del usuario
     * @param clave La contraseña del usuario
     */
    public void asignarClave(String clave) {
        this.clave = clave;
    }
    
    /**
     * Metodo GET para ver el nombre del usuario
     * @return El apellido del usuario
     */
    public String verApellido() {
        return apellido;
    }
    /**
     * Metodo SET para asignar el apellido del usuario
     * @param apellido El apellido del usuario
     */
    public void asignarApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    //Métodos
    /**
     * Muestra la información del usuario
     */
    public void mostrar(){
        System.out.println(this.verNombre() + " " + this.verApellido()+" ***");
        System.out.println("Correo electronico: " + this.verCorreo()+". Clave: "+ this.verClave()+"\n");
    }
}
