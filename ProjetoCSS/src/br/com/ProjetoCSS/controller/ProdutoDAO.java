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

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    Conexao con = new Conexao();
    Produto prd = new Produto();

    public void InsereProd(Produto prd) {
        String sql = "INSERT INTO produto(nome_prod, desc_produto, qtd_prod, valor_prod, cat_prod) VALUES (?, ?, ?, ? ,?)";
        conexao = con.conector();

        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, prd.getNome_prod());
            pst.setString(2, prd.getDesc_prod());
            pst.setInt(3, prd.getQtd_prod());
            pst.setFloat(4, prd.getValor_prod());
            pst.setString(5, prd.getCat_prod());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            ConsultarAll();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir! "+e);
        }
    }

    public void DeletaProd(int id) {
        String sql = "DELETE FROM produto WHERE id_prod = ?";
        conexao = con.conector();

        prd.setId_prod(id);
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, prd.getId_prod());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar! "+e);
        }

    }

    public void AlterarProd(Produto prd) {
        String sql = "UPDATE produto SET nome_prod = ?, desc_produto = ?, qtd_prod = ?,  valor_prod = ?, cat_prod = ? WHERE id_prod = ?";
        conexao = con.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, prd.getNome_prod());
            pst.setString(2, prd.getDesc_prod());
            pst.setInt(3, prd.getQtd_prod());
            pst.setFloat(4, prd.getValor_prod());
            pst.setString(5, prd.getCat_prod());
            pst.setInt(6, prd.getId_prod());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: "+e);
        }
    }

    public ResultSet ConsultarID(int id) {

        String sql = "SELECT id_prod AS ID, nome_prod AS Nome, desc_produto AS Descrição, qtd_prod AS Qtd, valor_prod AS Valor, cat_prod AS Categoria FROM produto WHERE id_prod = ?";
        conexao = con.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;

    }

    public ResultSet ConsultarNome(String nome) {

        String sql = "SELECT id_prod AS ID, nome_prod AS Nome, desc_produto AS Descrição, qtd_prod AS Qtd, valor_prod AS Valor, cat_prod AS Categoria FROM produto WHERE nome_prod LIKE ?";
        conexao = con.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome+"%");
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;

    }
    
    public ResultSet ConsultarCat(String cat) {

        String sql = "SELECT id_prod AS ID, nome_prod AS Nome, desc_produto AS Descrição, qtd_prod AS Qtd, valor_prod AS Valor, cat_prod AS Categoria FROM produto WHERE cat_prod LIKE ?";
        conexao = con.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cat);
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;

    }
    
    public ResultSet ConsultarAll() {

        String sql = "SELECT id_prod AS ID, nome_prod AS Nome, desc_produto AS Descrição , qtd_prod AS Qtd, valor_prod AS Valor, cat_prod AS Categoria FROM produto";
        conexao = con.conector();
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;
        
    }
}
