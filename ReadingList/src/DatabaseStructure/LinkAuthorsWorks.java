/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseStructure;

/**
 *
 * @author yahna
 */
public class LinkAuthorsWorks extends SQLTable{
    int id;
    int author_id;
    int work_id;
    int role_id;
    String notes;
}
