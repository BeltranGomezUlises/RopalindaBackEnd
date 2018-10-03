/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.ropalinda.utils.validation;

import static com.ub.ropalinda.utils.validation.InvalidValueException.MESSAGE_EMPTY_VALUE;
import java.util.Arrays;
import java.util.List;


/**
 * Container for all the validation methods of logical operators, list and
 * strings but not considering null validation
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
public class LogicalValidation {

    public static void isEmpty(String string) throws InvalidValueException {
        if (string != null) {
            if (string.isEmpty()) {
                throw new InvalidValueException(MESSAGE_EMPTY_VALUE);
            }
        }
    }

    public static void isEmpty(String string, String properyName) throws InvalidValueException {
        if (string != null) {
            if (string.isEmpty()) {
                throw new InvalidValueException(properyName, MESSAGE_EMPTY_VALUE);
            }
        }
    }

    public static void isEmpty(List list) throws InvalidValueException {
        if (list != null) {
            if (list.isEmpty()) {
                throw new InvalidValueException(MESSAGE_EMPTY_VALUE);
            }
        }
    }

    public static void isEmpty(List list, String propertyName) throws InvalidValueException {
        if (list != null) {
            if (list.isEmpty()) {
                throw new InvalidValueException(propertyName, MESSAGE_EMPTY_VALUE);
            }
        }
    }

    public static void isContained(String value, String... values) throws InvalidValueException {
        if (value != null) {
            for (String valueReference : values) {
                if (valueReference.equals(value)) {
                    return;
                }
            }
            throw new InvalidValueException("El valor solo puede ser: " + Arrays.toString(values));
        }
    }

    public static void isContained(String propertyName, String value, String... values) throws InvalidValueException {
        if (value != null) {
            for (String valueReference : values) {
                if (valueReference.equals(value)) {
                    return;
                }
            }
            throw new InvalidValueException("El valor de " + propertyName + " solo puede ser: " + Arrays.toString(values));
        }
    }

}
