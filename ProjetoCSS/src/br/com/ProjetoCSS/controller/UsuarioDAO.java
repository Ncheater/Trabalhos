package br.com.ProjetoCSS.controller;

/**
 * @author Beatriz
 */
import br.com.projetocss.model.Usuario;
import java.awt.HeadlessException;
import javax.swing.*;
import java.sql.*;

public class UsuarioDAO {

//    Connection conexao;
//    PreparedStatement pst;
//    ResultSet rs;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    Conexao con = new Conexao();
    Usuario usu = new Usuario();

    public void InsereUsu(String nome, String end, int cpf, int rg, int tel, String login, String email, String senha, boolean admin) {
        String sql = "CALL new_cliente(?,?,?,?,?,?,?,?,?)";
        conexao = Conexao.conector();

        usu.setUsu_cpf(cpf);
        usu.setUsu_rg(rg);
        usu.setUsu_tel(tel);
        usu.setUsu_nome(nome);
        usu.setUsu_endereco(end);
        usu.setUsu_login(login);
        usu.setUsu_senha(senha);
        usu.setUsu_email(email);
        usu.setUsu_admin(admin);

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usu.getUsu_nome());
            pst.setString(2, usu.getUsu_endereco());
            pst.setInt(3, usu.getUsu_cpf());
            pst.setInt(4, usu.getUsu_rg());
            pst.setInt(5, usu.getUsu_tel());
            pst.setString(6, usu.getUsu_login());
            pst.setString(7, usu.getUsu_email());
            pst.setString(8, usu.getUsu_senha());
            pst.setBoolean(9, usu.isUsu_admin());

            pst.execute();
            JOptionPane.showMessageDialog(null, " Inserido com sucesso!");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, " Erro ao inserir! " + e);
        }
    }

    public void DeletaUsu(int id) {
        String sql = "CALL deleta_cliente(?)";
        conexao = Conexao.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);

            pst.execute();
            JOptionPane.showMessageDialog(null, " Deletado com sucesso!");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, " Erro ao Deletar! " + e);
        }

    }

    public void AlterarUsu(int id, String nome, String end, int cpf, int rg, int tel, String login, String email, String senha, boolean admin) {
        String sql = "CALL update_cliente(?,?,?,?,?,?,?,?,?,?)";
        conexao = Conexao.conector();
        
        usu.setUsu_id(id);
        usu.setUsu_cpf(cpf);
        usu.setUsu_rg(rg);
        usu.setUsu_tel(tel);
        usu.setUsu_nome(nome);
        usu.setUsu_endereco(end);
        usu.setUsu_login(login);
        usu.setUsu_senha(senha);
        usu.setUsu_email(email);
        usu.setUsu_admin(admin);

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1,usu.getUsu_id());
            pst.setString(2, usu.getUsu_nome());
            pst.setString(3, usu.getUsu_endereco());
            pst.setInt(4, usu.getUsu_cpf());
            pst.setInt(5, usu.getUsu_rg());
            pst.setInt(6, usu.getUsu_tel());
            pst.setString(7, usu.getUsu_login());
            pst.setString(8, usu.getUsu_email());
            pst.setString(9, usu.getUsu_senha());
            pst.setBoolean(10, usu.isUsu_admin());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso");

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + e);
        }
    }

    public ResultSet ConsultarID(int id) {

            String sql = "SELECT * FROM select_cli WHERE id_cli = ? ";
        conexao = Conexao.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;

    }

    public ResultSet ConsultarNome(String nome) {

        String sql = "SELECT * FROM select_cli WHERE nome_cli = ? ";
        conexao = Conexao.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, "%" + nome + "%");
            rs = pst.executeQuery();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;

    }
    
    public ResultSet ConsultarAll() {

        String sql = "SELECT id_cli AS ID, nome_cli AS Nome, endereco_cli AS Endereço, cpf_cli AS CPF, rg_cli AS RG, telefone_cli AS Telefone, id_usu AS Usuário, email_usu AS Email, login_usu AS Login, senha_usu AS Senha, tipo_usu AS Administrador FROM select_cli";
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
}
