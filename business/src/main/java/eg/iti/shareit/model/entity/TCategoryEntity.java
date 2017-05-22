/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.iti.shareit.model.entity;

import eg.iti.shareit.common.entity.GenericEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adel Zaid
 */
@Entity
@Table(name = "T_CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCategoryEntity.findAll", query = "SELECT t FROM TCategoryEntity t"),
    @NamedQuery(name = "TCategoryEntity.findById", query = "SELECT t FROM TCategoryEntity t WHERE t.id = :id"),
    @NamedQuery(name = "TCategoryEntity.findByName", query = "SELECT t FROM TCategoryEntity t WHERE t.name = :name"),
    @NamedQuery(name = "TCategoryEntity.findByMaxPoints", query = "SELECT t FROM TCategoryEntity t WHERE t.maxPoints = :maxPoints")})
public class TCategoryEntity implements Serializable, GenericEntity {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MAX_POINTS")
    private BigInteger maxPoints;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Collection<TItemEntity> tItemEntityCollection;

    public TCategoryEntity() {
    }

    public TCategoryEntity(BigDecimal id) {
        this.id = id;
    }

    public TCategoryEntity(BigDecimal id, String name, BigInteger maxPoints) {
        this.id = id;
        this.name = name;
        this.maxPoints = maxPoints;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(BigInteger maxPoints) {
        this.maxPoints = maxPoints;
    }

    @XmlTransient
    public Collection<TItemEntity> getTItemEntityCollection() {
        return tItemEntityCollection;
    }

    public void setTItemEntityCollection(Collection<TItemEntity> tItemEntityCollection) {
        this.tItemEntityCollection = tItemEntityCollection;
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
        if (!(object instanceof TCategoryEntity)) {
            return false;
        }
        TCategoryEntity other = (TCategoryEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eg.iti.shareit.model.entity.TCategoryEntity[ id=" + id + " ]";
    }

}
