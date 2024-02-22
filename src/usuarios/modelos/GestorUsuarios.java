/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import static interfaces.IGestorProductos.ERROR_ESCRITURA_ARCHIVO;
import static interfaces.IGestorProductos.ERROR_LECTURA_ARCHIVO;
import interfaces.IGestorUsuarios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import pedido.modelos.GestorPedidos;

/**
 * Clase destinada a crear y manejar las instancias Usuario
 * @author martinez
 */
public class GestorUsuarios implements IGestorUsuarios{
    //Atributos
    private static GestorUsuarios gestor;
    private List<Usuario> usuarios = new ArrayList<>();
    private static final String archivo = "usuarios.txt";

    /**
     * Constructor.
     */
    private GestorUsuarios() {
        this.leerArchivo();
    }
    
    /**
     * Mecanismo para que sólo se pueda crear una instancia de GestorUsuarios
     * @return gestor como única instancia
     */
    public static GestorUsuarios instanciar(){
        if(gestor == null){
            gestor = new GestorUsuarios();
        }
        return gestor;
    }
    
    /**
     * Crea un nuevo usuario
     * @param correo Correo del usuario
     * @param apellido Apellido del usuario
     * @param nombre Nombre del usuario
     * @param perfil Perfil del usuario
     * @param clave Clave del usuario
     * @param claveRepetida Clave repetida para verificación
     * @return Resultado de la operación
     */
    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        String validacion = validarUsuario(correo, apellido, nombre, perfil, clave, claveRepetida);
        if(validacion.equals(VALIDACION_EXITO)){
            Usuario usuario;
            switch (perfil) {
                case CLIENTE: 
                    usuario = new Cliente(correo, apellido, nombre, clave);
                    return agregarUsuario(usuario);
                case ENCARGADO: 
                    usuario = new Encargado(correo, apellido, nombre, clave);
                    return agregarUsuario(usuario);
                case EMPLEADO: 
                    usuario = new Empleado(correo, apellido, nombre, clave);
                    return agregarUsuario(usuario);
                default:
                    return ERROR;
            }
        }
        else{
            return validacion;
        }
    }
    
    /**
     * Modifica un usuario de la lista
     * @param correo
     * @param apellido
     * @param nombre
     * @param clave
     * @param claveRep
     * @return 
     */
    @Override
    public String modificarUsuario(String correo, String apellido, String nombre, String clave, String claveRep){
        String validacion = this.validarUsuario(correo, apellido, nombre, Perfil.CLIENTE, clave, claveRep);
        if(validacion.equals(VALIDACION_EXITO)){
            Usuario usuarioEncontrado = this.obtenerUsuario(correo);
            for(Usuario u : this.usuarios){
                if(u.equals(usuarioEncontrado)){
                    u.asignarApellido(apellido);
                    u.asignarClave(clave);
                    u.asignarNombre(nombre);
                    u.mostrar();
                }
            }
            this.escribirArchivo();
            return EXITO;
        }
        return validacion;
    }
        
    /**
     * Devuelve todos los usuarios
     * @return Lista con todos los usuarios
     */
    @Override
    public List<Usuario> verUsuarios(){ 
        /* Compara los apellidos y los nombres de los usuarios por separado
         * Envía el usuario ordenado por apellido y luego por el nombre
         */
        Comparator<Usuario> apellidoComp = (apellidoU1, apellidoU2) -> {
            int comparacion = apellidoU1.verApellido().compareToIgnoreCase(apellidoU2.verApellido());
            if (comparacion == 0) {
                comparacion = apellidoU1.verNombre().compareToIgnoreCase(apellidoU2.verNombre());
            }
            return comparacion;
        };
        
        Collections.sort(this.usuarios, apellidoComp); 
        return this.usuarios;
    }
    
    /**
     * Busca si existen usuarios con el apellido especificado (total o parcialmente)
     * @param apellido Apellido del usuario a buscar
     * @return Lista de usuarios con el apellido ingresado
     */
    @Override
    public List<Usuario> buscarUsuarios(String apellido){
        /* Compara los apellidos y los nombres de los usuarios por separado
         * Envía el usuario ordenado por apellido y luego por el nombre
         */
        List<Usuario> usuariosAp = new ArrayList<>();
        for(Usuario u : this.usuarios){
            if(u.verApellido().toLowerCase().contains(apellido.toLowerCase())){
                usuariosAp.add(u);
            }
        }
        
        Collections.sort(usuariosAp);
        return usuariosAp;
    }
    
    /**
     * Devuelve true si existe el usuario especificado, false en caso contrario.
     * @param usuario Usuario a buscar
     * @return true or false, usuario existente o no
     */
    @Override
    public boolean existeEsteUsuario(Usuario usuario){
        for(Usuario u : this.usuarios){
            if(u.verCorreo().equals(usuario.verCorreo())){
                return true;
            }
        }
        return false;
    } 
     
    /**
     * Obtiene el usuario con el correo especificado
     * Si no hay un usuario con el correo, devuelve null.
     * @param correo Correo del usuario
     * @return El usuario con el correo ingresado
     */
    @Override
    public Usuario obtenerUsuario(String correo){
        for(Usuario u : this.usuarios){
            if(u.verCorreo().equals(correo)){
                return u;
            }
        }
        return null;
    }    
    
    /**
     * Borra un usuario siempre y cuando no haya pedidos con el mismo
     * @param usuario Usuario a eliminar
     * @return Resultado de la operación
     */
    @Override
    public String borrarUsuario(Usuario usuario) {
        GestorPedidos gestorPedidos = GestorPedidos.crear();
        if(usuario instanceof Cliente){
            if((gestorPedidos.hayPedidosConEsteCliente((Cliente)usuario)) == true){
                return ERROR_BORRAR;
            }
            else{
                verUsuarios().remove(usuario);
                this.escribirArchivo();
                return EXITO_BORRAR;
            }
        }
        return USUARIO_INEXISTENTE + ". " + ERROR_BORRAR;
    }
    
    /**
     * Se encarga de leer el archivo donde se guarda la lista de usuarios
     * Si no existe lo crea, si ya existe lo lee.
     */
    public void leerArchivo(){
        BufferedReader br = null;
        
        try {
            File file = new File(this.archivo);
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                br = new BufferedReader(fr);
                String cadena;
                while((cadena = br.readLine()) != null) {
                    String[] vector = cadena.split(",");
                    String correo = vector[0];
                    String apellido = vector[1];
                    String nombre = vector[2];
                    Perfil perfil = Perfil.fromString(vector[3]);
                    String clave = vector[4];
                           
                    this.crearUsuario(correo, apellido, nombre, perfil, clave, clave);
                }
            }    
                
        }
        catch (IllegalArgumentException | IOException ex) {
                System.out.println(ERROR_LECTURA_ARCHIVO);
                ex.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
    
    /**
     * Se encarga de la escritura y modificación del archivo donde se guarda la lista de productos.
     */
    public void escribirArchivo(){
        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter(this.archivo);
            bw = new BufferedWriter(fw);
            for (Usuario usuario : this.usuarios) {
                String linea;
                linea = usuario.verCorreo()+ ",";
                linea += usuario.verApellido() + ",";
                linea += usuario.verNombre()+ ",";
                linea += usuario.getClass().getSimpleName() + ",";
                linea += usuario.verClave(); 
                bw.write(linea);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException ioe) {
            System.out.println(ERROR_ESCRITURA_ARCHIVO);
            ioe.printStackTrace();
        }
        finally {
            if (bw != null) {
                try {
                    bw.close();
                }
                catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }       
        }
    }
    
    
    //Métodos auxiliares
    /**
     * Verifica si un usuario cumple con los requisitos
     * @param correo Correo del usuario
     * @param apellido Apellido del usuario
     * @param nombre Nombre del usuario
     * @param perfil Perfil del usuario
     * @param clave Clave del usuario
     * @param claveRepetida Clave repetida para verificación
     * @return true or false, usuario validado o no
     */
    public String validarUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        if (correo == null || correo.isEmpty() || !correo.contains("@") || (correo.indexOf("@") != correo.lastIndexOf("@"))) {
            return ERROR_CORREO;
        }
        if (apellido == null || apellido.isEmpty()) {
            return ERROR_APELLIDO;
        }
        if(nombre == null || nombre.isEmpty()){
            return ERROR_NOMBRE;
        }
        if (clave == null || clave.isEmpty()) {
            return ERROR_CONTRASENIA;
        }
        if (claveRepetida == null || claveRepetida.isEmpty() || !claveRepetida.equals(clave)) {
            return ERROR_CLAVES;
        }
        
        return VALIDACION_EXITO;
    }
    
    /**
     * Agrega un usuario a la lista dependiendo de si ya está agregado o no
     * @param usuario Un usuario
     * @return Resultado de la operación
     */
    public String agregarUsuario(Usuario usuario){
        if(this.usuarios.contains(usuario)){ 
            return USUARIOS_DUPLICADOS;
        }
        else{
            this.usuarios.add(usuario);
            this.escribirArchivo();
            return EXITO;
        }
    }

    
    /**
     * Método auxiliar para revisión desde consola.
     */
    @Override
    public void mostrarUsuarios(){
        for (Usuario u : this.usuarios){
            u.mostrar();
        }
    }
}
