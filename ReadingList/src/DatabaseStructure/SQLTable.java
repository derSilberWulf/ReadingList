/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseStructure;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yahna
 */
public abstract class SQLTable {    
    /**
     * Read in one object in a ResultSet
     * @param rs 
     */
    public void setVariables(ResultSet rs){
        //SQLTable.class.arrayType()
        Field fields[] = this.getFields();
        for (Field field : fields) {
            String f_name = field.getName();
            Class f_type = field.getType();
            try {
                if(f_type.equals(int.class)){
                    int value = rs.getInt(f_name);
                    field.setInt(this, value);
                }
                else if(f_type.equals(String.class)){
                    String value = rs.getString(f_name);
                    field.set(this, value);
                }
                else if(f_type.equals(boolean.class)){
                    boolean value = rs.getBoolean(f_name);
                    field.set(this, value);
                }
                else if(f_type.equals(Timestamp.class)){
                    Timestamp value = rs.getTimestamp(f_name);
                    field.set(this, value);
                }
                else if(f_type.equals(SQLTable.class)){
                    //linking table, so what to do here?
                    //I don't think it would be advisable to try to get it ourselves
                    //also don't know if linking tables will just store the id
                }
            } catch (SQLException | IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(SQLTable.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    /**
     * 
     * @return 
     */
    public Field[] getFields(){
        return this.getClass().getFields();
    }
}
