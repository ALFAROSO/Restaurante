/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import restaurante.modelos.Cliente;

/**
 *
 * @author J_oa_
 */
public class Actualizador {
    public static boolean actualizar(Connection conn, Cliente cliente) throws SQLException{
        if (cliente != null){
            String sql = "UPDATE cliente SET cli_nombre=?, cli_apellido=?, cli_email=?, cli_celular=?, cli_clave=?, cli_fecha=? ,cli_genero=? WHERE cli_login=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.getCli_nombre());
            statement.setString(2, cliente.getCli_apellido());
            statement.setString(3, cliente.getCli_email());
            statement.setLong(4, cliente.getCli_celular());
            statement.setString(5, cliente.getCli_clave());
            statement.setString(6, cliente.getCli_fecha());
            statement.setString(7, cliente.getCli_genero());
            statement.setString(8, cliente.getCli_login());
            

            int rowsUpdated = statement.executeUpdate();
            if(rowsUpdated > 0){
                System.out.println("El registro fue actualizado exitosamente!");
                return true;
            }
            else{
                System.out.println("El registro no fue actualizado exitosamente!");
                return false;
            }    
        }else {
            System.out.println("El registro no fue actualizado exitosamente!");
            return false;
        }
    }
}
