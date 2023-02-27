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
@Table(name = "lk_publishers_works")
@NamedQueries({
    @NamedQuery(name = "LkPublishersWorks.findAll", query = "SELECT l FROM LkPublishersWorks l"),
    @NamedQuery(name = "LkPublishersWorks.findById", query = "SELECT l FROM LkPublishersWorks l WHERE l.id = :id")})
public class LkPublishersWorks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "work_id", referencedColumnName = "id")
    @ManyToOne
    private Works workId;
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    @ManyToOne
    private Publishers publisherId;

    public LkPublishersWorks() {
    }

    public LkPublishersWorks(Integer id) {
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

    public Publishers getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publishers publisherId) {
        this.publisherId = publisherId;
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
        if (!(object instanceof LkPublishersWorks)) {
            return false;
        }
        LkPublishersWorks other = (LkPublishersWorks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LkPublishersWorks[ id=" + id + " ]";
    }
    
}
