/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import restaurante.modelos.Cliente;

/**
 *
 * @author J_oa_
 */
public class PruebaJdbc {
   
    public static void main(String[] args) {
        try{
            Connection conn = CreadorDeConexiones.crearConexion();
            Cliente cliente= new Cliente();
            cliente.setCli_login("PRUEBA");
            cliente.setCli_nombre("nom");
            cliente.setCli_apellido("ape");
            cliente.setCli_email("corr@corr.com");
            //cliente.setCli_celular();
            cliente.setCli_celular(12345685242L);
            cliente.setCli_fecha("1910-10-10");
            
            Borrador.borrar(conn, cliente);
            
            Insertador.insercion(conn, cliente);
            
//            Lector.leer(conn);
//            Lector.leer(conn, "PRUEBA");
            Actualizador.actualizar(conn, cliente);
            Borrador.borrar(conn, cliente);
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
