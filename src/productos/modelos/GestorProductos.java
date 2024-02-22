/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IGestorProductos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pedido.modelos.GestorPedidos;

/**
 * Clase destinada a crear y manejar las instancias Producto
 * @author martinez
 */
public class GestorProductos implements IGestorProductos{
    //Atributos
    private static GestorProductos gestor;
    private List<Producto> productos = new ArrayList<>();
    public static final String archivo = "./productos.txt";
   
    /**
     * Constructor.
     */
    private GestorProductos() {
        this.leerArchivo();
    }
    
    //Métodos
    /**
     * Mecanismo para que sólo se pueda crear una instancia de GestorProductos.
     * @return gestor como única instancia
     */
    public static GestorProductos instanciar(){
        if(gestor == null){
            gestor = new GestorProductos();
        }
        return gestor;
    }
    
    /**
     * Crea un nuevo producto
     * @param codigo Código del producto
     * @param descripcion Descripción del producto
     * @param precio Precio del producto
     * @param categoria Categoría del producto
     * @param estado Estado del producto
     * @return Resultado de la operación
     */
    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        this.leerArchivo();
        String validacion = validarProducto(codigo, descripcion, precio, categoria, estado);
        if(validacion.equals(VALIDACION_EXITO)){
            Producto producto = new Producto(codigo, descripcion, categoria, estado, precio);
            return agregarProducto(producto);
        }
        else {
            return validacion + ". " + ERROR;
        }
    }
    
    /**
     * Modifica un producto del menú
     * @param productoAModificar Producto que debe ser modificado
     * @param codigo Nuevo código
     * @param descripcion Nueva descripción
     * @param precio Nuevo precio
     * @param categoria Nueva categoría
     * @param estado Nuevo estado
     * @return Resultado de la operación
     */
    @Override
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        if(this.productos.contains(productoAModificar)){
            int posicion = this.productos.indexOf(productoAModificar);
            Producto productoCambios = new Producto(codigo, descripcion, categoria, estado, precio);  
           
            String validacion = validarProducto(codigo, descripcion, precio, categoria, estado);
            if(validacion.equals(VALIDACION_EXITO)){
                this.productos.set(posicion, productoCambios);
                this.escribirArchivo();
                return EXITO_MODIFICAR; 
            }
            else{
                return validacion + ". " + ERROR_MODIFICAR;
            }   
        }
        return PRODUCTO_INEXISTENTE;  
    }   
   
    /**
     * Devuelve todos los productos
     * @return Productos del menú del restaurante
     */
    @Override
    public List<Producto> menu(){
        this.leerArchivo();
        Collections.sort(this.productos);
        return this.productos;
    }
    
    /**
     * Busca si existen productos con la descripción especificada (total o parcialmente).
     * @param descripcion Descripción del producto a buscar
     * @return Lista de productos con la descripción ingresada
     */
    @Override
    public List<Producto> buscarProductos(String descripcion){
        List<Producto> productosDesc = new ArrayList<>();
        this.leerArchivo();
        for(Producto p : this.productos){
            if(p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase())){
                productosDesc.add(p);
            }
        }
        Collections.sort(productosDesc);
        return productosDesc;
    }
    
    /**
     * Devuelve true si existe el producto especificado, false en caso contrario.
     * @param producto Producto posible del menu
     * @return True or False, producto existente o no
     */
    @Override
    public boolean existeEsteProducto(Producto producto){
        for(Producto p : this.productos){
            if(p.verCodigo() == producto.verCodigo()){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Devuelve los productos con la categoría especificada
     * @param categoria Categoría de productos
     * @return Lista con todos los productos de la categoría ingresada
     */
    @Override
    public List<Producto> verProductosPorCategoria(Categoria categoria){
        List<Producto> productosCat = new ArrayList<>();
        this.leerArchivo();
        for (Producto p : this.productos) {
            if (p.verCategoria().equals(categoria)) {
                productosCat.add(p);
            }
        }   
        Collections.sort(productosCat);
        return productosCat;
    }
    
    /**
     * Obtiene el producto con el código especificado
     * Si no hay un producto con el código, devuelve null.
     * @param codigo Código de un producto
     * @return El producto con el código ingresado
     */
    @Override
    public Producto obtenerProducto(Integer codigo){
        this.leerArchivo();
        for(Producto p : this.productos){
            if(p.verCodigo() == codigo){
                return p;
            }
        }
        return null;
    }
    
    /**
     * Borra un producto siempre y cuando no haya pedidos con el mismo
     * @param producto Producto a eliminar
     * @return Resultado de la operación
     */
    @Override
    public String borrarProducto(Producto producto) {
        GestorPedidos gestorPedidos = GestorPedidos.crear();
        if(gestorPedidos.hayPedidosConEsteProducto(producto)){
            return ERROR_BORRAR;
        }
        else{
            menu().remove(producto);
            this.escribirArchivo();
            return EXITO_BORRAR;
        }
    }
    
    /**
     * Se encarga de leer el archivo donde se guarda la lista de productos
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
                while((cadena = br.readLine()) == null) {
                    String[] vector = cadena.split(",");
                    Estado estado = Estado.fromString(vector[0]);
                    int codigo = Integer.parseInt(vector[1]);
                    String descripcion = vector[2];
                    float precio = Float.parseFloat(vector[3]);
                    Categoria categoria = Categoria.fromString(vector[4]);
                           
                    Producto unProducto = new Producto(codigo, descripcion, categoria, estado, precio);
                    this.productos.add(unProducto); 
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
            for (Producto producto : this.productos) {
                String linea;
                linea = producto.verEstado() + ",";
                linea += Integer.toString(producto.verCodigo()) + ",";
                linea += producto.verDescripcion() + ",";
                linea += Float.toString(producto.verPrecio()) + ",";
                linea += producto.verCategoria(); 
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
     * Verifica si un producto cumple con los requisitos
     * @param codigo Código del producto
     * @param descripcion Descripción del producto
     * @param precio Precio del producto
     * @param categoria Categoria del producto
     * @param estado Estado del producto
     * @return Resultado de la operación
     */
    public String validarProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){       
        if(codigo <= 0){
            return ERROR_CODIGO;
        }
        if(descripcion == null || descripcion.isEmpty()){
            return ERROR_DESCRIPCION;
        }
        if(precio <= 0.0f){
            return ERROR_PRECIO;
        }
        if(categoria == null){
            return ERROR_CATEGORIA;
        }
        if(estado == null){
            return ERROR_ESTADO;
        }
        
        return VALIDACION_EXITO;
    }
    
    /**
     * Agrega un producto a la lista dependiendo de si ya está agregado o no
     * @param producto Un producto
     * @return Resultado de la operación
     */
    public String agregarProducto(Producto producto){
        if(this.productos.contains(producto)){ 
            return PRODUCTOS_DUPLICADOS;
        }
        else{
            this.productos.add(producto);
            this.escribirArchivo();
            return EXITO;
        }
    }
    
    /**
     * Método auxiliar para revisión desde consola.
     */
    @Override
    public void mostrarProductos(){
        for (Producto p : this.productos){
            p.mostrar();
        }
    }
}


