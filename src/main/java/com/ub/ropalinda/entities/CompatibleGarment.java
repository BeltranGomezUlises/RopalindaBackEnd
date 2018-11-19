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

import com.ub.ropalinda.utils.commons.IEntity;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
@Entity
@Table(name = "compatible_garment")
@NamedQueries({
    @NamedQuery(name = "CompatibleGarment.findAll", query = "SELECT c FROM CompatibleGarment c")
    , @NamedQuery(name = "CompatibleGarment.findById", query = "SELECT c FROM CompatibleGarment c WHERE c.id = :id")
    , @NamedQuery(name = "CompatibleGarment.findByName", query = "SELECT c FROM CompatibleGarment c WHERE c.name = :name")
    , @NamedQuery(name = "CompatibleGarment.findByDescription", query = "SELECT c FROM CompatibleGarment c WHERE c.description = :description")
    , @NamedQuery(name = "CompatibleGarment.findByPreviewImage", query = "SELECT c FROM CompatibleGarment c WHERE c.previewImage = :previewImage")
    , @NamedQuery(name = "CompatibleGarment.findByImage", query = "SELECT c FROM CompatibleGarment c WHERE c.image = :image")
    , @NamedQuery(name = "CompatibleGarment.findByActive", query = "SELECT c FROM CompatibleGarment c WHERE c.active = :active")})
public class CompatibleGarment extends IEntity<Integer> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "preview_image")
    private String previewImage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;

    public CompatibleGarment() {
    }

    public CompatibleGarment(Integer id) {
        this.id = id;
    }

    public CompatibleGarment(Integer id, String name, String description, String previewImage, String image, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.previewImage = previewImage;
        this.image = image;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompatibleGarment)) {
            return false;
        }
        CompatibleGarment other = (CompatibleGarment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ub.ropalinda.entities.CompatibleGarment[ id=" + id + " ]";
    }

    @Override
    public Integer objectPK() {
        return id;
    }
    
}
