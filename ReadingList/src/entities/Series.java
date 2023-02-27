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
@Table(name = "series")
@NamedQueries({
    @NamedQuery(name = "Series.findAll", query = "SELECT s FROM Series s"),
    @NamedQuery(name = "Series.findById", query = "SELECT s FROM Series s WHERE s.id = :id"),
    @NamedQuery(name = "Series.findByTitle", query = "SELECT s FROM Series s WHERE s.title = :title"),
    @NamedQuery(name = "Series.findByDescription", query = "SELECT s FROM Series s WHERE s.description = :description"),
    @NamedQuery(name = "Series.findByOngoing", query = "SELECT s FROM Series s WHERE s.ongoing = :ongoing")})
public class Series implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "ongoing")
    private Integer ongoing;
    @OneToMany(mappedBy = "seriesId")
    private Collection<LkSeriesFranchises> lkSeriesFranchisesCollection;
    @OneToMany(mappedBy = "seriesId")
    private Collection<LkSeriesWorks> lkSeriesWorksCollection;
    @OneToMany(mappedBy = "seriesId")
    private Collection<ReadingSessionsSeries> readingSessionsSeriesCollection;

    public Series() {
    }

    public Series(Integer id) {
        this.id = id;
    }

    public Series(Integer id, String title) {
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

    public Integer getOngoing() {
        return ongoing;
    }

    public void setOngoing(Integer ongoing) {
        this.ongoing = ongoing;
    }

    public Collection<LkSeriesFranchises> getLkSeriesFranchisesCollection() {
        return lkSeriesFranchisesCollection;
    }

    public void setLkSeriesFranchisesCollection(Collection<LkSeriesFranchises> lkSeriesFranchisesCollection) {
        this.lkSeriesFranchisesCollection = lkSeriesFranchisesCollection;
    }

    public Collection<LkSeriesWorks> getLkSeriesWorksCollection() {
        return lkSeriesWorksCollection;
    }

    public void setLkSeriesWorksCollection(Collection<LkSeriesWorks> lkSeriesWorksCollection) {
        this.lkSeriesWorksCollection = lkSeriesWorksCollection;
    }

    public Collection<ReadingSessionsSeries> getReadingSessionsSeriesCollection() {
        return readingSessionsSeriesCollection;
    }

    public void setReadingSessionsSeriesCollection(Collection<ReadingSessionsSeries> readingSessionsSeriesCollection) {
        this.readingSessionsSeriesCollection = readingSessionsSeriesCollection;
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
        if (!(object instanceof Series)) {
            return false;
        }
        Series other = (Series) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Series[ id=" + id + " ]";
    }
    
}
