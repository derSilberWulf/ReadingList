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
@Table(name = "reading_sessions_series")
@NamedQueries({
    @NamedQuery(name = "ReadingSessionsSeries.findAll", query = "SELECT r FROM ReadingSessionsSeries r"),
    @NamedQuery(name = "ReadingSessionsSeries.findById", query = "SELECT r FROM ReadingSessionsSeries r WHERE r.id = :id"),
    @NamedQuery(name = "ReadingSessionsSeries.findByNotes", query = "SELECT r FROM ReadingSessionsSeries r WHERE r.notes = :notes"),
    @NamedQuery(name = "ReadingSessionsSeries.findByDateStarted", query = "SELECT r FROM ReadingSessionsSeries r WHERE r.dateStarted = :dateStarted"),
    @NamedQuery(name = "ReadingSessionsSeries.findByDateFinished", query = "SELECT r FROM ReadingSessionsSeries r WHERE r.dateFinished = :dateFinished"),
    @NamedQuery(name = "ReadingSessionsSeries.findByRating", query = "SELECT r FROM ReadingSessionsSeries r WHERE r.rating = :rating")})
public class ReadingSessionsSeries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "notes")
    private String notes;
    @Column(name = "date_started")
    private String dateStarted;
    @Column(name = "date_finished")
    private String dateFinished;
    @Column(name = "rating")
    private Integer rating;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private Users userId;
    @JoinColumn(name = "series_id", referencedColumnName = "id")
    @ManyToOne
    private Series seriesId;

    public ReadingSessionsSeries() {
    }

    public ReadingSessionsSeries(Integer id) {
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

    public String getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(String dateStarted) {
        this.dateStarted = dateStarted;
    }

    public String getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(String dateFinished) {
        this.dateFinished = dateFinished;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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
        if (!(object instanceof ReadingSessionsSeries)) {
            return false;
        }
        ReadingSessionsSeries other = (ReadingSessionsSeries) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ReadingSessionsSeries[ id=" + id + " ]";
    }
    
}
