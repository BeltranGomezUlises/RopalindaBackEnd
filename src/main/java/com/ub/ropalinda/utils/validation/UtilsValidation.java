/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.ropalinda.utils.validation;

import static com.ub.ropalinda.utils.validation.InvalidValueException.MESSAGE_EMPTY_VALUE;
import static com.ub.ropalinda.utils.validation.InvalidValueException.MESSAGE_INVALID_VALUE;
import static com.ub.ropalinda.utils.validation.InvalidValueException.MESSAGE_NULL_VALUE;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Container of all validation methods
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
public class UtilsValidation extends ArithmeticValidationNotNull {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PHONE_NUMBER_PATTERN = "^[0-9]*$";
    private static final String SPECIAL_CHARS = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";

    public static final void isEmail(String value) throws InvalidValueException {
        evaluate(EMAIL_PATTERN, value);
    }

    public static final void isEmail(String value, String propertyName)
            throws InvalidValueException {
        evaluate(EMAIL_PATTERN, value, propertyName);
    }

    public static final void isEmailAndNotNull(String value) throws InvalidValueException {
        evaluateAndNotNull(EMAIL_PATTERN, value);
    }

    public static final void isEmailAndNotNull(String value, String propertyName)
            throws InvalidValueException {
        evaluateAndNotNull(EMAIL_PATTERN, value, propertyName);
    }

    public static final void isPhone(String value) throws InvalidValueException {
        evaluate(PHONE_NUMBER_PATTERN, value);
    }

    public static final void isPhone(String value, String propertyName)
            throws InvalidValueException {
        evaluate(PHONE_NUMBER_PATTERN, value, propertyName);
    }

    public static final void isPhoneAndNotNull(String value) throws InvalidValueException {
        evaluateAndNotNull(PHONE_NUMBER_PATTERN, value);
    }

    public static final void isPhoneAndNotNull(String value, String propertyName)
            throws InvalidValueException {
        evaluateAndNotNull(PHONE_NUMBER_PATTERN, value, propertyName);
    }

    /**
     * Validates that the text contains special character and do not be empty,
     * ignoring null
     *
     * @param s
     * @param propertyName name of the property to evaluate
     * @throws com.ub.ropalinda.utils.validation.InvalidValueException
     *
     */
    public static void containsSpecialCharacter(final String s, final String propertyName)
            throws InvalidValueException {
        if (s != null) {
            if (s.isEmpty()) {
                throw new InvalidValueException(propertyName, MESSAGE_EMPTY_VALUE);
            }
            for (int i = 0; i < s.length(); i++) {
                if (SPECIAL_CHARS.contains(s.substring(i, (i + 1)))) {
                    throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
                }
            }
        }

    }

    /**
     * Validates that the text contains special character and do not be empty,
     * considering not null
     *
     * @param s
     * @param propertyName name of the property to evaluate
     * @throws com.ub.ropalinda.utils.validation.InvalidValueException
     *
     */
    public static void containsSpecialCharacterAndNotNull(final String s,
            final String propertyName) throws InvalidValueException {
        if (s == null) {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
        if (s.isEmpty()) {
            throw new InvalidValueException(propertyName, MESSAGE_EMPTY_VALUE);
        }
        for (int i = 0; i < s.length(); i++) {
            if (SPECIAL_CHARS.contains(s.substring(i, (i + 1)))) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        }
    }

    /**
     * Validate the value of the property in the object with the pattern given
     * as regular expresion, includes null validation, ignoring null
     *
     * @param pattern pattern to compile
     * @param object object to evaluate
     * @param propertyName name of the property to evaluate
     * @throws utils.UtilsValidation.PropertyValueException if the evaluation
     * fails
     */
    private static void evaluate(final String pattern, String s,
            String propertyName) throws InvalidValueException {
        if (s != null) {
            if (s.isEmpty()) {
                throw new InvalidValueException(propertyName, MESSAGE_EMPTY_VALUE);
            }
            Matcher matcher = Pattern.compile(pattern).matcher(s);
            if (!matcher.matches()) {
                throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
            }
        }

    }

    /**
     * Validate the value of the property in the object with the pattern given
     * as regular expresion, includes null validation
     *
     * @param pattern pattern to compile
     * @param object object to evaluate
     * @param propertyName name of the property to evaluate
     * @throws InvalidValueException if the evaluation fails
     */
    private static void evaluateAndNotNull(final String pattern, String s,
            String propertyName) throws InvalidValueException {
        if (s == null) {
            throw new InvalidValueException(propertyName, MESSAGE_NULL_VALUE);
        }
        if (s.isEmpty()) {
            throw new InvalidValueException(propertyName, MESSAGE_EMPTY_VALUE);
        }
        Matcher matcher = Pattern.compile(pattern).matcher(s);
        if (!matcher.matches()) {
            throw new InvalidValueException(propertyName, MESSAGE_INVALID_VALUE);
        }
    }

    /**
     * Validate the value of the property in the object with the pattern given
     * as regular expresion, includes null validation, ignoring null
     *
     * @param pattern pattern to compile
     * @param object object to evaluate
     * @param propertyName name of the property to evaluate
     * @throws utils.UtilsValidation.PropertyValueException if the evaluation
     * fails
     */
    private static void evaluate(final String pattern, String s)
            throws InvalidValueException {
        if (s != null) {
            if (s.isEmpty()) {
                throw new InvalidValueException(MESSAGE_EMPTY_VALUE);
            }
            Matcher matcher = Pattern.compile(pattern).matcher(s);
            if (!matcher.matches()) {
                throw new InvalidValueException(MESSAGE_INVALID_VALUE);
            }
        }

    }

    /**
     * Validate the value of the property in the object with the pattern given
     * as regular expresion, includes null validation
     *
     * @param pattern pattern to compile
     * @param object object to evaluate
     * @param propertyName name of the property to evaluate
     * @throws InvalidValueException if the evaluation fails
     */
    private static void evaluateAndNotNull(final String pattern, String s)
            throws InvalidValueException {
        if (s == null) {
            throw new InvalidValueException(MESSAGE_NULL_VALUE);
        }
        if (s.isEmpty()) {
            throw new InvalidValueException(MESSAGE_EMPTY_VALUE);
        }
        Matcher matcher = Pattern.compile(pattern).matcher(s);
        if (!matcher.matches()) {
            throw new InvalidValueException(MESSAGE_INVALID_VALUE);
        }
    }
}
