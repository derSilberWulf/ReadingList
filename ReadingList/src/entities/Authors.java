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
@Table(name = "authors")
@NamedQueries({
    @NamedQuery(name = "Authors.findAll", query = "SELECT a FROM Authors a"),
    @NamedQuery(name = "Authors.findById", query = "SELECT a FROM Authors a WHERE a.id = :id"),
    @NamedQuery(name = "Authors.findByLastName", query = "SELECT a FROM Authors a WHERE a.lastName = :lastName"),
    @NamedQuery(name = "Authors.findByFirstName", query = "SELECT a FROM Authors a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "Authors.findByNotes", query = "SELECT a FROM Authors a WHERE a.notes = :notes")})
public class Authors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "notes")
    private String notes;
    @OneToMany(mappedBy = "authorId")
    private Collection<LkAuthorsWorks> lkAuthorsWorksCollection;

    public Authors() {
    }

    public Authors(Integer id) {
        this.id = id;
    }

    public Authors(Integer id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Collection<LkAuthorsWorks> getLkAuthorsWorksCollection() {
        return lkAuthorsWorksCollection;
    }

    public void setLkAuthorsWorksCollection(Collection<LkAuthorsWorks> lkAuthorsWorksCollection) {
        this.lkAuthorsWorksCollection = lkAuthorsWorksCollection;
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
        if (!(object instanceof Authors)) {
            return false;
        }
        Authors other = (Authors) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Authors[ id=" + id + " ]";
    }
    
}
