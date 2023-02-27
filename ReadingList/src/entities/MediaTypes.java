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
@Table(name = "media_types")
@NamedQueries({
    @NamedQuery(name = "MediaTypes.findAll", query = "SELECT m FROM MediaTypes m"),
    @NamedQuery(name = "MediaTypes.findById", query = "SELECT m FROM MediaTypes m WHERE m.id = :id"),
    @NamedQuery(name = "MediaTypes.findByName", query = "SELECT m FROM MediaTypes m WHERE m.name = :name"),
    @NamedQuery(name = "MediaTypes.findByDescription", query = "SELECT m FROM MediaTypes m WHERE m.description = :description")})
public class MediaTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "mediaTypeId")
    private Collection<Works> worksCollection;

    public MediaTypes() {
    }

    public MediaTypes(Integer id) {
        this.id = id;
    }

    public MediaTypes(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Works> getWorksCollection() {
        return worksCollection;
    }

    public void setWorksCollection(Collection<Works> worksCollection) {
        this.worksCollection = worksCollection;
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
        if (!(object instanceof MediaTypes)) {
            return false;
        }
        MediaTypes other = (MediaTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MediaTypes[ id=" + id + " ]";
    }
    
}
