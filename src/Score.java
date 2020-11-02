
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo
 */
public class Score {
     public static void insertUpdateDeleteStudent(char operation,Integer sid,Integer cid, Double  score, String remarks ){
        Connection con=MyConnection.getConnection();
        if(operation=='i'){ 
           try {
            PreparedStatement stmt=con.prepareStatement("INSERT INTO score(student_id,course_id,student_score,description) VALUES (?,?,?,?)");
            stmt.setInt(1,sid);
            stmt.setInt(2,cid);
            stmt.setDouble(3,score);
            stmt.setString(4, remarks);
           
            if(stmt.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Score inserted");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not Inserted");
            
        }
       }
        if(operation=='u'){
             try {
            PreparedStatement stmt=con.prepareStatement("UPDATE `score` SET `student_score`=?,`description`=? WHERE `student_id`=? and `course_id`=?");
            stmt.setDouble(1,score);
            stmt.setString(2,remarks);
            stmt.setInt(3,sid);
            stmt.setInt(4,cid);
            if(stmt.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Score Updated");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not Updated");
        }
            
            
        }
        if(operation=='r'){
             try {
            PreparedStatement stmt=con.prepareStatement("DELETE FROM `score` WHERE student_id=?");
           
            stmt.setInt(1,sid );
            if(stmt.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Score Removed");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not Removed");
        }
            
            
        }
    }
     public void jtableFilledStudent(JTable table,String toSearch){
        Connection con=MyConnection.getConnection();
        try {
            PreparedStatement stmt=con.prepareStatement("SELECT * FROM score where concat(student_id,course_id,student_score,description) LIKE ? ");
            stmt.setString(1,"%"+toSearch+"%");
            ResultSet rs=stmt.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            Object row[];
            while(rs.next()){
                row =new Object[4];
                row[0]=rs.getString(1);
                row[1]=rs.getString(2);
                row[2]=rs.getString(3);
                row[3]=rs.getString(4);
                
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not Inserted");
        }


    }
    
     public void jtableFilledStudent1(JTable table){
        Connection con=MyConnection.getConnection();
        try {
            PreparedStatement stmt=con.prepareStatement("SELECT student.first_name, student.last_name, score.course_id, score.student_score FROM student INNER JOIN score ON student.id=score.student_id; ");
            //stmt.setString(1,"%"+toSearch+"%");
            ResultSet rs=stmt.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            Object row[];
            while(rs.next()){
                row =new Object[4];
                row[0]=rs.getString(1);
                row[1]=rs.getString(2);
                row[2]=rs.getString(3);
                row[3]=rs.getString(4);
                
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not Inserted");
        }


    }
}
