/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.modelos;

/**
 *
 * @author ALFA
 */
public class Cliente {
    String cli_login;
    String cli_nombre;
    String cli_apellido;
    String cli_email;
    Long cli_celular;
    String cli_clave;
    String cli_fecha;
    String cli_genero;

    public Cliente() {
        
    }

    public Cliente(String cli_login, String cli_nombre, String cli_apellido, String cli_email, Long cli_celular, String cli_clave, String cli_fecha, String cli_genero) {
        this.cli_login = cli_login;
        this.cli_nombre = cli_nombre;
        this.cli_apellido = cli_apellido;
        this.cli_email = cli_email;
        this.cli_celular = cli_celular;
        this.cli_clave = cli_clave;
        this.cli_fecha = cli_fecha;
        this.cli_genero = cli_genero;
    }

    public String getCli_login() {
        return cli_login;
    }

    public void setCli_login(String cli_login) {
        this.cli_login = cli_login;
    }

    public String getCli_nombre() {
        return cli_nombre;
    }

    public void setCli_nombre(String cli_nombre) {
        this.cli_nombre = cli_nombre;
    }

    public String getCli_apellido() {
        return cli_apellido;
    }

    public void setCli_apellido(String cli_apellido) {
        this.cli_apellido = cli_apellido;
    }

    public String getCli_email() {
        return cli_email;
    }

    public void setCli_email(String cli_email) {
        this.cli_email = cli_email;
    }

    public Long getCli_celular() {
        return cli_celular;
    }

    public void setCli_celular(Long cli_celular) {
        this.cli_celular = cli_celular;
    }

    public String getCli_clave() {
        return cli_clave;
    }

    public void setCli_clave(String cli_clave) {
        this.cli_clave = cli_clave;
    }

    public String getCli_fecha() {
        return cli_fecha;
    }

    public void setCli_fecha(String cli_fecha) {
        this.cli_fecha = cli_fecha;
    }

    public String getCli_genero() {
        return cli_genero;
    }

    public void setCli_genero(String cli_genero) {
        this.cli_genero = cli_genero;
    }


}
