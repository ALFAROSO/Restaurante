/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import restaurante.modelos.Cliente;

/**
 *
 * @author J_oa_
 */
public class Lector {
    public static void leer(Connection conn) throws Exception{
        String sql = "select * from cliente";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        int count = 0;
        while(result.next()){
            String nombre = result.getString(2);
            Long celular =  result.getLong(5);
            String clave = result.getString(6);
            
            System.out.println("NOMBRE: " + nombre + " CELULAR: " + celular + " CLAVE: " + clave);
        }
    }
    
    public static Cliente leerPorIdentificador(Connection conn, String identificador) throws Exception{
        String sql = "select * from cliente where cli_login = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, identificador);
        ResultSet result = statement.executeQuery();
        
        int count = 0;

        //String log = result.getString(1);
        result.next();
        String nombre = result.getString(2);
        String apellido = result.getString(3);
        String correo = result.getString(4);
        Long celular =  result.getLong(6);
        String genero = result.getString(5);
        String clave = result.getString(7);
        String fecha = result.getString(8);
        
        Cliente cliente = new Cliente();
        cliente.setCli_nombre(nombre);
        cliente.setCli_celular(celular);
        cliente.setCli_clave(clave);
        cliente.setCli_email(correo);
        cliente.setCli_apellido(apellido);
        cliente.setCli_fecha(fecha);
        cliente.setCli_genero(genero);
        //cliente.setCli_login(log);
        
        
        System.out.println("NOMBRE: " + nombre + " - CELULAR: " + celular + " - CLAVE: " + clave);
        
        return cliente;

    }
}
