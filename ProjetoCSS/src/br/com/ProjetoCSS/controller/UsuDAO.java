package br.com.ProjetoCSS.controller;

import br.com.projetocss.model.Usuario;
import br.com.projetocss.view.JFLogin;
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

    Conexao con = new Conexao();
    Usuario usu = new Usuario();

    public void Acesso(JTextField login, JTextField senha, JFrame prin, JFrame flog) {      
        usu.setUsu_login(login.getText());
        usu.setUsu_senha(senha.getText());

        try {
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usu.getUsu_login());
            pst.setString(2, usu.getUsu_senha());

            rs = pst.executeQuery();

            if (rs.next()) {

                JOptionPane.showMessageDialog(null, "Acesso Permitido!");
                prin.setVisible(true);
                flog.setVisible(false);
                
                con.desconector(conexao);

            } else {
                JOptionPane.showMessageDialog(null, "Acesso Negado!");
                con.desconector(conexao);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e);
        }

    }

}

