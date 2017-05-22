/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.iti.shareit.model.entity;

import eg.iti.shareit.common.entity.GenericEntity;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "T_STATE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TStateEntity.findAll", query = "SELECT t FROM TStateEntity t"),
    @NamedQuery(name = "TStateEntity.findById", query = "SELECT t FROM TStateEntity t WHERE t.id = :id"),
    @NamedQuery(name = "TStateEntity.findByState", query = "SELECT t FROM TStateEntity t WHERE t.state = :state")})
public class TStateEntity implements Serializable, GenericEntity {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "STATE")
    private String state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "state")
    private Collection<TAddressEntity> tAddressEntityCollection;

    public TStateEntity() {
    }

    public TStateEntity(BigDecimal id) {
        this.id = id;
    }

    public TStateEntity(BigDecimal id, String state) {
        this.id = id;
        this.state = state;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<TAddressEntity> getTAddressEntityCollection() {
        return tAddressEntityCollection;
    }

    public void setTAddressEntityCollection(Collection<TAddressEntity> tAddressEntityCollection) {
        this.tAddressEntityCollection = tAddressEntityCollection;
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
        if (!(object instanceof TStateEntity)) {
            return false;
        }
        TStateEntity other = (TStateEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eg.iti.shareit.model.entity.TStateEntity[ id=" + id + " ]";
    }

}
