/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import com.mysql.jdbc.Driver;


public class ConexaoBanco {
        private static final String USERNAME= "root";
        private static final String PASSWORD= "juventude";
        private static final String CONN_STRING="jdbc:mysql://localhost:3306/arquiteturasoftware";
        
        public Connection Conexao( )
        {
            Connection  conn = null;
            PreparedStatement ps =  null;
            ResultSet rs = null;
            
            try {
                conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                
            } catch (SQLException e) 
            {
                System.out.println("Erro conexão com o banco"); 
            } 
            return conn;
        }
}
