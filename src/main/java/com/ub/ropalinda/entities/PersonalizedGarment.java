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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
@Entity
@Table(name = "personalized_garment")
@NamedQueries({
    @NamedQuery(name = "PersonalizedGarment.findAll", query = "SELECT p FROM PersonalizedGarment p")
    , @NamedQuery(name = "PersonalizedGarment.findById", query = "SELECT p FROM PersonalizedGarment p WHERE p.id = :id")
    , @NamedQuery(name = "PersonalizedGarment.findByActive", query = "SELECT p FROM PersonalizedGarment p WHERE p.active = :active")})
public class PersonalizedGarment extends IEntity<Integer> implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personalizedGarment")
    private List<PersonalizedGarmentCompatible> personalizedGarmentCompatibleList;
    @JsonIgnore
    @JoinColumn(name = "customer", referencedColumnName = "mail")
    @ManyToOne(optional = false)
    private Customer customer;
    @JoinColumn(name = "garment", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Garment garment;

    public PersonalizedGarment() {
    }

    public PersonalizedGarment(Integer id) {
        this.id = id;
    }

    public PersonalizedGarment(Integer id, boolean active) {
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

    public List<PersonalizedGarmentCompatible> getPersonalizedGarmentCompatibleList() {
        return personalizedGarmentCompatibleList;
    }

    public void setPersonalizedGarmentCompatibleList(List<PersonalizedGarmentCompatible> personalizedGarmentCompatibleList) {
        this.personalizedGarmentCompatibleList = personalizedGarmentCompatibleList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Garment getGarment() {
        return garment;
    }

    public void setGarment(Garment garment) {
        this.garment = garment;
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
        if (!(object instanceof PersonalizedGarment)) {
            return false;
        }
        PersonalizedGarment other = (PersonalizedGarment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ub.ropalinda.entities.PersonalizedGarment[ id=" + id + " ]";
    }

    @Override
    public Integer objectPK() {
        return id;
    }

}
