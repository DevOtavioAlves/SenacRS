
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm, @DevOtavioAlves
 */
public class conectaDAO {
    
    public Connection connectDB(){
        Connection con = null;
        
        try {
        
            con = DriverManager.getConnection("jdbc:mysql://localhost/uc11?user=root&password=admin&useSSL=false");
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return con;
    }
    
}
