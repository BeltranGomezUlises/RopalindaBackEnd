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
import java.math.BigDecimal;
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

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
@Entity
@Table(name = "conf")
@NamedQueries({
    @NamedQuery(name = "Conf.findAll", query = "SELECT c FROM Conf c")
    , @NamedQuery(name = "Conf.findByMaxGarmentPerLine", query = "SELECT c FROM Conf c WHERE c.maxGarmentPerLine = :maxGarmentPerLine")
    , @NamedQuery(name = "Conf.findByMaxAmountPerPurchase", query = "SELECT c FROM Conf c WHERE c.maxAmountPerPurchase = :maxAmountPerPurchase")
    , @NamedQuery(name = "Conf.findById", query = "SELECT c FROM Conf c WHERE c.id = :id")})
public class Conf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_garment_per_line")
    private int maxGarmentPerLine;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_amount_per_purchase")
    private BigDecimal maxAmountPerPurchase;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Conf() {
    }

    public Conf(Integer id) {
        this.id = id;
    }

    public Conf(Integer id, int maxGarmentPerLine, BigDecimal maxAmountPerPurchase) {
        this.id = id;
        this.maxGarmentPerLine = maxGarmentPerLine;
        this.maxAmountPerPurchase = maxAmountPerPurchase;
    }

    public int getMaxGarmentPerLine() {
        return maxGarmentPerLine;
    }

    public void setMaxGarmentPerLine(int maxGarmentPerLine) {
        this.maxGarmentPerLine = maxGarmentPerLine;
    }

    public BigDecimal getMaxAmountPerPurchase() {
        return maxAmountPerPurchase;
    }

    public void setMaxAmountPerPurchase(BigDecimal maxAmountPerPurchase) {
        this.maxAmountPerPurchase = maxAmountPerPurchase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Conf)) {
            return false;
        }
        Conf other = (Conf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ub.ropalinda.entities.Conf[ id=" + id + " ]";
    }
    
}
