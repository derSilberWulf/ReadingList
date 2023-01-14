/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseStructure;

/**
 *
 * @author yahna
 */
public class Tag extends SQLTable{
    public Tag(){};
    public Tag(int id, String name, String description){
        this.id = id; this.name = name; this.description = description;
    }
    public int id;
    public String name;
    public String description;

    /**
     * representation is just the name
     * @return
     */
    @Override
    public String toString(){
        return name;
    }
}
