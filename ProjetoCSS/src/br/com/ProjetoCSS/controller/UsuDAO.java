/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoCSS.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.projetocss.model.Usuario;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author diegomoraes
 */
public class UsuDAO {

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    String sql = "select * from usuarios where login_usu = ? and senha_usu = ?";
    String query = "select * from select_cli where Login = ? and Senha = ?";

    Conexao con = new Conexao();
    Usuario usu = new Usuario();

    public int Acesso(JTextField login, JTextField senha, JFrame prin, JFrame flog) {

        usu.setUsu_login(login.getText());
        usu.setUsu_senha(senha.getText());

        try {
            conexao = Conexao.conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usu.getUsu_login());
            pst.setString(2, usu.getUsu_senha());

            rs = pst.executeQuery();

            if (rs.next()) {

                JOptionPane.showMessageDialog(null, "Acesso Permitido!");
                prin.setVisible(true);
                flog.setVisible(false);

                return rs.getInt(6);

            } else {
                JOptionPane.showMessageDialog(null, "Acesso Negado!");
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e);
        }
        return 0;
    }

    public String getUsuNome(JTextField login, JTextField senha) {

        usu.setUsu_login(login.getText());
        usu.setUsu_senha(senha.getText());

        try {
            conexao = Conexao.conector();
            pst = conexao.prepareStatement(query);
            pst.setString(1, usu.getUsu_login());
            pst.setString(2, usu.getUsu_senha());

            rs = pst.executeQuery();
            rs.first();
            return rs.getString(1);

        } catch (SQLException | HeadlessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
