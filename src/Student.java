
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
public class Student {
    public void insertUpdateDeleteStudent(char operation,Integer id,String fName,String lName,String gender,
            String birthdate,String contact,String address){
        Connection con=MyConnection.getConnection();
        if(operation=='i'){ 
           try {
            PreparedStatement stmt=con.prepareStatement("INSERT INTO student(first_name, last_name, sex, birthdate, phone, address) VALUES (?,?,?,?,?,?)");
            stmt.setString(1,fName );
            stmt.setString(2,lName );
            stmt.setString(3,gender );
            stmt.setString(4,birthdate );
            stmt.setString(5, contact);
            stmt.setString(6,address );
            if(stmt.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"New Student Added");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not Inserted");
        }
           Welcome.jLabel_stcount.setText("Student Count: "+Integer.toString(MyFunction.count("student")));
       }
        if(operation=='u'){
             try {
            PreparedStatement stmt=con.prepareStatement("UPDATE `student` SET `first_name`=?,`last_name`=?,`sex`=?,`birthdate`=?,`phone`=?,`address`=? WHERE `id`=?");
            stmt.setString(1,fName );
            stmt.setString(2,lName );
            stmt.setString(3,gender );
            stmt.setString(4,birthdate );
            stmt.setString(5, contact);
            stmt.setString(6,address );
            stmt.setInt(7,id );
            if(stmt.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Student Updated");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not Inserted");
        }
            
            
        }
        if(operation=='r'){
             try {
            PreparedStatement stmt=con.prepareStatement("DELETE FROM `student` WHERE id=?");
           
            stmt.setInt(1,id );
            if(stmt.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Student Removed");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not Removed");
        }
            
            
        }


    }
    public void jtableFilledStudent(JTable table,String toSearch){
        Connection con=MyConnection.getConnection();
        try {
            PreparedStatement stmt=con.prepareStatement("SELECT * FROM student where concat(id,first_name,last_name,sex,birthdate,phone,address) LIKE ? ");
            stmt.setString(1,"%"+toSearch+"%");
            ResultSet rs=stmt.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            Object row[];
            while(rs.next()){
                row =new Object[7];
                row[0]=rs.getString(1);
                row[1]=rs.getString(2);
                row[2]=rs.getString(3);
                row[3]=rs.getString(4);
                row[4]=rs.getString(5);
                row[5]=rs.getString(6);
                row[6]=rs.getString(7);
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not Inserted");
        }


    }

}
