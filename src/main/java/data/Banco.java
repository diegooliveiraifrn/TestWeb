/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco {
    
    private Statement stmt;
    private ResultSet rs;
    public Connection conn;
    
    public Banco(){
        String url = "jdbc:mysql://biblioteca.c36nogcf3xn0.sa-east-1.rds.amazonaws.com:3306/biblioteca";
        String usr = "admin";
        String pas = "ifrn$2024";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usr, pas);
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
                
    }
    
    public String getUsuario(String login) throws SQLException{
        String nome = "";
        rs = stmt.executeQuery("SELECT * FROM usuario WHERE login = '"+login+"'");
        while(rs.next()){
            nome = rs.getString("nome");
        }
        return nome;
    }
    
    public String getSenha(String login) throws SQLException{
        String senha = "";
        rs = stmt.executeQuery("SELECT * FROM usuario WHERE login = '"+login+"'");
        while(rs.next()){
            senha = rs.getString("senha");
        }
        return senha;
    }
        
}
