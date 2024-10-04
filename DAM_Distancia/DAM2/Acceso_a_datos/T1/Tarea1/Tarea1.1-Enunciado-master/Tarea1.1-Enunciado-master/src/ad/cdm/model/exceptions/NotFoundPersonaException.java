/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.cdm.model.exceptions;

/**
 *
 * @author maria
 */
public class NotFoundPersonaException extends Exception {

    private int posicion = -1;

    public NotFoundPersonaException(int posicion) {
        super();

        this.posicion = posicion;

    }

    public NotFoundPersonaException(int posicion, String message, Throwable cause) {
        super(message, cause);
        this.posicion = posicion;
    }

}
