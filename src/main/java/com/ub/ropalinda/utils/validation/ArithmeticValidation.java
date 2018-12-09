/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.ropalinda.utils.validation;

import static com.ub.ropalinda.utils.validation.InvalidValueException.MESSAGE_INVALID_VALUE;

/**
 * Container for all the validation methods of arithmetic operators but not considering null validation
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
public class ArithmeticValidation extends LogicalValidationNotNull {

    public static void isGrater(Integer value, Integer reference)
            throws InvalidValueException {
        if (value != null) {
            if (value > reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isGraterEqual(Integer value, Integer reference)
            throws InvalidValueException {
        if (value != null) {
            if (value >= reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isLower(Integer value, Integer reference)
            throws InvalidValueException {
        if (value != null) {
            if (value < reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isLowerEqual(Integer value, Integer reference)
            throws InvalidValueException {
        if (value != null) {
            if (value <= reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isEqual(Integer value, Integer reference)
            throws InvalidValueException {
        if (value != null) {
            if (value.equals(reference)) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isGrater(Float value, Float reference)
            throws InvalidValueException {
        if (value != null) {
            if (value > reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isGraterEqual(Float value, Float reference)
            throws InvalidValueException {
        if (value != null) {
            if (value >= reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isLower(Float value, Float reference)
            throws InvalidValueException {
        if (value != null) {
            if (value < reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isLowerEqual(Float value, Float reference)
            throws InvalidValueException {
        if (value != null) {
            if (value <= reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isEqual(Float value, Float reference)
            throws InvalidValueException {
        if (value != null) {
            if (value.equals(reference)) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isGrater(Double value, Double reference)
            throws InvalidValueException {
        if (value != null) {
            if (value > reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isGraterEqual(Double value, Double reference)
            throws InvalidValueException {
        if (value != null) {
            if (value >= reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isLower(Double value, Double reference)
            throws InvalidValueException {
        if (value != null) {
            if (value < reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isLowerEqual(Double value, Double reference)
            throws InvalidValueException {
        if (value != null) {
            if (value <= reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isEqual(Double value, Double reference)
            throws InvalidValueException {
        if (value != null) {
            if (value.equals(reference)) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isGrater(Integer value, Integer reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value > reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isGraterEqual(Integer value, Integer reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value >= reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isLower(Integer value, Integer reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value < reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isLowerEqual(Integer value, Integer reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value <= reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isEqual(Integer value, Integer reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value.equals(reference)) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isGrater(Float value, Float reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value > reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isGraterEqual(Float value, Float reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value >= reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isLower(Float value, Float reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value < reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isLowerEqual(Float value, Float reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value <= reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isEqual(Float value, Float reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value.equals(reference)) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isGrater(Double value, Double reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value > reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isGraterEqual(Double value, Double reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value >= reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isLower(Double value, Double reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value < reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isLowerEqual(Double value, Double reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value <= reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        }
    }

    public static void isEqual(Double value, Double reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value.equals(reference)) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        }
    }

}
