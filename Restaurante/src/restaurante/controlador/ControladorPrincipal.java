/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controlador;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;
import restaurante.dao.Actualizador;
import restaurante.dao.Borrador;
import restaurante.dao.CreadorDeConexiones;
import restaurante.dao.Insertador;
import restaurante.dao.Lector;
import restaurante.modelos.Cliente;
import restaurante.vista.JFramePrincipal;

/**
 *
 * @author ALFA
 */
public class ControladorPrincipal {
    JFramePrincipal jFramePrincipal;
    Connection conn;

    /*public ControladorPrincipal(JFramePrincipal jFramePrincipal) throws Exception{
        //this.jFramePrincipal = jFramePrincipal;
        this.jFramePrincipal = jFramePrincipal;
        conn = CreadorDeConexiones.crearConexion();
    }*/

    public ControladorPrincipal(JFramePrincipal jFramePrincipal) throws Exception{
        this.jFramePrincipal = jFramePrincipal;
        conn = CreadorDeConexiones.crearConexion();
    }



    public void btnCrear() {
        try{
            Cliente cliente = new Cliente();
            cliente.setCli_login(jFramePrincipal.getTfLogin().getText());
            cliente.setCli_nombre(jFramePrincipal.getTfNombre().getText());
            cliente.setCli_email(jFramePrincipal.getTfCorreo().getText());
            cliente.setCli_celular(Long.parseLong(jFramePrincipal.getTfCelular().getText()));
            cliente.setCli_apellido(jFramePrincipal.getTfApellido().getText());
            cliente.setCli_clave(jFramePrincipal.getjPasswordField1().getText());
            cliente.setCli_fecha(jFramePrincipal.getjFormattedTextField1_FECHA().getText());
            if(jFramePrincipal.getjRBFemenino().isSelected()){
                cliente.setCli_genero("Femenino");
            }
            if(jFramePrincipal.getjRBMasculino().isSelected()){
                cliente.setCli_genero("Masculino");
            }            
            //cliente.setCli_fecha("1910-10-10");
            jFramePrincipal.getTaErrores().setText("El cliente ha sido creado");
            Insertador.insercion(conn, cliente);
        }
        catch(Exception e){
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionDetails = sw.toString();
            jFramePrincipal.getTaErrores().setText("=> El cliente NO ha sido creado. \n"+"\n"+"=> "+exceptionDetails+"\n"+"=> El cliente NO ha sido creado.");
        }
    }

    public void btnActualizar() {
        try{
            Cliente cliente = new Cliente();
            cliente.setCli_login(jFramePrincipal.getTfLogin().getText());
            cliente.setCli_nombre(jFramePrincipal.getTfNombre().getText());
            cliente.setCli_email(jFramePrincipal.getTfCorreo().getText());
            cliente.setCli_celular(Long.parseLong(jFramePrincipal.getTfCelular().getText()));
            cliente.setCli_apellido(jFramePrincipal.getTfApellido().getText());
            cliente.setCli_clave(jFramePrincipal.getjPasswordField1().getText());
            cliente.setCli_fecha(jFramePrincipal.getjFormattedTextField1_FECHA().getText());
            //cliente.setCli_fecha("1910-10-10");
            if(jFramePrincipal.getjRBFemenino().isSelected()){
                cliente.setCli_genero("Femenino");
            }
            if(jFramePrincipal.getjRBMasculino().isSelected()){
                cliente.setCli_genero("Masculino");
            }            
        
            Actualizador.actualizar(conn, cliente);
            jFramePrincipal.getTaErrores().setText("La actualización ha sido exitosa");
        }
        catch(Exception e){
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionDetails = sw.toString();
            jFramePrincipal.getTaErrores().setText("=> El cliente NO ha sido actualizado. \n"+"\n"+"=> "+exceptionDetails+"\n"+"=> El cliente NO ha sido actualizado.");
        }
    }

    public void btnConsultar() {
        try{
            String identificador = (jFramePrincipal.getTfLogin().getText());
            Cliente cliente = Lector.leerPorIdentificador(conn, identificador);
            //jFramePrincipal.getTfLogin().setText(cliente.getCli_login());
            jFramePrincipal.getTfNombre().setText(cliente.getCli_nombre());
            jFramePrincipal.getTfApellido().setText(cliente.getCli_apellido());
            jFramePrincipal.getTfCorreo().setText(cliente.getCli_email());
            jFramePrincipal.getTfCelular().setText(cliente.getCli_celular().toString());
            jFramePrincipal.getjPasswordField1().setText(cliente.getCli_clave());
            jFramePrincipal.getjFormattedTextField1_FECHA().setText(cliente.getCli_fecha());
            if("Femenino".equals(cliente.getCli_genero().toString())){
            //if(cliente.getCli_genero().equals("Femenino")){
                jFramePrincipal.getjRBFemenino().setSelected(true);
            }
            if("Masculino".equals(cliente.getCli_genero().toString())){
            //if(cliente.getCli_genero().equals("Masculino")){
                jFramePrincipal.getjRBMasculino().setSelected(true);
            }              
            //jFramePrincipal.getButtonGroup1().;
            
            jFramePrincipal.getTaErrores().setText("La consulta ha sido exitosa \n");
        }
        catch(Exception e){
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionDetails = sw.toString();
            jFramePrincipal.getTaErrores().setText("=> El cliente NO ha sido encontrado. \n"+"\n"+"=> "+exceptionDetails+"\n"+"=> El cliente NO ha sido encontrado.");
        }
    }

    public void btnBorrar() {
        try{
            String identificador = (jFramePrincipal.getTfLogin().getText());
            Cliente cliente = new Cliente();
            cliente.setCli_login(identificador);
            Borrador.borrar(conn, cliente);
            jFramePrincipal.getTaErrores().setText("El borrado ha sido exitoso");
            System.out.println("El borrado ha sido exitoso");
        }
        catch(Exception e){
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionDetails = sw.toString();
            jFramePrincipal.getTaErrores().setText("=> El cliente NO ha sido borrado. \n"+"\n"+"=> "+exceptionDetails+"\n"+"=> El cliente NO ha sido borrado.");
        }     
    }
}
