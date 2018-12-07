/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoCSS.controller;

import br.com.ProjetoCSS.model.Itens;
import br.com.ProjetoCSS.model.Produto;
import br.com.ProjetoCSS.model.Venda;
import br.com.projetocss.model.Usuario;
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
public class VendaDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    Conexao con = new Conexao();
    Venda vnd = new Venda();
    Usuario usu = new Usuario();
    Itens it = new Itens();
    Produto prd = new Produto();

    public void InsereVenda(int id) {
        String sql = "CALL cad_venda(1,?,0,0,0)";
        conexao = Conexao.conector();

        try {

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Venda aberta com sucesso!");
            ConsultarAll();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir venda! " + e);
        }
        con.desconector(conexao);

    }
    
    public void InsereItem(Venda vnd, int qtd, Produto prd) {
        String sql = "CALL cad_venda(0,0,?,?,?)";
        conexao = Conexao.conector();

        try {

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, vnd.getId_venda());
            pst.setInt(2, qtd);
            pst.setInt(3, prd.getId_prod());

            pst.executeUpdate();
            ConsultarAll();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar item! " + e);
        }
        con.desconector(conexao);

    }

    public void DeletaItem(Venda vnd, Produto prd) {
        String sql = "CALL remove_item(?,?)";
        conexao = Conexao.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, vnd.getId_venda());
            pst.setInt(2, prd.getId_prod());

            pst.executeUpdate();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover! " + e);
        }
        con.desconector(conexao);

    }
    
    public void LimpaVenda(int id) {
        String sql = "DELETE FROM itens WHERE id_venda = ?";
        conexao = Conexao.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);

            pst.executeUpdate();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover! " + e);
        }
        con.desconector(conexao);

    }
    
    public void FinalizaVenda(int id) {
        String sql = "CALL finaliza_itens(?)";
        conexao = Conexao.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);

            pst.executeUpdate();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao finalizar! " + e);
        }
        con.desconector(conexao);

    }

    public ResultSet ConsultarID(int id) {

        String sql = "SELECT * FROM select_venda WHERE `Venda ID` = ?";
        conexao = Conexao.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            return rs;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        con.desconector(conexao);
        return null;

    }
    
    public ResultSet ConsultarNome(String nome) {

        String sql = "SELECT * FROM select_venda WHERE Nome LIKE ?";
        conexao = Conexao.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            return rs;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        con.desconector(conexao);
        return null;

    }
    
    public Float ConsultarTotal(int id) {

        String sql = "SELECT SUM(Total) FROM select_itens WHERE Venda = ?";
        conexao = Conexao.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.first();
            return rs.getFloat(1);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        con.desconector(conexao);
        return null;

    }

    public ResultSet ConsultarNomeCliente(String nome) {

        String sql = "SELECT ID, Nome, CPF FROM select_cli WHERE Nome LIKE ?";
        conexao = Conexao.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome + "%");
            rs = pst.executeQuery();
            return rs;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        con.desconector(conexao);
        return null;

    }
    
    public ResultSet ConsultarNomeProduto(String nome) {

        String sql = "SELECT ID, Nome, Quantidade, Valor FROM select_active WHERE Nome LIKE ?";
        conexao = Conexao.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome + "%");
            rs = pst.executeQuery();
            return rs;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        con.desconector(conexao);
        return null;

    }

    public ResultSet ConsultarAll() {

        String sql = "SELECT * FROM select_venda";
        conexao = Conexao.conector();
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        con.desconector(conexao);
        return null;

    }
    
    public ResultSet ConsultarItens(int id) {

        String sql = "SELECT * FROM select_itens WHERE Venda = ?";
        conexao = Conexao.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            return rs;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        con.desconector(conexao);
        return null;

    }
    
    public int ConsultarIdNova() {

        String sql = "SELECT MAX(id_venda) FROM venda";
        conexao = Conexao.conector();
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            return Integer.parseInt(rs.getString(1));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        con.desconector(conexao);
        return 0;

    }
}
