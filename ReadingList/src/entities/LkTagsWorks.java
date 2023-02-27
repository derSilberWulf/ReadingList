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
@Table(name = "lk_tags_works")
@NamedQueries({
    @NamedQuery(name = "LkTagsWorks.findAll", query = "SELECT l FROM LkTagsWorks l"),
    @NamedQuery(name = "LkTagsWorks.findById", query = "SELECT l FROM LkTagsWorks l WHERE l.id = :id")})
public class LkTagsWorks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "work_id", referencedColumnName = "id")
    @ManyToOne
    private Works workId;
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    @ManyToOne
    private Tags tagId;

    public LkTagsWorks() {
    }

    public LkTagsWorks(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Works getWorkId() {
        return workId;
    }

    public void setWorkId(Works workId) {
        this.workId = workId;
    }

    public Tags getTagId() {
        return tagId;
    }

    public void setTagId(Tags tagId) {
        this.tagId = tagId;
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
        if (!(object instanceof LkTagsWorks)) {
            return false;
        }
        LkTagsWorks other = (LkTagsWorks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LkTagsWorks[ id=" + id + " ]";
    }
    
}
