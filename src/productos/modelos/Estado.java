/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 * Determina la condición de un producto
 * @author Martinez Santiago
 */
public enum Estado {
    DISPONIBLE("Disponible"), NO_DISPONIBLE("No Disponible");
    
    /**
     * Guarda el valor de la enumeración elegida.
     */
    private String value;
    
    /**
     * Constructor
     * @param value value
     */
    private Estado(String value){
        this.value=value;
    }
    
    ///Métodos
    /**
     * Muestra la instancia en forma de String, en este caso el valor elegido
     * @return value
     */
    @Override    
    public String toString() {
        return this.value ;
    }
    
    /**
     * Devuelve el estado correspondiente a partir del valor recibido.
     * @param value Estado en forma de String
     * @return Un estado
     */
    public static Estado fromString(String value) {
        for (Estado estado : Estado.values()) {
            if (estado.value.equalsIgnoreCase(value)) {
                return estado;
            }
        }
        return null;
    }
}
