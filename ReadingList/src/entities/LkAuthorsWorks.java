/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author yahna
 */
@Entity
@Table(name = "lk_authors_works")
@NamedQueries({
    @NamedQuery(name = "LkAuthorsWorks.findAll", query = "SELECT l FROM LkAuthorsWorks l"),
    @NamedQuery(name = "LkAuthorsWorks.findById", query = "SELECT l FROM LkAuthorsWorks l WHERE l.id = :id"),
    @NamedQuery(name = "LkAuthorsWorks.findByNotes", query = "SELECT l FROM LkAuthorsWorks l WHERE l.notes = :notes")})
public class LkAuthorsWorks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "notes")
    private String notes;
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne
    private Roles roleId;
    @JoinColumn(name = "work_id", referencedColumnName = "id")
    @ManyToOne
    private Works workId;
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @ManyToOne
    private Authors authorId;

    public LkAuthorsWorks() {
    }

    public LkAuthorsWorks(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Roles getRoleId() {
        return roleId;
    }

    public void setRoleId(Roles roleId) {
        this.roleId = roleId;
    }

    public Works getWorkId() {
        return workId;
    }

    public void setWorkId(Works workId) {
        this.workId = workId;
    }

    public Authors getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Authors authorId) {
        this.authorId = authorId;
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
        if (!(object instanceof LkAuthorsWorks)) {
            return false;
        }
        LkAuthorsWorks other = (LkAuthorsWorks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LkAuthorsWorks[ id=" + id + " ]";
    }
    
}
