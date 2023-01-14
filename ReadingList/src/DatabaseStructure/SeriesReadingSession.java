/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseStructure;

import java.sql.Timestamp;

/**
 *
 * @author yahna
 */
public class SeriesReadingSession extends SQLTable{
    public int id;
    public int series_id;
    public int user_id;
    public String notes;
    public Timestamp date_started;
    public Timestamp date_finished;
    public int rating;
}
