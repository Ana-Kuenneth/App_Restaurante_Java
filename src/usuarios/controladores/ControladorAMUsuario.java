/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import static principal.controladores.ControladorPrincipal.establecerLookAndFeel;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.ModeloComboPerfiles;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaAMUsuario;

/**
 * Clase destinada al control y manejo de la ventana de alta y modificación de los usuarios
 * @author Martinez Santiago
 */
public class ControladorAMUsuario implements IControladorAMUsuario {
    //Atributos
    private VentanaAMUsuario ventanaAM;
    private ControladorUsuarios controladoru;
    IGestorUsuarios gu = GestorUsuarios.instanciar();
    private static ControladorAMUsuario instancia;

    /**
     * Constructor.
     * @param ventanapadre 
     */
    public ControladorAMUsuario(javax.swing.JDialog ventanapadre) {
        establecerLookAndFeel("Nimbus");
        this.ventanaAM = new VentanaAMUsuario(this, ventanapadre, true);
        this.ventanaAM.setLocationRelativeTo(null);
        this.ventanaAM.setTitle(IControladorAMUsuario.TITULO_NUEVO);
        this.ventanaAM.setVisible(true);
    }

    /**
     * Constructor sobrecargado
     * @param ventanapadre
     * @param correo 
     */
    public ControladorAMUsuario(javax.swing.JDialog ventanapadre, String correo) {
        establecerLookAndFeel("Nimbus");
        this.ventanaAM = new VentanaAMUsuario(this, ventanapadre, true);
        this.ventanaAM.setLocationRelativeTo(null);
        this.ventanaAM.setTitle(IControladorAMUsuario.TITULO_NUEVO);
        this.ventanaAM.verCorreo().setText(correo);
        this.ventanaAM.verCorreo().setEnabled(false);
        this.ventanaAM.setVisible(true);
    }

    /**
     * Método auxiliar para poder ver la ventana
     * @return 
     */
    public VentanaAMUsuario verVentana() {
        return ventanaAM;
    }

    /**
     * Método enfocado en el guardado y modificación de los usuarios, utilizado a partir del accionar del botón Guardar de la ventana
     * @param evt 
     */
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String correo = this.ventanaAM.verCorreo().getText().trim();
        String apellido = this.ventanaAM.verApellido().getText().trim();
        String nombre = this.ventanaAM.verNombre().getText().trim();
        String clave = new String(this.ventanaAM.verClave().getPassword());
        String claveRepetida = new String(this.ventanaAM.verClaveRep().getPassword());
        Perfil perfil = ((ModeloComboPerfiles) this.ventanaAM.verPerfil().getModel()).obtenerPerfil();

        if (!this.ventanaAM.verCorreo().isEnabled()) {
            String mensajeErrorMod = gu.modificarUsuario(correo, apellido, nombre, clave, claveRepetida);
            if (correo.isEmpty() && apellido.isEmpty() && nombre.isEmpty() && clave.isEmpty() && claveRepetida.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe completar todos los campos", gu.ERROR, JOptionPane.ERROR_MESSAGE);
            }
            if (!mensajeErrorMod.equals(gu.EXITO)) {
                JOptionPane.showMessageDialog(null, mensajeErrorMod, gu.ERROR, JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, mensajeErrorMod, gu.VALIDACION_EXITO, JOptionPane.PLAIN_MESSAGE);
                this.ventanaAM.dispose();
            }
        } else {
            String mensajeError = gu.crearUsuario(correo, apellido, nombre, perfil, clave, claveRepetida);

            if (correo.isEmpty() && apellido.isEmpty() && nombre.isEmpty() && clave.isEmpty() && claveRepetida.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe completar todos los campos", gu.ERROR, JOptionPane.ERROR_MESSAGE);
            }
            if (!mensajeError.equals(gu.EXITO)) {
                JOptionPane.showMessageDialog(null, mensajeError, gu.ERROR, JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, mensajeError, gu.VALIDACION_EXITO, JOptionPane.PLAIN_MESSAGE);
                this.ventanaAM.dispose();
            }

            System.out.println(mensajeError);
            System.out.println("Usuarios");
            System.out.println("========");

            for (Usuario u : this.gu.verUsuarios()) {
                u.mostrar();
                System.out.println();
            }
        }
    }

    /**
     * Método encargado de cerrar la ventana, cancela la acción de crear un nuevo usuario o modificar un usuario
     * @param evt 
     */
    @Override
    public void btnCancelarClic(ActionEvent evt) {
        int opcion = JOptionPane.showConfirmDialog(ventanaAM, "¿Desea Cancelar?", "Cancelar", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            this.ventanaAM.dispose();
        }
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {

        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
