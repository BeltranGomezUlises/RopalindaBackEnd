/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.ropalinda.utils.validation;

/**
 *
 * @author ulises
 */
public class InvalidValueException extends Exception {

    public static final String MESSAGE_EMPTY_VALUE = "Valor vacío";
    public static final String MESSAGE_NULL_VALUE = "Propiedad null";
    public static final String MESSAGE_INVALID_VALUE = "Propiedad con valor inválido";

    private String propertyName;

    public InvalidValueException(String message) {
        super(message);
    }

    public InvalidValueException(String propertyName, String message) {
        super(message);
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;

    }
}
