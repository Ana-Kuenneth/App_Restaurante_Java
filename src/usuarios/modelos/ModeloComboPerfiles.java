/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios.modelos;

import javax.swing.DefaultComboBoxModel;

/**
 * 
 * @author root
 */
public class ModeloComboPerfiles extends DefaultComboBoxModel {
    /**
     * Constructor.
    */
    public ModeloComboPerfiles() { 
        for (Perfil perfil : Perfil.values()) {
            this.addElement(perfil); 
        }
    }
    
    /**
     * Devuelve la categoria seleccionada
     * @return Perfil  - perfil seleccionado
    */
    public Perfil obtenerPerfil() { 
        return (Perfil)this.getSelectedItem();
    }
    
    /**
     * Selecciona el perfil especificado
     * @param perfil perfil
    */
    public void seleccionarPerfil(Perfil perfil) {
        this.setSelectedItem(perfil);
    }
}
