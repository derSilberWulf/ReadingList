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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author yahna
 */
@Entity
@Table(name = "works")
@NamedQueries({
    @NamedQuery(name = "Works.findAll", query = "SELECT w FROM Works w"),
    @NamedQuery(name = "Works.findById", query = "SELECT w FROM Works w WHERE w.id = :id"),
    @NamedQuery(name = "Works.findByTitle", query = "SELECT w FROM Works w WHERE w.title = :title"),
    @NamedQuery(name = "Works.findBySubtitle", query = "SELECT w FROM Works w WHERE w.subtitle = :subtitle"),
    @NamedQuery(name = "Works.findByVolume", query = "SELECT w FROM Works w WHERE w.volume = :volume"),
    @NamedQuery(name = "Works.findBySummary", query = "SELECT w FROM Works w WHERE w.summary = :summary"),
    @NamedQuery(name = "Works.findByNotes", query = "SELECT w FROM Works w WHERE w.notes = :notes"),
    @NamedQuery(name = "Works.findByOwnCopy", query = "SELECT w FROM Works w WHERE w.ownCopy = :ownCopy")})
public class Works implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "subtitle")
    private String subtitle;
    @Column(name = "volume")
    private Integer volume;
    @Column(name = "summary")
    private String summary;
    @Column(name = "notes")
    private String notes;
    @Column(name = "own_copy")
    private Integer ownCopy;
    @OneToMany(mappedBy = "workId")
    private Collection<ReadingSessions> readingSessionsCollection;
    @OneToMany(mappedBy = "workId")
    private Collection<LkTagsWorks> lkTagsWorksCollection;
    @JoinColumn(name = "media_type_id", referencedColumnName = "id")
    @ManyToOne
    private MediaTypes mediaTypeId;
    @OneToMany(mappedBy = "workId")
    private Collection<LkSeriesWorks> lkSeriesWorksCollection;
    @OneToMany(mappedBy = "workId")
    private Collection<LkPublishersWorks> lkPublishersWorksCollection;
    @OneToMany(mappedBy = "workId")
    private Collection<LkAuthorsWorks> lkAuthorsWorksCollection;

    public Works() {
    }

    public Works(Integer id) {
        this.id = id;
    }

    public Works(Integer id, String title) {
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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getOwnCopy() {
        return ownCopy;
    }

    public void setOwnCopy(Integer ownCopy) {
        this.ownCopy = ownCopy;
    }

    public Collection<ReadingSessions> getReadingSessionsCollection() {
        return readingSessionsCollection;
    }

    public void setReadingSessionsCollection(Collection<ReadingSessions> readingSessionsCollection) {
        this.readingSessionsCollection = readingSessionsCollection;
    }

    public Collection<LkTagsWorks> getLkTagsWorksCollection() {
        return lkTagsWorksCollection;
    }

    public void setLkTagsWorksCollection(Collection<LkTagsWorks> lkTagsWorksCollection) {
        this.lkTagsWorksCollection = lkTagsWorksCollection;
    }

    public MediaTypes getMediaTypeId() {
        return mediaTypeId;
    }

    public void setMediaTypeId(MediaTypes mediaTypeId) {
        this.mediaTypeId = mediaTypeId;
    }

    public Collection<LkSeriesWorks> getLkSeriesWorksCollection() {
        return lkSeriesWorksCollection;
    }

    public void setLkSeriesWorksCollection(Collection<LkSeriesWorks> lkSeriesWorksCollection) {
        this.lkSeriesWorksCollection = lkSeriesWorksCollection;
    }

    public Collection<LkPublishersWorks> getLkPublishersWorksCollection() {
        return lkPublishersWorksCollection;
    }

    public void setLkPublishersWorksCollection(Collection<LkPublishersWorks> lkPublishersWorksCollection) {
        this.lkPublishersWorksCollection = lkPublishersWorksCollection;
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
        if (!(object instanceof Works)) {
            return false;
        }
        Works other = (Works) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Works[ id=" + id + " ]";
    }
    
}
