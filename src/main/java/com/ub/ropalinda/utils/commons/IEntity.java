package com.ub.ropalinda.utils.commons;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Base interface for any entity in the project
 *
 * @author Ulises Beltrán Gómez
 * @param <K> Primary key type for the entity
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class IEntity<K> {

    /**
     * Obtain the object that represents the primary key
     *
     * @return object that represents the primary key
     */
    public abstract K objectPK();

    public abstract boolean getActive();

    public abstract void setActive(boolean active);

}
