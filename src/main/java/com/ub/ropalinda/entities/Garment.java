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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ub.ropalinda.utils.commons.IEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
@Entity
@Table(name = "garment")
@NamedQueries({
    @NamedQuery(name = "Garment.findAll", query = "SELECT g FROM Garment g")
    , @NamedQuery(name = "Garment.findById", query = "SELECT g FROM Garment g WHERE g.id = :id")
    , @NamedQuery(name = "Garment.findByName", query = "SELECT g FROM Garment g WHERE g.name = :name")
    , @NamedQuery(name = "Garment.findByDescription", query = "SELECT g FROM Garment g WHERE g.description = :description")
    , @NamedQuery(name = "Garment.findByPreviewImage", query = "SELECT g FROM Garment g WHERE g.previewImage = :previewImage")
    , @NamedQuery(name = "Garment.findByImage", query = "SELECT g FROM Garment g WHERE g.image = :image")
    , @NamedQuery(name = "Garment.findByActive", query = "SELECT g FROM Garment g WHERE g.active = :active")
    , @NamedQuery(name = "Garment.findByPrice", query = "SELECT g FROM Garment g WHERE g.price = :price")})
public class Garment extends IEntity<Integer> implements Serializable {
    
    @JoinColumn(name = "subcategory", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Subcategory subcategory;

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
    @Max(value = 99999)
    @Min(value = 0)
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @ManyToMany(mappedBy = "garmentList")
    private List<CompatibleGarment> compatibleGarmentList;

    public Garment() {
    }

    public Garment(Integer id) {
        this.id = id;
    }

    public Garment(Integer id, String name, String description, String previewImage, String image, boolean active, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.previewImage = previewImage;
        this.image = image;
        this.active = active;
        this.price = price;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<CompatibleGarment> getCompatibleGarmentList() {
        return compatibleGarmentList;
    }

    public void setCompatibleGarmentList(List<CompatibleGarment> compatibleGarmentList) {
        this.compatibleGarmentList = compatibleGarmentList;
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
        if (!(object instanceof Garment)) {
            return false;
        }
        Garment other = (Garment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ub.ropalinda.entities.Garment[ id=" + id + " ]";
    }

    @Override
    public Integer objectPK() {
        return id;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

}