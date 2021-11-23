/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author J_oa_
 */
public class CreadorDeConexiones {
    public static Connection crearConexion() throws SQLException{    
        String dbURL = "jdbc:mysql://localhost:3306/bd_restaurante";
        //String dbURL = "jdbc:mysql://127.0.0.1:3306/bd_restaurante";
        // tipo_de_driver:dbms://direccion_ip:puerto/base_de_datos
        String username = "root";
        String password = "Root";
        
        Connection conn = DriverManager.getConnection(dbURL, username, password);

        System.out.println("Connectado");
        return conn;
    }
}
