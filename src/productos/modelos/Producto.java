/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

/**
 * Atributos y comportamientos de los objetos creados como productos
 * @author Ana Kuenneth
 */
public class Producto implements Comparable<Producto>{
    //Atributos de la clase
    private Estado estado;
    private int codigo;
    private String descripcion;
    private float precio;
    private Categoria categoria;
    
    /**
     * Constructor
     * Instancia objetos del tipo Producto
     * @param codigo Código
     * @param descripcion Descripción del producto
     * @param categoria Categoría
     * @param estado Estado del producto
     * @param precio Precio producto
     */
    public Producto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
        this.estado = estado;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }

    //Métodos
    //Métodos GET/SET
    /**
     * Devuelve el estado
     * @return estado
     */
    public Estado verEstado() {
        return estado;
    }
    /**
     * Asigna el estado al producto
     * @param estado estado
     */
    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }
    
    /**
     * Devuelve el código del producto
     * @return codigo
     */
    public int verCodigo() {
        return codigo;
    }
    /**
     * Asigna el codigo a un producto
     * @param codigo codigo
     */
    public void asignarCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve la descripcion del producto
     * @return descripcion
     */
    public String verDescripcion() {
        return descripcion;
    }
    /**
     *Asigna el precio al producto
     * @param descripcion descripcion
     */
    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Decuelve el precio de un producto
     * @return precio
     */
    public float verPrecio() {
        return precio;
    }
    /**
     * Asigna el precio de un producto
     * @param precio precio
     */
    public void asignarPrecio(float precio) {
        this.precio = precio;
    }
 
    /**
     * Devuelve la categoría de un producto
     * @return categoria
     */
    public Categoria verCategoria() {
        return categoria;
    }
    /**
     * Asigna la categoría al producto
     * @param categoria categoria
     */
    public void asignarCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    /**
     * Muestra los atributos del producto creado.
     */
    public void mostrar(){
        System.out.println("Producto: " + this.verDescripcion());
        System.out.println("Precio:" + this.verPrecio());
        System.out.print("Categoria:" + this.verCategoria());
        System.out.println(" Vigente:" + this.verEstado());
    }
    
    /**
     * Muestra la instancia en forma de String
     * @return Producto
     */
    @Override
    public String toString() {
        return descripcion;
    }

    /**
     * Método hashCode
     * Establece y devuelve el código hash del objeto a partir de su código (código del producto)
     * Código debe ser único para cada objeto del tipo Producto
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.codigo;
        return hash;
    }

    /**
     * Método equals
     * Compara dos objetos del tipo Producto a partir de sus códigos
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return this.codigo == other.codigo;
    }

    /**
     * Compara las categorías y las descripciones de los productos por separado
     * Envía el producto ordenado por categoría y luego por la descripción
     * @param o Objeto del tipo producto a comparar
     * @return Resultado de la comparación (-1, 0, 1)
     */
    @Override
    public int compareTo(Producto o) {
        if(o.categoria.compareTo(this.verCategoria()) == 0){
            return o.descripcion.compareToIgnoreCase(this.verDescripcion())*(-1);
        }
        else{
            return o.categoria.compareTo(this.verCategoria())*(-1);
        }
    }      
}
