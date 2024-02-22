/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorPrincipal;
import interfaces.IControladorUsuarios;
import interfaces.IGestorProductos;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import static principal.controladores.ControladorPrincipal.establecerLookAndFeel;
import principal.vistas.VentanaPrincipal;
import usuarios.controladores.ControladorUsuarios;

/**
 * Clase destinada al control y manejo de la ventana principal del programa
 * @author Martinez Santiago
 */
public class ControladorVentanaPrincipal implements IControladorPrincipal{
    private static ControladorVentanaPrincipal instancia;
    private VentanaPrincipal ventanaPrincipal;
    
    public ControladorVentanaPrincipal() {
        establecerLookAndFeel("Nimbus");
        this.ventanaPrincipal = new VentanaPrincipal(this);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setTitle(IControladorPrincipal.TITULO);
        ventanaPrincipal.setVisible(true);
    }
    
    public static ControladorVentanaPrincipal instanciar() {
        if (instancia == null) {
            instancia = new ControladorVentanaPrincipal();
        }
        return instancia;
    }
    
    @Override
    public void btnUsuariosClic(ActionEvent evt) {
        IControladorUsuarios controladorUsuarios = new ControladorUsuarios (this.ventanaPrincipal); 
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        int opcion = JOptionPane.showConfirmDialog(ventanaPrincipal, "¿Desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            this.ventanaPrincipal.dispose();
            System.exit(0);
        }
    }
    
    @Override
    public void btnProductosClic(ActionEvent evt) {
        //
    }

    @Override
    public void btnPedidosClic(ActionEvent evt) {
        //
    }
}
