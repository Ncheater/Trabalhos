/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetocss.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author diegomoraes
 */
public class Usuario {
    
    private int usu_id, usu_rg;
    private Long usu_tel, usu_cpf;
    private String usu_nome, usu_endereco, usu_login, usu_senha, usu_email;
    private boolean usu_admin;

    public int getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(int usu_id) {
        this.usu_id = usu_id;
    }

    public Long getUsu_cpf() {
        return usu_cpf;
    }

    public void setUsu_cpf(Long usu_cpf) {
        this.usu_cpf = usu_cpf;
    }

    public int getUsu_rg() {
        return usu_rg;
    }

    public void setUsu_rg(int usu_rg) {
        this.usu_rg = usu_rg;
    }

    public Long getUsu_tel() {
        return usu_tel;
    }

    public void setUsu_tel(Long usu_tel) {
        this.usu_tel = usu_tel;
    }

    public String getUsu_nome() {
        return usu_nome;
    }

    public void setUsu_nome(String usu_nome) {
        this.usu_nome = usu_nome;
    }

    public String getUsu_endereco() {
        return usu_endereco;
    }

    public void setUsu_endereco(String usu_endereco) {
        this.usu_endereco = usu_endereco;
    }

    public String getUsu_login() {
        return usu_login;
    }

    public void setUsu_login(String usu_login) {
        this.usu_login = usu_login;
    }

    public String getUsu_senha() {
        return usu_senha;
    }

    public void setUsu_senha(String usu_senha) {
        this.usu_senha = usu_senha;
    }

    public String getUsu_email() {
        return usu_email;
    }

    public void setUsu_email(String usu_email) {
        this.usu_email = usu_email;
    }

    public boolean isUsu_admin() {
        return usu_admin;
    }

    public void setUsu_admin(boolean usu_admin) {
        this.usu_admin = usu_admin;
    }
}
