/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoCSS.controller;

import br.com.ProjetoCSS.model.Produto;
import br.com.projetocss.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author yagog
 */
public class ProdutoDAO {
    
    private Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;
    
    Conexao conn = new Conexao();
    
    public Object[] SelectAll(){
        
        String sql = "SELECT * FROM produto";
        
        try{
            this.conexao = conn.conector();
            this.pst = conexao.prepareStatement(sql);
            this.rs = pst.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String desc = rs.getString(3);
                int qtd = rs.getInt(4);
                float valor = rs.getFloat(5);
                String cat = rs.getString(6);
                
                Object[] obj = {id, nome, desc, qtd, valor, cat};
                
                return obj;
            }
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro 001: "+e);
        }
        finally{
            return null;
        }
    }
}
