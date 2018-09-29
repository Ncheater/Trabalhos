/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoCSS.controller;

import java.sql.*;

/**
 *
 * @author Beatriz
 */
public class Conexao {
    
    public static Connection conector(){
        
        Connection conexao;
        String driver = "com.mysql.jdbc.Driver";
        
        try {
          
            Class.forName(driver);
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/bd_css","root","");
            System.out.println("Conectado com sucesso!");
            return conexao;
            
        } catch (Exception e) {
            
            System.out.println("Error ao conectar: "+e);
            return null;
            
        }            
        
    }
    
    public void desconector (Connection con){
        try {
            con.close();
            System.out.println("Desconectado com Sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao desconectar: "+e);
        }
    }
    
}
