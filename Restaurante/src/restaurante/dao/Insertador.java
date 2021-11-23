/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import restaurante.modelos.Cliente;

/**
 *
 * @author J_oa_
 */
public class Insertador {
    public static int insercion(Connection conn, Cliente cliente) throws Exception{
        try{
//            int libId = jTextField.getText(); // Lo ingresa el usuario, 
//            String sql = "INSERT INTO libro(libId, libNombre, libPub, ediId, autId, libPrecio)" +
//                    " VALUES ("+ libId + ", ?, ?, ?, ?, ?)";

            
            String sql = "INSERT INTO cliente(cli_login, cli_nombre, cli_apellido, cli_email, cli_celular, cli_clave, cli_fecha, cli_genero)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.getCli_login());
            statement.setString(2, cliente.getCli_nombre());
            statement.setString(3, cliente.getCli_apellido());
            statement.setString(4, cliente.getCli_email());
            statement.setLong(5, cliente.getCli_celular());
            statement.setString(6, cliente.getCli_clave());
            statement.setString(7, cliente.getCli_fecha());
            statement.setString(8, cliente.getCli_genero());
            int rowInserted = statement.executeUpdate();
            if(rowInserted > 0){
                System.out.println("Inserción exitosa!");
                return rowInserted;
            }
            
        }
        catch(Exception e){
            System.out.println("Error al insertar");
        }
        throw new Exception("Error al insertar");
    }
}
