/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.ropalinda.entities;

import com.ub.ropalinda.utils.commons.IEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ulises
 */
@Entity
@Table(name = "customer")
public class Customer extends IEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "pass")
    private String pass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "father_last_name")
    private String fatherLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "mother_last_name")
    private String motherLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "phone")
    private String phone;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "payment_method_allowed")
    private PaymentMethod paymentMethodAllowed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;

    public Customer() {
    }

    public Customer(String mail) {
        this.mail = mail;
    }

    public Customer(PaymentMethod paymentMethodAllowed, String mail, String pass, String name, String fatherLastName, String motherLastName, String phone, Date birthday, boolean active) {
        this.paymentMethodAllowed = paymentMethodAllowed;
        this.mail = mail;
        this.pass = pass;
        this.name = name;
        this.fatherLastName = fatherLastName;
        this.motherLastName = motherLastName;
        this.phone = phone;
        this.birthday = birthday;
        this.active = active;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherLastName() {
        return fatherLastName;
    }

    public void setFatherLastName(String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mail != null ? mail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        return this.mail.equals(other.mail);
    }

    @Override
    public String toString() {
        return "com.ub.ropalinda.entities.Customer[ mail=" + mail + " ]";
    }

    @Override
    public String objectPK() {
        return this.mail;
    }

    @Override
    public boolean getActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    public PaymentMethod getPaymentMethodAllowed() {
        return paymentMethodAllowed;
    }

    public void setPaymentMethodAllowed(PaymentMethod paymentMethodAllowed) {
        this.paymentMethodAllowed = paymentMethodAllowed;
    }

    /**
     * especifie payment method for the customer
     */
    public static enum PaymentMethod {
        /**
         * only debit payments
         */
        DEBIT,
        /**
         * only credit payment
         */
        CREDIT,
        /**
         * both types of payments
         */
        BOTH
    }

}
