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
import java.math.BigDecimal;
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
@Table(name = "order_detail_compatible")
@NamedQueries({
    @NamedQuery(name = "OrderDetailCompatible.findAll", query = "SELECT o FROM OrderDetailCompatible o")
    , @NamedQuery(name = "OrderDetailCompatible.findById", query = "SELECT o FROM OrderDetailCompatible o WHERE o.id = :id")
    , @NamedQuery(name = "OrderDetailCompatible.findByPrice", query = "SELECT o FROM OrderDetailCompatible o WHERE o.price = :price")
    , @NamedQuery(name = "OrderDetailCompatible.findByActive", query = "SELECT o FROM OrderDetailCompatible o WHERE o.active = :active")})
public class OrderDetailCompatible extends IEntity<Integer> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;    
    @JoinColumn(name = "compatible_garment", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CompatibleGarment compatibleGarment;
    @JsonIgnore
    @JoinColumn(name = "order_detail", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrderDetail orderDetail;

    public OrderDetailCompatible() {
    }

    public OrderDetailCompatible(Integer id) {
        this.id = id;
    }

    public OrderDetailCompatible(Integer id, BigDecimal price, boolean active) {
        this.id = id;
        this.price = price;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
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
        if (!(object instanceof OrderDetailCompatible)) {
            return false;
        }
        OrderDetailCompatible other = (OrderDetailCompatible) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ub.ropalinda.entities.OrderDetailCompatible[ id=" + id + " ]";
    }

    @Override
    public Integer objectPK() {
        return id;
    }
    
}
