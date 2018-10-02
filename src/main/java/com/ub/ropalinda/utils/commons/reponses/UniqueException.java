/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.ropalinda.utils.commons.reponses;

/**
 *
 * @author ulises
 */
public class UniqueException extends Exception {

    private String field;
    private String value;

    public UniqueException() {
    }

    public UniqueException(String message) {
        super(message);
    }

    public UniqueException(String field, String value, String message) {
        super(message);
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
