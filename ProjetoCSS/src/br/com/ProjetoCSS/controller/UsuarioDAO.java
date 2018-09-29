package br.com.ProjetoCSS.controller;
/**
 * @author Beatriz
 */
import br.com.projetocss.model.Usuario;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class UsuarioDAO {
    
//    Connection conexao;
//    PreparedStatement pst;
//    ResultSet rs;

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;  
   
    Conexao con = new Conexao();
    Usuario usu = new Usuario();

  public void InsereUsu(JTextField login_usu, JTextField senha_usu, JTextField email_usu, JTextField nome_usu, String tipo_usu, JFrame flog ) {
    String sql = "insert into usuarios (login_usu, email_usu, senha_usu, nome_usu, tipo_usu) values (?,?,?,?,?)";
    conexao = con.conector();

    usu.setUsu_login(login_usu.getText());
    usu.setUsu_senha(senha_usu.getText()); 
    usu.setUsu_email(email_usu.getText());
    usu.setUsu_nome(nome_usu.getText());
    usu.setUsu_tipo(tipo_usu);

          
    try {
            
        pst = conexao.prepareStatement(sql);
        pst.setString(1, usu.getUsu_login());
        pst.setString(2, usu.getUsu_senha()); 
        pst.setString(3, usu.getUsu_email());
        pst.setString(4, usu.getUsu_nome()); 
        pst.setString(5, usu.getUsu_tipo());
            
        pst.execute();
          JOptionPane.showMessageDialog(null, " Inserido com sucesso! ");
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null," Erro ao inserir! "+e);
        }
    }
  
  public void DeletaUsu(JTextField usu_id, JFrame flog){
      String sql = "delete from usuarios where id_usu = ?";
      conexao = con.conector();
 
   
        usu.setUsu_id(Integer.parseInt(usu_id.getText()));
    try{
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, usu.getUsu_id());
        
        pst.execute();
           JOptionPane.showMessageDialog(null, " Deletado com sucesso! ");
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null," Erro ao Deletar! "+e);
        }
        
    }
        
      
  public void AlterarUsu(JTextField usu_id, JTextField login_usu, JTextField senha_usu, JTextField email_usu, JTextField nome_usu, String tipo_usu, JFrame flog){
      String sql = "update usuarios set login_usu = ?, email_usu = ?, senha_usu = ?,  nome_usu = ?, tipo_usu = ? where id_usu = ?";
      conexao = con.conector();
      
      usu.setUsu_id(Integer.parseInt(usu_id.getText()));
      usu.setUsu_login(login_usu.getText());
      usu.setUsu_senha(senha_usu.getText()); 
      usu.setUsu_email(email_usu.getText());
      usu.setUsu_nome(nome_usu.getText());
      usu.setUsu_tipo(tipo_usu);
      
      try {
            pst.setInt(1, usu.getUsu_id());
            pst.setString(2, login_usu.getText());   
            pst.setString(3, senha_usu.getText());
            pst.setString(4, email_usu.getText()); 
            pst.setString(4, nome_usu.getText());
            pst.setString(5, usu.getUsu_tipo());

            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso"+e);
        }     
    }
  
  public ResultSet ConsultarID (JTextField usu_id, JFrame flog){
       
    String sql = " select id_usu as ID, nome_usu as Nome, login_usu as Login, tipo_usu as Tipo from usuarios where id_usu = ? ";
    conexao = con.conector();
            try{
                pst = conexao.prepareStatement(sql);
                pst.setString(1, usu_id.getText()); 
                rs = pst.executeQuery(); 
          
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
       
        return rs;
    
  }
  public ResultSet ConsultarNome (JTextField usu_nome, JFrame Fflog) {
      
      String sql = " select id_usu as ID, nome_usu as Nome, login_usu as Login, tipo_usu as Tipo from usuarios where nome_usu like ? ";
      conexao = con.conector();
        try{
            pst = conexao.prepareStatement(sql);
            pst.setString(1,"%"+ usu_nome.getText()+"%");
            rs = pst.executeQuery();
            
        }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
        }
        
        return rs;
  
}
}
