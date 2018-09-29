package com.ub.ropalinda.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class UtilsJson {

    /**
     * MAPPER of object to json
     */
    public static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * Creates a string representation in json of the object
     *
     * @param object element to write
     * @return json representation in string
     * @throws JsonProcessingException if the mapper can't process the object
     */
    public static String write(Object object)
            throws JsonProcessingException {
        return MAPPER.writeValueAsString(object);
    }

    /**
     * Creates and instance of class T from the string json representation
     *
     * @param <T> Type of the instance to deserialize
     * @param json string value
     * @param clazz class type to return
     * @return instance with the values provided in the json string
     * @throws IOException if mapper can't process the string
     */
    public static <T> T read(String json, Class<T> clazz)
            throws IOException {
        return (T) MAPPER.readValue(json, clazz);
    }

}
