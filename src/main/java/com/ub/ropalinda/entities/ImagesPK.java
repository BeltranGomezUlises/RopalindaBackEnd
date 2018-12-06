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
package com.ub.ropalinda.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
@Embeddable
public class ImagesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "garment")
    private int garment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "image_path")
    private String imagePath;

    public ImagesPK() {
    }

    public ImagesPK(int garment, String imagePath) {
        this.garment = garment;
        this.imagePath = imagePath;
    }

    public int getGarment() {
        return garment;
    }

    public void setGarment(int garment) {
        this.garment = garment;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) garment;
        hash += (imagePath != null ? imagePath.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImagesPK)) {
            return false;
        }
        ImagesPK other = (ImagesPK) object;
        if (this.garment != other.garment) {
            return false;
        }
        if ((this.imagePath == null && other.imagePath != null) || (this.imagePath != null && !this.imagePath.equals(other.imagePath))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ub.ropalinda.entities.ImagesPK[ garment=" + garment + ", imagePath=" + imagePath + " ]";
    }
    
}
