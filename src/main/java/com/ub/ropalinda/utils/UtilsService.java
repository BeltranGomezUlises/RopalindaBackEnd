/*
 * Copyright (C) 2018 Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.ub.ropalinda.utils;

import com.ub.ropalinda.utils.commons.enums.Status;
import com.ub.ropalinda.utils.commons.reponses.Response;
import com.ub.ropalinda.utils.commons.reponses.UniqueException;
import com.ub.ropalinda.utils.validation.InvalidValueException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class UtilsService {

    /**
     * Sets access denied values to response
     *
     * @param res object to set values
     */
    public static final void invalidToken(Response res) {
        res.setStatus(Status.ACCESS_DENIED);
        res.setDevMessage("Inválid token");
    }

    /**
     * Sets unique values to response
     *
     * @param res object to set values
     * @param e unique exception with field and value
     */
    public static final void unique(Response res, UniqueException e) {
        res.setStatus(Status.WARNING);
        res.setMessage("Valor inválido");
        res.setDevMessage(e.getMessage());
        Map<String, String> metadata = new HashMap<>();
        metadata.put("value", e.getValue());
        metadata.put("field", e.getField());
        res.setMetaData(metadata);
    }

    /**
     * Sets invalid param exception values to response
     *
     * @param res object to set values
     * @param e exception handled
     */
    public static final void invalidParam(Response res, InvalidValueException e) {
        res.setStatus(Status.INVALID_PARAM);
        if (e.getPropertyName() != null) {
            res.setMessage(e.getMessage() + ": " + e.getPropertyName());
        } else {
            res.setMessage(e.getMessage());
        }
    }

    /**
     * Sets invalid param exception values to response
     *
     * @param res object to set values
     * @param e exception handled
     * @param message message to send to the final client
     */
    public static final void invalidParam(Response res, InvalidValueException e,
            String message) {
        res.setStatus(Status.INVALID_PARAM);
        if (e.getPropertyName() != null) {
            res.setDevMessage(e.getMessage() + ": " + e.getPropertyName());
        } else {
            res.setDevMessage(e.getMessage());
        }
        res.setMessage(message);
    }

    /**
     * Sets warning values to response
     *
     * @param res object to set values
     * @param message string message to final client
     * @param devMessage string message to developer
     */
    public static final void warning(Response res, String message, String devMessage) {
        res.setStatus(Status.WARNING);
        res.setMessage(message);
        res.setDevMessage(devMessage);
    }

    /**
     * Sets warning values to response
     *
     * @param res object to set values
     * @param devMessage string message to developer
     */
    public static final void warning(Response res, String devMessage) {
        res.setStatus(Status.WARNING);
        res.setDevMessage(devMessage);
    }

    /**
     * Sets error values to response
     *
     * @param res object to set values
     * @param ex error handled
     * @param message message to the final client
     */
    public static final void error(Response res, Throwable ex, String message) {
        res.setStatus(Status.ERROR);
        res.setMessage(message);
        res.setDevMessage(ex.getMessage());
        java.util.logging.Logger.getLogger("ERROR").log(Level.SEVERE, null, ex);
    }

    /**
     * Sets error values to response
     *
     * @param res object to set values
     * @param ex error handled
     */
    public static final void error(Response res, Throwable ex) {
        res.setStatus(Status.ERROR);
        res.setMessage("a programming error occurred, "
                + "check with the system provider");
        res.setDevMessage(ex.getMessage());
        java.util.logging.Logger.getLogger("ERROR").log(Level.SEVERE, null, ex);
    }

    /**
     * Sets ok value to response
     *
     * @param res object to set values
     * @param message string message to final client
     * @param devMessage string message to developer
     */
    public static final void ok(Response res, String message,
            String devMessage) {
        res.setStatus(Status.OK);
        res.setMessage(message);
        res.setDevMessage(devMessage);
    }

    /**
     * Sets ok value to response
     *
     * @param res object to set values
     * @param data object data business
     * @param message string message to final client
     * @param devMessage string message to developer
     */
    public static final void ok(Response res, Object data, String message,
            String devMessage) {
        res.setStatus(Status.OK);
        res.setData(data);
        res.setMessage(message);
        res.setDevMessage(devMessage);
    }

    /**
     * Sets ok value to response
     *
     * @param res object to set values
     * @param data object data business
     */
    public static final void ok(Response res, Object data) {
        res.setStatus(Status.OK);
        res.setData(data);
    }

    /**
     * Sets ok value to response
     *
     * @param res object to set values
     * @param data object data business
     * @param devMessage string message to developer
     */
    public static final void ok(Response res, Object data, String devMessage) {
        res.setStatus(Status.OK);
        res.setData(data);
        res.setDevMessage(devMessage);
    }

    /**
     * Sets ok value to response
     *
     * @param res object to set values
     * @param message string message to final client
     * @param data object data business
     */
    public static final void ok(Response res, String message, Object data) {
        res.setStatus(Status.OK);
        res.setData(data);
        res.setMessage(message);
    }

    /**
     * Sets ok value to response
     *
     * @param res object to set values
     * @param data object data business
     * @param metaData object no data business, but needed
     * @param message string message to final client
     * @param devMessage string message to developer
     */
    public static final void ok(Response res, Object data, Object metaData,
            String message, String devMessage) {
        res.setStatus(Status.OK);
        res.setData(data);
        res.setMetaData(metaData);
        res.setMessage(message);
        res.setDevMessage(devMessage);
    }

    /**
     * Sets ok value to response
     *
     * @param res object to set values
     * @param devMessage string message to developer
     */
    public static final void ok(Response res, String devMessage) {
        res.setStatus(Status.OK);
        res.setDevMessage(devMessage);
    }

}
