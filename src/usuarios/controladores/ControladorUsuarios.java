/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IControladorUsuarios;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static principal.controladores.ControladorPrincipal.establecerLookAndFeel;
import principal.vistas.VentanaPrincipal;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Usuario;
import usuarios.modelos.ModeloTablaUsuarios;
import usuarios.vistas.VentanaUsuarios;

/**
 * Clase destinada al manejo, visualización y modificación de los usuarios
 * @author Martinez Santiago
 */
public class ControladorUsuarios implements IControladorUsuarios{
    //Atributos
    private ModeloTablaUsuarios mt = new ModeloTablaUsuarios();
    private VentanaUsuarios ventana;
    IGestorUsuarios gu = GestorUsuarios.instanciar();
    
    /**
     * Constructor
     * @param ventanapadre 
     */
    public ControladorUsuarios(VentanaPrincipal ventanapadre) {
        establecerLookAndFeel("Nimbus");
        this.ventana = new VentanaUsuarios(this, ventanapadre, true);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setTitle(IControladorUsuarios.TITULO);
        this.ventana.setVisible(true);
        this.establecerEstadoDeBotones(gu.verUsuarios());
    }
    
    /**
     * Método encargado de ejecutar la ventana de alta de usuarios
     * @param evt 
     */
    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMUsuario controladorAMU = new ControladorAMUsuario(ventana);
        ventana.verTablaUsuarios().setModel(new ModeloTablaUsuarios(gu.verUsuarios()));
        
    }

    /**
     * Método encargado de ejecutar la ventana de modificación de usuarios
     * @param evt 
     */
    @Override
    public void btnModificarClic(ActionEvent evt) {
         int filaSelect = ventana.verTablaUsuarios().getSelectedRow();

        if (filaSelect != -1) {
            Usuario usuarioSelect = mt.verUsuario(this.ventana.verTablaUsuarios().getSelectedRow());

            IControladorAMUsuario modificar = new ControladorAMUsuario(ventana, usuarioSelect.verCorreo());
            
        } else {
            JOptionPane.showMessageDialog(ventana, "No ha seleccionado un usuario para modificar");
        }
    }
    
    /**
     * Borra el elemento seleccionado de la tabla, Previamente muestra un mensaje de confirmacion.
     */
    @Override
    public void btnBorrarClic(ActionEvent evt) {
    int opcion = JOptionPane.showOptionDialog(this.ventana, CONFIRMACION, TITULO, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Borrar", "Cancelar"}, this);
        if (opcion == JOptionPane.YES_OPTION) {
            Usuario borraUsuario = mt.verUsuario(this.ventana.verTablaUsuarios().getSelectedRow());
            System.out.println(gu.borrarUsuario(borraUsuario));
            ventana.verTablaUsuarios().setModel(new ModeloTablaUsuarios());
        }
    }

    /**
     * Método encargado de la disposición de los elementos de la ventana según su actual estado
     * @param evt 
     */
    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        this.ventana.verTxtApellido().setText(null);
        this.ventana.verBtnModificar().setEnabled(false);
        this.ventana.verBtnBorrar().setEnabled(false);

        mt.refrescarTabla();

        if (mt.getRowCount() > 0) {
            this.ventana.verTablaUsuarios().setRowSelectionInterval(0, 0);
            this.ventana.verBtnBorrar().setEnabled(true);
            this.ventana.verBtnModificar().setEnabled(true);
        } else {
            this.ventana.verBtnBorrar().setEnabled(false);
            this.ventana.verBtnModificar().setEnabled(false);
        }
        this.actualizarDatos();
    }
      
    /**
     * Método encargado de cerrar la ventana, se vuelve a la ventana anterior o padre
     * @param evt 
     */
    @Override
    public void btnVolverClic(ActionEvent evt) {
        int opcion = JOptionPane.showConfirmDialog(ventana, "¿Desea Volver?", "Salir", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            this.ventana.dispose();
        }
    }

    /**
     * Método encargado de buscar usuarios por su apellido (parcial o completamente) o todos si no se escribe nada en el label
     * @param evt 
     */
    @Override
    public void btnBuscarClic(ActionEvent evt) {
        if (ventana.verTxtApellido().getText().isEmpty()) {
            ventana.verTablaUsuarios().setModel(new ModeloTablaUsuarios());
        } else {
            List<Usuario> usuario = new ArrayList<>();
            IGestorUsuarios gu = GestorUsuarios.instanciar();
            usuario = gu.buscarUsuarios(ventana.verTxtApellido().getText());
            ventana.verTablaUsuarios().setModel(new ModeloTablaUsuarios(usuario));
        }
    }
    
    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //Métodos auxiliares
    /**
     * Establece el estado de los botones de la ventana
     * Si no hay usuarios que mostrar, los botones Borrar y Modificar permanecen deshablitados
     * @param lista 
     */
    private void establecerEstadoDeBotones(List<Usuario> lista) {
        if (lista.isEmpty()) {
            this.ventana.verBtnBorrar().setEnabled(false);
            this.ventana.verBtnModificar().setEnabled(false);
        } else {
            this.ventana.verBtnBorrar().setEnabled(true);
            this.ventana.verBtnModificar().setEnabled(true);
        }
    }
    
    /**
     * Destinado a la actualización de datos de los usuarios en la tabla
     */
    private void actualizarDatos() {
        this.ventana.verTablaUsuarios().setModel(new ModeloTablaUsuarios());
    }
}
