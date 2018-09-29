package com.ub.ropalinda.entities;

import com.ub.ropalinda.utils.commons.IEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "prospective_customer")
public class ProspectiveCustomer extends IEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "mail")
    private String mail;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;

    public ProspectiveCustomer() {
    }

    public ProspectiveCustomer(String mail) {
        this.mail = mail;
    }

    public ProspectiveCustomer(String mail, String name, String fatherLastName, String motherLastName, String phone) {
        this.mail = mail;
        this.name = name;
        this.fatherLastName = fatherLastName;
        this.motherLastName = motherLastName;
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProspectiveCustomer)) {
            return false;
        }
        ProspectiveCustomer other = (ProspectiveCustomer) object;
        return this.mail.equals(other.mail);
    }

    @Override
    public String toString() {
        return "ProspectiveCustomer{" + "mail=" + mail + ", name=" + name
                + ", fatherLastName=" + fatherLastName + ", motherLastName="
                + motherLastName + ", phone=" + phone + ", birthday=" + birthday + '}';
    }

    @Override
    public String objectPK() {
        return this.mail;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean getActive() {
        return active;
    }

}
