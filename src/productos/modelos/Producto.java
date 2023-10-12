/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

/**
 * Clase destinada a manejar los productos del restaurante, sus estado y la venta de ellos.
 * @author Ana Kuenneth
 */
public class Producto {
    /**
     * Atributos de la clase / Variables de instacia de la clase Producto
     * @param codigo Código del tipo entero que identifica a cada uno de los productos.
     * @param descripcion Brinda un breve detalle sobre cada producto.
     * @param categoria Brinda especificidad sobre un producto. Agrupa ciertos productos.
     * @param estado Muestra si un producto esta disponible o no.
     * @param precio Valor numérico de tipo flotante del producto.
    */
    private int codigo;
    private String descripcion;
    private String categoria;
    private String estado;
    private float precio;
    
    
    /**
     * Constructor
     * Crea una instancia del tipo Producto
     * @param codigo Código del producto
     * @param descripcion Detalle sobre el producto
     * @param categoria Grupo del producto
     * @param estado Disponibilidad del producto
     * @param precio Valor numérico para monetizar el producto
    */
    public Producto(int codigo, String descripcion, String categoria, String estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }
    
    //Metodos GET/SET
    /**
     * Metodo GET para ver el código del producto
     * @return El código del producto
     */
    public int verCodigo() {
        return codigo;
    }
    /**
     * Método SET para asignar el código del producto
     * @param codigo El código del producto
     */
    public void asignarCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Metodo GET para ver la descripción del producto
     * @return La descripción del producto
     */
    public String verDescripcion() {
        return descripcion;
    }
    /**
     * Metodo SET para asignar la descripción del producto
     * @param descripcion La descripción del producto
     */
    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Metodo GET para ver la categoría del producto
     * @return La categoría del producto
     */
    public String verCategoria() {
        return categoria;
    }
    /**
     * Metodo SET para asignar la categoría del producto
     * @param categoria La categoría del producto
     */
    public void asignarCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    /**
     * Metodo GET para ver el estado del producto
     * @return El estado del producto
     */
    public String verEstado() {
        return estado;
    }
    /**
     * Método SET para asignar el estado del producto
     * @param estado El estado del producto
     */
    public void asignarEstado(String estado) {
        this.estado = estado;
    }
    
    /**
     * Metodo GET para ver el precio del producto
     * @return El precio del producto
     */
    public float verPrecio() {
        return precio;
    }
    /**
     * Método SET para asignar el precio del producto
     * @param precio El precio del producto
     */
    public void asignarPrecio(float precio) {
        this.precio = precio;
    }
    
    
    //Métodos
    /**
     * Muestra la información del producto
     */
    public void mostrar(){
        System.out.println("*** PRODUCTO: " + this.verCodigo() + " ***"); 
        System.out.println("Descripcion: "+ this.verDescripcion());
        System.out.println("Categoria: " + this.verCategoria());
        System.out.println("Estado: " + this.verEstado());
        System.out.println("Precio: $"+ this.verPrecio()+"\n");
    }

    /**
     * Muestra el objeto como una sentencia de caracteres con toda la información del mismo
     * @return El objeto como un String
     */
    @Override
    public String toString() {
        return "PRODUCTO{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", categoria=" + categoria + ", estado=" + estado + ", precio=" + precio + '}';
    }
    
}
