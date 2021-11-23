

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
public class Borrador {
    public static boolean borrar(Connection conn, Cliente cliente) throws SQLException{
        if(cliente != null){
            String sql = "DELETE FROM cliente WHERE cli_login=?";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cliente.getCli_login());

            int rowsDeleted = statement.executeUpdate();
            if(rowsDeleted > 0){
                System.out.println("Borrado exitoso!");
                return true;
            }
            else return false;
        }
        else
            return false;
    }
}
