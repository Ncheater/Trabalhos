/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetocss.view;

import br.com.ProjetoCSS.controller.Conexao;
import br.com.ProjetoCSS.controller.UsuDAO;
import java.sql.Connection;

/**
 *
 * @author Beatriz
 */
public class JFLogin extends javax.swing.JFrame {

    /**
     * Creates new form JFLogin
     */
    Connection con;
    Conexao conexao = new Conexao();
    public static int type;
    public static String usu;

    public JFLogin() {
        initComponents();
        con = Conexao.conector();
        conexao.desconector(con);
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        txt_usuario = new javax.swing.JTextField();
        txt_senha = new javax.swing.JPasswordField();
        btn_acesso = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Módulo de Acesso - Sistema de Venda de Roupas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 220, 30));
        getContentPane().add(txt_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 220, 30));

        btn_acesso.setBackground(new java.awt.Color(0, 153, 204));
        btn_acesso.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btn_acesso.setText("Acessar");
        btn_acesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_acessoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_acesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 220, 30));

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setToolTipText("");
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 550, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFocusTraversalPolicyProvider(true);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("Usuário");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 35, -1, 20));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("Senha");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 75, -1, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/css_256.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 160));
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        setBounds(0, 0, 555, 238);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_acessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_acessoActionPerformed
        // TODO add your handling code here:
        UsuDAO usudao = new UsuDAO();
        JFPrincipal principal = new JFPrincipal();

        type = usudao.Acesso(txt_usuario, txt_senha, principal, this);
        usu = usudao.getUsuNome(txt_usuario, txt_senha);
        conexao.desconector(con);
    }//GEN-LAST:event_btn_acessoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JFLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_acesso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
