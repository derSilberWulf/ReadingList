/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseStructure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author yahna
 */
public class ReadingSession extends SQLTable{
    int id;
    int work_id;
    int user_id;
    int notes;
    Timestamp date_started;
    Timestamp date_finished;
    int rating;
}
