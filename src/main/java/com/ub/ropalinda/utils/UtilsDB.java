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
    private static final String UNIT_NAME = "ropalinda";

    /**
     * metodo fábrica de manejadores de entidad de de la base de datos "easymoney"
     *
     * @return entityManagerFactory de la conexion a la base de datos CG
     */
    public static EntityManagerFactory getEMFactoryCG() {
        if (eMFactory == null) {
            eMFactory = Persistence.createEntityManagerFactory(UNIT_NAME);
        }
        return eMFactory;
    }

}
