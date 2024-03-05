package JavaJDBCTuts;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Tuts1 {
    public static void main(String[] args) {
        
        File jdbcFile = new File("F:\\JavaRevision\\JavaRevision\\src\\main\\java\\JavaJDBCTuts\\JdbcCredentials.properties");
        
        Properties properties = new Properties();
        
        try {
            Scanner sc = new Scanner(jdbcFile);
            
            
            properties.load(new FileInputStream(jdbcFile));
            
            
        } catch (FileNotFoundException e) {
            System.out.println("File Not found");
        } catch (IOException ex) {
            Logger.getLogger(Tuts1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        final String user = properties.getProperty("userName");
        final String password=properties.getProperty("password");
        final String url = properties.getProperty("url");
        
        try(Connection con = DriverManager.getConnection(url,user,password);) {
            
//            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement statement = con.prepareStatement("Select * from students where age=?");
            statement.setInt(1, 16);
            ResultSet rs = statement.executeQuery();
//            ResultSet rs = statement.executeQuery("Select * from students");
            rs.next();
            System.out.println(rs.getString("name")+ " "+ rs.getString("age"));
//            while(rs.next()){
//                System.out.println(rs.getString("name"));
//                System.out.println(rs.getString("age"));
//            }
            
           
        } catch (SQLException e) {
            System.out.println("Error in Connection");
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Class Not loaded");
            e.printStackTrace();
        }
    }
}
