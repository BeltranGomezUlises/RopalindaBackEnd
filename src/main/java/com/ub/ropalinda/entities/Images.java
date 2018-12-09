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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ub.ropalinda.utils.commons.IEntity;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
@Entity
@Table(name = "images")
@NamedQueries({
    @NamedQuery(name = "Images.findAll", query = "SELECT i FROM Images i")
    , @NamedQuery(name = "Images.findByGarment", query = "SELECT i FROM Images i WHERE i.imagesPK.garment = :garment")
    , @NamedQuery(name = "Images.findByImagePath", query = "SELECT i FROM Images i WHERE i.imagesPK.imagePath = :imagePath")
    , @NamedQuery(name = "Images.findByActive", query = "SELECT i FROM Images i WHERE i.active = :active")})
public class Images extends IEntity<ImagesPK> implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ImagesPK imagesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @JsonIgnore
    @JoinColumn(name = "garment", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Garment garment1;

    public Images() {
    }

    public Images(ImagesPK imagesPK) {
        this.imagesPK = imagesPK;
    }

    public Images(ImagesPK imagesPK, boolean active) {
        this.imagesPK = imagesPK;
        this.active = active;
    }

    public Images(int garment, String imagePath) {
        this.imagesPK = new ImagesPK(garment, imagePath);
    }

    public ImagesPK getImagesPK() {
        return imagesPK;
    }

    public void setImagesPK(ImagesPK imagesPK) {
        this.imagesPK = imagesPK;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Garment getGarment1() {
        return garment1;
    }

    public void setGarment1(Garment garment1) {
        this.garment1 = garment1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imagesPK != null ? imagesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Images)) {
            return false;
        }
        Images other = (Images) object;
        if ((this.imagesPK == null && other.imagesPK != null) || (this.imagesPK != null && !this.imagesPK.equals(other.imagesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ub.ropalinda.entities.Images[ imagesPK=" + imagesPK + " ]";
    }

    @Override
    public ImagesPK objectPK() {
        return this.imagesPK;
    }

}
