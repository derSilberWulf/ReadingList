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
@Table(name = "reading_sessions")
@NamedQueries({
    @NamedQuery(name = "ReadingSessions.findAll", query = "SELECT r FROM ReadingSessions r"),
    @NamedQuery(name = "ReadingSessions.findById", query = "SELECT r FROM ReadingSessions r WHERE r.id = :id"),
    @NamedQuery(name = "ReadingSessions.findByNotes", query = "SELECT r FROM ReadingSessions r WHERE r.notes = :notes"),
    @NamedQuery(name = "ReadingSessions.findByDateStarted", query = "SELECT r FROM ReadingSessions r WHERE r.dateStarted = :dateStarted"),
    @NamedQuery(name = "ReadingSessions.findByDateFinished", query = "SELECT r FROM ReadingSessions r WHERE r.dateFinished = :dateFinished"),
    @NamedQuery(name = "ReadingSessions.findByRating", query = "SELECT r FROM ReadingSessions r WHERE r.rating = :rating")})
public class ReadingSessions implements Serializable {

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
    @JoinColumn(name = "work_id", referencedColumnName = "id")
    @ManyToOne
    private Works workId;

    public ReadingSessions() {
    }

    public ReadingSessions(Integer id) {
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

    public Works getWorkId() {
        return workId;
    }

    public void setWorkId(Works workId) {
        this.workId = workId;
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
        if (!(object instanceof ReadingSessions)) {
            return false;
        }
        ReadingSessions other = (ReadingSessions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ReadingSessions[ id=" + id + " ]";
    }
    
}
