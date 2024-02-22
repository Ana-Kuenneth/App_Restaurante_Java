/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import pedido.modelos.Pedido;
import pedido.modelos.ProductoDelPedido;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author Ana Kuenneth
 */
public interface IGestorPedidos {
    public static final String EXITO = "Pedido creado con éxito";
    public static final String ERROR = "No se pudo crear el pedido";
    public static final String EXITO_MODIFICAR = "Pedido modificado con éxito";
    public static final String EXITO_CANCELAR = "Pedido cancelado con éxito";
    public static final String EXITO_BORRAR = "Se borro el pedido de la lista de pedidos";
    public static final String ERROR_MODIFICAR = "No se pudo modificar el pedido";
    public static final String ERROR_CANCELAR = "No se puede cancelar el pedido en este estado";
   
    public static final String ERROR_FECHA = "La fecha del pedido es incorrecta";
    public static final String ERROR_HORA = "La hora del pedido es incorrecta";
    public static final String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tienen productos";
    public static final String ERROR_CLIENTE = "El pedido no tiene un cliente";
    public static final String ERROR_ESTADO = "El pedido no tiene un estado";
    public static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con ese número";
    public static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
    public static final String VALIDACION_EXITO = "El pedido tiene los datos correctos";
    
    public String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente);
    public String cambiarEstado(Pedido pedidoAModificar);
    public List<Pedido> verPedidos();
    public boolean hayPedidosConEsteCliente(Cliente cliente);
    public boolean hayPedidosConEsteProducto(Producto producto);
    public String cancelarPedido(Pedido pedido);
    public boolean existeEstePedido(Pedido pedido);
    public Pedido obtenerPedido(Integer numero);

    public void mostrarPedidos();
}
