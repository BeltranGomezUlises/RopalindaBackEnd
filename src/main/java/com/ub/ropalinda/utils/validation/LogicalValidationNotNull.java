/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.ropalinda.utils.validation;

import static com.ub.ropalinda.utils.validation.InvalidValueException.MESSAGE_EMPTY_VALUE;
import static com.ub.ropalinda.utils.validation.InvalidValueException.MESSAGE_NULL_VALUE;
import java.util.Arrays;
import java.util.List;

/**
 * Container for all the validation methods of logical operators, list and strings considering null validation
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
public class LogicalValidationNotNull extends LogicalValidation {

    public static void isEmptyAndNotNull(String string) throws InvalidValueException {
        if (string != null) {
            if (string.isEmpty()) {
                throw new InvalidValueException(MESSAGE_EMPTY_VALUE);
            }
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
    }

    public static void isEmptyAndNotNull(String string, String propertyName) throws InvalidValueException {
        if (string != null) {
            if (string.isEmpty()) {
                throw new InvalidValueException(propertyName, MESSAGE_EMPTY_VALUE);
            }
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }

    public static void isEmptyAndNotNull(List list) throws InvalidValueException {
        if (list != null) {
            if (list.isEmpty()) {
                throw new InvalidValueException(MESSAGE_EMPTY_VALUE);
            }
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
    }

    public static void isEmptyAndNotNull(List list, String propertyName) throws InvalidValueException {
        if (list != null) {
            if (list.isEmpty()) {
                throw new InvalidValueException(propertyName, MESSAGE_EMPTY_VALUE);
            }
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }

    public static void isContainedAndNotNull(String value, String... values) throws InvalidValueException {
        if (value != null) {
            for (String valueReference : values) {
                if (valueReference.equals(value)) {
                    return;
                }
            }
            throw new InvalidValueException("El valor solo puede ser: " + Arrays.toString(values));
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
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
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }

}
