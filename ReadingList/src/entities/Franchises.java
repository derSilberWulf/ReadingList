/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author yahna
 */
@Entity
@Table(name = "franchises")
@NamedQueries({
    @NamedQuery(name = "Franchises.findAll", query = "SELECT f FROM Franchises f"),
    @NamedQuery(name = "Franchises.findById", query = "SELECT f FROM Franchises f WHERE f.id = :id"),
    @NamedQuery(name = "Franchises.findByTitle", query = "SELECT f FROM Franchises f WHERE f.title = :title"),
    @NamedQuery(name = "Franchises.findByDescription", query = "SELECT f FROM Franchises f WHERE f.description = :description")})
public class Franchises implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "franchiseId")
    private Collection<LkSeriesFranchises> lkSeriesFranchisesCollection;

    public Franchises() {
    }

    public Franchises(Integer id) {
        this.id = id;
    }

    public Franchises(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<LkSeriesFranchises> getLkSeriesFranchisesCollection() {
        return lkSeriesFranchisesCollection;
    }

    public void setLkSeriesFranchisesCollection(Collection<LkSeriesFranchises> lkSeriesFranchisesCollection) {
        this.lkSeriesFranchisesCollection = lkSeriesFranchisesCollection;
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
        if (!(object instanceof Franchises)) {
            return false;
        }
        Franchises other = (Franchises) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Franchises[ id=" + id + " ]";
    }
    
}
