/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 * Clase que contiene los componentes de la tabla de la ventana VentanaUsuarios
 * @author Martinez Santiago
 */
public class ModeloTablaUsuarios extends AbstractTableModel{
    //Atributos
    IGestorUsuarios gu = GestorUsuarios.instanciar();
    private List<String> columnas = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();


    /**
     * Constructor sobrecargado 
     */
    public ModeloTablaUsuarios() {
        this.columnas.add("Apellidos");
        this.columnas.add("Nombres");
        this.columnas.add("Perfil");
        this.usuarios = gu.verUsuarios();
    }
    
    public ModeloTablaUsuarios(List<Usuario> usuarios) {
        this.columnas.add("Apellidos");
        this.columnas.add("Nombres");
        this.columnas.add("Perfil");
        this.usuarios = usuarios;
    }
    
    //Métodos
    /**
     * Devuelve el número de filas o usuarios de la tabla
     * @return 
     */
    @Override
    public int getRowCount() {
        return this.usuarios.size();
    }

    /**
     * Devuelve el número de columnas o usuarios de la tabla
     * @return 
     */
    @Override
    public int getColumnCount() {
        return this.columnas.size();
    }

    /**
     * Asigna nombre a las columnas correspondientes
     * @param numFila
     * @param numColumna
     * @return 
     */
    @Override
    public Object getValueAt(int numFila, int numColumna) {
        Usuario usuario = this.usuarios.get(numFila);
        
        switch(numColumna){
            case 0: return usuario.verApellido();
            case 1: return usuario.verNombre();
            case 2: return usuario.getClass().getSimpleName();
            default: return usuario.verNombre();
        }
    }

    /**
     * Obtiene el nombre de la columna y lo devuelve
     * @param columna
     * @return 
     */
    public String getColumnName(int columna){
        return this.columnas.get(columna);
    }
    
    /**
     * Actualiza los cambios de la tabla
     * @param usuariosEncontrados 
     */
    public void refrescarTabla(List<Usuario> usuariosEncontrados) {
        this.usuarios = gu.verUsuarios();
        this.fireTableDataChanged();
    }
    
    /**
     * Método sobrecargado, Actualiza los cambios de la tabla.
     */
    public void refrescarTabla(){
        IGestorUsuarios gestor = GestorUsuarios.instanciar();
        this.usuarios = gestor.verUsuarios();
        this.fireTableDataChanged();
    }
    
    /**
     * Busca un usuario segun su apellido
     * @param valor 
     */
    public void buscarUsuario (String valor) {
        this.usuarios = gu.buscarUsuarios(valor);
        this.fireTableDataChanged();
    }
    
    /**
     * Devuelve el usuario de acuerdo a la fila seleccionada
     * @param fila
     * @return 
     */
    public Usuario verUsuario(int fila) {
        return this.usuarios.get(fila);    
    }
}
