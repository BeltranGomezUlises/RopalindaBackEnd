/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.ropalinda.utils.validation;

import static com.ub.ropalinda.utils.validation.InvalidValueException.MESSAGE_INVALID_VALUE;
import static com.ub.ropalinda.utils.validation.InvalidValueException.MESSAGE_NULL_VALUE;


/**
 * Container for all the validation methods of arithmetic operators considering
 * null validation
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
public class ArithmeticValidationNotNull extends ArithmeticValidation {

    public static void isGraterAndNotNull(Integer value, Integer reference)
            throws InvalidValueException {
        if (value != null) {
            if (value > reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
    }

    public static void isGraterEqualAndNotNull(Integer value, Integer reference)
            throws InvalidValueException {
        if (value != null) {
            if (value >= reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
    }

    public static void isLowerAndNotNull(Integer value, Integer reference)
            throws InvalidValueException {
        if (value != null) {
            if (value < reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
    }

    public static void isLowerEqualAndNotNull(Integer value, Integer reference)
            throws InvalidValueException {
        if (value != null) {
            if (value <= reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
    }

    public static void isEqualAndNotNull(Integer value, Integer reference)
            throws InvalidValueException {
        if (value != null) {
            if (value.equals(reference)) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
    }

    public static void isGraterAndNotNull(Float value, Float reference)
            throws InvalidValueException {
        if (value != null) {
            if (value > reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
    }

    public static void isGraterEqualAndNotNull(Float value, Float reference)
            throws InvalidValueException {
        if (value != null) {
            if (value >= reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
    }

    public static void isLowerAndNotNull(Float value, Float reference)
            throws InvalidValueException {
        if (value != null) {
            if (value < reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
    }

    public static void isLowerEqualAndNotNull(Float value, Float reference)
            throws InvalidValueException {
        if (value != null) {
            if (value <= reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
    }

    public static void isEqualAndNotNull(Float value, Float reference)
            throws InvalidValueException {
        if (value != null) {
            if (value.equals(reference)) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
    }

    public static void isGraterAndNotNull(Double value, Double reference)
            throws InvalidValueException {
        if (value != null) {
            if (value > reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
    }

    public static void isGraterEqualAndNotNull(Double value, Double reference)
            throws InvalidValueException {
        if (value != null) {
            if (value >= reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
    }

    public static void isLowerAndNotNull(Double value, Double reference)
            throws InvalidValueException {
        if (value != null) {
            if (value < reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
    }

    public static void isLowerEqualAndNotNull(Double value, Double reference)
            throws InvalidValueException {
        if (value != null) {
            if (value <= reference) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
    }

    public static void isEqualAndNotNull(Double value, Double reference)
            throws InvalidValueException {
        if (value != null) {
            if (value.equals(reference)) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
    }

    public static void isGraterAndNotNull(Integer value, Integer reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value > reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }

    public static void isGraterEqualAndNotNull(Integer value, Integer reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value >= reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }

    public static void isLowerAndNotNull(Integer value, Integer reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value < reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }

    public static void isLowerEqualAndNotNull(Integer value, Integer reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value <= reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }

    public static void isEqualAndNotNull(Integer value, Integer reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value.equals(reference)) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }

    public static void isGraterAndNotNull(Float value, Float reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value > reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }

    public static void isGraterEqualAndNotNull(Float value, Float reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value >= reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }

    public static void isLowerAndNotNull(Float value, Float reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value < reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }

    public static void isLowerEqualAndNotNull(Float value, Float reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value <= reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }

    public static void isEqualAndNotNull(Float value, Float reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value.equals(reference)) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }

    public static void isGraterAndNotNull(Double value, Double reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value > reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }

    public static void isGraterEqualAndNotNull(Double value, Double reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value >= reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }

    public static void isLowerAndNotNull(Double value, Double reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value < reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }

    public static void isLowerEqualAndNotNull(Double value, Double reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value <= reference) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }

    public static void isEqualAndNotNull(Double value, Double reference,
            String propertyName) throws InvalidValueException {
        if (value != null) {
            if (value.equals(reference)) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        } else {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
    }
}
