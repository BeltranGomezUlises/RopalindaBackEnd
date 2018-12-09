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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "personalized_garment_compatible")
@NamedQueries({
    @NamedQuery(name = "PersonalizedGarmentCompatible.findAll", query = "SELECT p FROM PersonalizedGarmentCompatible p")
    , @NamedQuery(name = "PersonalizedGarmentCompatible.findById", query = "SELECT p FROM PersonalizedGarmentCompatible p WHERE p.id = :id")
    , @NamedQuery(name = "PersonalizedGarmentCompatible.findByActive", query = "SELECT p FROM PersonalizedGarmentCompatible p WHERE p.active = :active")})
public class PersonalizedGarmentCompatible implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @JoinColumn(name = "compatible_garment", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CompatibleGarment compatibleGarment;
    @JoinColumn(name = "personalized_garment", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PersonalizedGarment personalizedGarment;

    public PersonalizedGarmentCompatible() {
    }

    public PersonalizedGarmentCompatible(Integer id) {
        this.id = id;
    }

    public PersonalizedGarmentCompatible(Integer id, boolean active) {
        this.id = id;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CompatibleGarment getCompatibleGarment() {
        return compatibleGarment;
    }

    public void setCompatibleGarment(CompatibleGarment compatibleGarment) {
        this.compatibleGarment = compatibleGarment;
    }

    public PersonalizedGarment getPersonalizedGarment() {
        return personalizedGarment;
    }

    public void setPersonalizedGarment(PersonalizedGarment personalizedGarment) {
        this.personalizedGarment = personalizedGarment;
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
        if (!(object instanceof PersonalizedGarmentCompatible)) {
            return false;
        }
        PersonalizedGarmentCompatible other = (PersonalizedGarmentCompatible) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ub.ropalinda.entities.PersonalizedGarmentCompatible[ id=" + id + " ]";
    }

}
