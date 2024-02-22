/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedido.modelos;

import interfaces.IGestorPedidos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Usuario;

/**
 * Clase destinada a crear y manejar las instancias Pedido
 * @author estudiante
 */
public class GestorPedidos implements IGestorPedidos{
    //Atributos
    private static GestorPedidos gestor;
    private List<Pedido> pedidos = new ArrayList<>();
    
    /**
     * Constructor.
     */
    public GestorPedidos() {
    }
    
    /**
     * Mecanismo para que sólo se pueda crear una instancia de GestorPedidos
     * @return gestor como única instancia 
     */
    public static GestorPedidos crear(){
        if(gestor == null){
            gestor = new GestorPedidos();
        }
        return gestor;
    }
    
    /**
     * Crea un nuevo pedido
     * Al crear el pedido, el mismo se agrega al cliente especificado
     * (empleando el método agregarPedido() definido en la clase Cliente)
     * @param fecha Fecha de creación del pedido
     * @param hora Hora de creación del pedido
     * @param productosDelPedido Lista de productos a agregar en el nuevo pedido
     * @param cliente Cliente que hace el pedido
     * @return Resultado de la operación
     */
    @Override
    public String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente){
        String validacion = validarPedido(fecha, hora, productosDelPedido, cliente);
        if(validacion.equals(VALIDACION_EXITO)){
            LocalDateTime fechaYhora = LocalDateTime.of(fecha, hora);
            int numPedido = this.pedidos.size() + 1;
            Pedido pedido = new Pedido(numPedido, fechaYhora, productosDelPedido, cliente);
            return agregarPedido(pedido);
        }
        else{
            return validacion + ". " + ERROR;
        }
    }
    
    /**
     * Cambia el estado de un pedido
     * Si el pedido está en el estado Estado.CREADO lo pasa a Estado.PROCESANDO. 
     * Si el pedido está en el estado Estado.PROCESANDO lo pasa a Estado.ENTREGADO.
     * @param pedidoAModificar Pedido que hay que modificar
     * @return Resultado de la operación
     */
    @Override
    public String cambiarEstado(Pedido pedidoAModificar){
        if(pedidoAModificar.estado.toString().toLowerCase().equalsIgnoreCase("Creado")){
            pedidoAModificar.estado = Estado.PROCESANDO;
            return EXITO_MODIFICAR;
        }
        if(pedidoAModificar.estado.toString().toLowerCase().equalsIgnoreCase("Procesando")){
            pedidoAModificar.estado = Estado.ENTREGRADO;
            return EXITO_MODIFICAR;
        }
        return ERROR_ESTADO + ". " + ERROR_MODIFICAR;  
    }

    /**
     * Devuelve todos los pedidos
     * @return Lista de todos los pedidos
     */
    @Override
    public List<Pedido> verPedidos(){
        Collections.sort(pedidos);
        return pedidos;
    }
    
    /**
     * Devuelve true si hay al menos un pedido con el cliente especificado, false en caso contrario.
     * @param cliente Cliente de un pedido
     * @return true or false
     */
    @Override
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        for(Pedido p : this.pedidos){
            if(p.verUnCliente().equals(cliente)){
                return true;
            } 
        }
        return false;
    }

    /**
     * Devuelve true si hay al menos un pedido con el producto especificado, false en caso contrario.
     * @param producto Un producto
     * @return true or false
     */
    @Override
    public boolean hayPedidosConEsteProducto(Producto producto){
        for (Pedido pedido : this.pedidos){
            for(ProductoDelPedido pdp : pedido.verPdp()){
                if(pdp.verUnProducto().equals(producto)){
                    return true;
                }  
            }
        }
        return false;
    }
  
  /**
   * Devuelve true si existe el pedido especificado, false en caso contrario.
   * @param pedido Un pedido
   * @return true or false
   */  
    @Override
    public boolean existeEstePedido(Pedido pedido){
        for(Pedido p : this.pedidos){
            if(p.verNumero() == pedido.verNumero()){
                return true;
            }
        }
        return false;
    }
       
    /**
     * Obtiene el pedido con el número especificado. Si no hay un pedido con el número, devuelve null.
     * @param numero Numero de un pedido
     * @return Pedido con el número especificado
     */
    @Override
    public Pedido obtenerPedido(Integer numero){
        for(Pedido p : this.pedidos){
            if(p.verNumero() == numero){
                return p;
            }
        }
        return null;
    }
    
    /**
     * Cancela un pedido. 
     * Al cancelar un pedido, el mismo se borra del conjunto de pedidos del cliente (empleando el método 
     * cancelarPedido() definido en la clase Cliente).
     * @param pedido Pedido a cancelar
     * @return Resultado de la operación
     */
    @Override
    public String cancelarPedido(Pedido pedido) {
        GestorPedidos gestorPedidos = GestorPedidos.crear();
        GestorUsuarios gestorUsuarios = GestorUsuarios.instanciar();
        for(Usuario usuario : gestorUsuarios.verUsuarios()){
            if(usuario instanceof Cliente){
                if(usuario.verPedidos().contains(pedido)){
                    usuario.verPedidos().remove(pedido);
                    gestorPedidos.verPedidos().remove(pedido);
                    return EXITO_CANCELAR + ". "+ EXITO_BORRAR;
                }
            }
        }
        return ERROR_CANCELAR;        
    }

    //Métodos auxiliares
    /**
     * Verifica si un pedido cumple con los requisitos
     * @param fecha Fecha del pedido
     * @param hora Hora del pedido
     * @param productosDelPedido Lista de productos del pedido
     * @param cliente Cliente que hace el pedido
     * @return Resultado de la operación
     */
    public String validarPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente){
        if (fecha == null){
            return ERROR_FECHA;
        }
        if (hora == null) {
            return ERROR_HORA;
        }
        if (productosDelPedido == null || productosDelPedido.isEmpty()) {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }
        if(cliente == null){
            return ERROR_CLIENTE;
        }
        
        return VALIDACION_EXITO;
    }
    
    /**
     * Agrega un pedido a la lista dependiendo de si ya está agregado o no
     * @param pedido Un pedido
     * @return Resultado de la operación
     */
    public String agregarPedido(Pedido pedido){
        if(this.pedidos.contains(pedido)){ 
            return PEDIDOS_DUPLICADOS;
        }
        else{
            this.pedidos.add(pedido);
            return EXITO;
        }
    }
    
    /**
     * Método auxiliar para revisión desde consola.
     */
    @Override
    public void mostrarPedidos(){
        for (Pedido p : this.pedidos){
            p.mostrar();
        }
    }
}
