/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoCSS.controller;

import br.com.ProjetoCSS.model.Produto;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Yago
 */
public class ProdutoDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    Conexao con = new Conexao();
    Produto prd = new Produto();

    public void InsereProd(Produto prd) {
        String sql = "INSERT INTO produto(nome_prod, desc_produto, qtd_prod, valor_prod, cat_prod) VALUES (?, ?, ?, ? ,?)";
        conexao = Conexao.conector();

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
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir! " + e);
        }
        con.desconector(conexao);

    }

    public void DeletaProd(Produto prd) {
        String sql = "UPDATE select_active SET status_prod = 0 WHERE ID = ?";
        conexao = Conexao.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, prd.getId_prod());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar! " + e);
        }
        con.desconector(conexao);

    }
    
    public void RestauraProd(Produto prd) {
        String sql = "UPDATE select_inactive SET status_prod = 1 WHERE ID = ?";
        conexao = Conexao.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, prd.getId_prod());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Restaurado com sucesso!");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Restaurar! " + e);
        }
        con.desconector(conexao);

    }

    public void AlterarProd(Produto prd) {
        String sql = "UPDATE select_active SET Nome = ?, Descrição = ?, Quantidade = ?,  Valor = ?, Categoria = ?, status_prod = ? WHERE ID = ?";
        conexao = Conexao.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, prd.getNome_prod());
            pst.setString(2, prd.getDesc_prod());
            pst.setInt(3, prd.getQtd_prod());
            pst.setFloat(4, prd.getValor_prod());
            pst.setString(5, prd.getCat_prod());
            if (prd.getQtd_prod() == 0) {
                int confirm = JOptionPane.showConfirmDialog(null, "Item com estoque vazio, deseja removê-lo?", "Estoque vazio", JOptionPane.YES_NO_OPTION);
                if (confirm == 0) {
                    pst.setInt(6, 0);
                }
            } else {
                pst.setInt(6, 1);
            }
            pst.setInt(7, prd.getId_prod());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
            con.desconector(conexao);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + e);
        }
    }

    public ResultSet ConsultarID(int id) {

        String sql = "SELECT ID, Nome, Descrição, Quantidade, Valor, Categoria FROM select_active WHERE ID = ?";
        conexao = Conexao.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        con.desconector(conexao);
        return null;

    }

    public ResultSet ConsultarNome(String nome) {

        String sql = "SELECT ID, Nome, Descrição, Quantidade, Valor, Categoria FROM select_active WHERE Nome LIKE ?";
        conexao = Conexao.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome + "%");
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        con.desconector(conexao);
        return null;

    }

    public ResultSet ConsultarCat(String cat) {

        String sql = "SELECT ID, Nome, Descrição, Quantidade, Valor, Categoria FROM produto WHERE Categoria LIKE ?";
        conexao = Conexao.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cat);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        con.desconector(conexao);
        return null;

    }

    public ResultSet ConsultarAll() {

        String sql = "SELECT ID, Nome, Descrição, Quantidade, Valor, Categoria FROM select_active";
        conexao = Conexao.conector();
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        con.desconector(conexao);
        return null;

    }
    
    public ResultSet ConsultarInativo() {

        String sql = "SELECT ID, Nome, Descrição, Quantidade, Valor, Categoria FROM select_inactive";
        conexao = Conexao.conector();
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        con.desconector(conexao);
        return null;

    }
}
