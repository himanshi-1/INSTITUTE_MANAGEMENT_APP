
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
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
public class Course {
    public static void insertUpdateDeleteStudent(char operation,Integer id,String label,Integer hours_no){
        Connection con=MyConnection.getConnection();
        if(operation=='i'){ 
           try {
            PreparedStatement stmt=con.prepareStatement("INSERT INTO course(label,hours_no) VALUES (?,?)");
            stmt.setString(1,label);
            stmt.setInt(2,hours_no);
           
            if(stmt.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"New Course Added");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not Inserted");
            
        }
       }
        if(operation=='u'){
             try {
            PreparedStatement stmt=con.prepareStatement("UPDATE `course` SET `label`=?,`hours_no`=? WHERE `id`=?");
            stmt.setString(1,label );
            stmt.setInt(2,hours_no );
            
            stmt.setInt(3,id );
            if(stmt.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Course Updated");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not Inserted");
        }
            
            
        }
        if(operation=='r'){
             try {
            PreparedStatement stmt=con.prepareStatement("DELETE FROM `course` WHERE id=?");
           
            stmt.setInt(1,id );
            if(stmt.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Course Removed");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not Removed");
        }
            
            
        }
    }

     public void jtableFilledStudent(JTable table,String toSearch){
        Connection con=MyConnection.getConnection();
        try {
            PreparedStatement stmt=con.prepareStatement("SELECT * FROM course where concat(id,label,hours_no) LIKE ? ");
            stmt.setString(1,"%"+toSearch+"%");
            ResultSet rs=stmt.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            Object row[];
            while(rs.next()){
                row =new Object[3];
                row[0]=rs.getString(1);
                row[1]=rs.getString(2);
                row[2]=rs.getString(3);
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not Inserted");
        }


    }
      public void jCourseCombo(JComboBox combobox){
        Connection con=MyConnection.getConnection();
        try {
            PreparedStatement stmt=con.prepareStatement("Select * from course");
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                combobox.addItem(rs.getString(2));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not executed");
        }


    }
      public int getCourseId(String label){
          Connection con=MyConnection.getConnection();
          int id=0;
        try {
            PreparedStatement stmt=con.prepareStatement("Select id from course where label=?");
            stmt.setString(1,label);
            ResultSet rs=stmt.executeQuery();
            if(rs.next())
            {
                id=rs.getInt(1);
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not executed");
        }

          return id;
      }
}
