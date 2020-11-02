
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo
 */
public class MyConnection {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/questionpaper", "root", "");
        }catch(ClassNotFoundException ae){
            JOptionPane.showMessageDialog(null,"Not Loaded");
        }catch(SQLException ak){
            JOptionPane.showMessageDialog(null,"Not Connected");
        }
        return con;
    }
    
}
