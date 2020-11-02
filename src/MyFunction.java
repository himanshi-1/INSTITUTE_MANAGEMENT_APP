
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
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
public class MyFunction {
    public static int count(String tablename){
        Connection con=MyConnection.getConnection();;
        int total=0;
        Statement st;
        try{
            st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT COUNT(*) AS 'total' FROM "+tablename);
            while(rs.next()){
                total=rs.getInt(1);
                
            }
        }catch(SQLException ak){
           JOptionPane.showMessageDialog(null,"Not Connected");
        }
        return total;
    }
    
}
