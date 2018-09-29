package com.ub.ropalinda.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class UtilsDB {

    //<editor-fold defaultstate="collapsed" desc="JPA utils">
    /*
        the jpa clients are defined here,
        you need to add the factories and streams providers
        for each persistence unit you nedd
     */
    //</editor-fold>
    private static EntityManagerFactory eMFactory;

    /**
     * PERSISTENCE UNIT NAMES
     */
    private static final String EASYMONEY_UNIT_NAME = "ropalinda";

    /**
     * metodo fábrica de manejadores de entidad de de la base de datos "easymoney"
     *
     * @return entityManagerFactory de la conexion a la base de datos CG
     */
    public static EntityManagerFactory getEMFactoryCG() {
        if (eMFactory == null) {
            eMFactory = Persistence.createEntityManagerFactory(EASYMONEY_UNIT_NAME);
        }
        return eMFactory;
    }

}
