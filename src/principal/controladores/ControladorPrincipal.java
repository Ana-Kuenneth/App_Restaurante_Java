/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorPrincipal;
import javax.swing.UIManager;

/**
 * Clase destinada para el funcionamiento de la aplicación
 * @author Ana Kuenneth
 */
public class ControladorPrincipal {
     
    public static void main(String[] args){
        IControladorPrincipal cp = ControladorVentanaPrincipal.instanciar();
        
        establecerLookAndFeel("Nimbus"); 
//        System.out.println("USUARIOS");
//        System.out.println("=====");
//        usuarios=gu.verUsuarios();
//        for(Usuario u : usuarios) {
//            u.mostrar();
//            System.out.println();
//        }

    } 
    
    public static void establecerLookAndFeel(String laf) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (laf.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } 
            catch (Exception e2) {
            }
        }
    
    }
}
