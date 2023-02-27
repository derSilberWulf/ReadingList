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
@Table(name = "lk_series_works")
@NamedQueries({
    @NamedQuery(name = "LkSeriesWorks.findAll", query = "SELECT l FROM LkSeriesWorks l"),
    @NamedQuery(name = "LkSeriesWorks.findById", query = "SELECT l FROM LkSeriesWorks l WHERE l.id = :id")})
public class LkSeriesWorks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "work_id", referencedColumnName = "id")
    @ManyToOne
    private Works workId;
    @JoinColumn(name = "series_id", referencedColumnName = "id")
    @ManyToOne
    private Series seriesId;

    public LkSeriesWorks() {
    }

    public LkSeriesWorks(Integer id) {
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

    public Series getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Series seriesId) {
        this.seriesId = seriesId;
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
        if (!(object instanceof LkSeriesWorks)) {
            return false;
        }
        LkSeriesWorks other = (LkSeriesWorks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LkSeriesWorks[ id=" + id + " ]";
    }
    
}
