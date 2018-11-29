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
 * @author lucas
 */
public class ItemDAO {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    Conexao con = new Conexao();
    Produto prd = new Produto();

    public void InsereItem(int cli, int idv, int qtd, int idp) {
        String sql = "CALL cad_venda(0, ?, ?, ?, ?)";
        conexao = Conexao.conector();

        try {

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, cli);
            pst.setInt(2, idv);
            pst.setInt(3, qtd);
            pst.setInt(4, idp);
            
            pst.executeQuery();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            ConsultarAll();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir! " + e);
        }
        con.desconector(conexao);

    }

    public void DeletaProd(int idv, int idp) {
        String sql = "CALL remove_item(?, ?)";
        conexao = Conexao.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, idv);
            pst.setInt(2, idp);

            pst.executeQuery();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar! " + e);
        }
        con.desconector(conexao);

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
}
