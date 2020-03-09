/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import entidades.Usuario;
import javax.swing.JOptionPane;
import persistencia.Banco;
import persistencia.Criptografia;

/**
 *
 * @author brunn
 */
public class CadastroUsuario extends javax.swing.JDialog {

    private Usuario usuario;
    /**
     * Creates new form CadastroUsuarios
     */
    public CadastroUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        jbutaonovo.setEnabled(false);
        this.usuario = null;
    }
    
    public CadastroUsuario(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        jbutaonovo.setEnabled(false);
        this.usuario = usuario;
        jnome.setText(usuario.getNome());
        jlogin.setText(usuario.getLogin());
        jemail.setText(usuario.getEmail());
        this.setTitle("EDITAR USUÁRIO");
        jbutaonovo.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jnome = new javax.swing.JTextField();
        jlogin = new javax.swing.JTextField();
        jemail = new javax.swing.JTextField();
        jsenha = new javax.swing.JPasswordField();
        jconfirmasenha = new javax.swing.JPasswordField();
        jbutaosalvar = new javax.swing.JButton();
        jbutaonovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRO DE USUÁRIO");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Usuário"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("NOME DO USÁRIO");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("LOGIN");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("E-MAIL");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("SENHA");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("CONFIRMAÇÃO DA SENHA");

        jnome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jemail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jsenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jconfirmasenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jnome)
                    .addComponent(jlogin)
                    .addComponent(jemail)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jsenha)
                            .addComponent(jconfirmasenha, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
                        .addGap(0, 161, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addComponent(jconfirmasenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbutaosalvar.setIcon(new javax.swing.ImageIcon("D:\\Users\\brunn\\Documents\\GitHub\\ControleEstoque\\src\\imagens\\Salvar.png")); // NOI18N
        jbutaosalvar.setText("SALVAR");
        jbutaosalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutaosalvarActionPerformed(evt);
            }
        });

        jbutaonovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Add.png"))); // NOI18N
        jbutaonovo.setText("NOVO");
        jbutaonovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutaonovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbutaonovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbutaosalvar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbutaosalvar)
                    .addComponent(jbutaonovo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbutaosalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutaosalvarActionPerformed
        this.salvar();
    }//GEN-LAST:event_jbutaosalvarActionPerformed

    private void jbutaonovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutaonovoActionPerformed
        this.novo();
    }//GEN-LAST:event_jbutaonovoActionPerformed
    
    private void salvar(){
        
        String senha = String.valueOf(jsenha.getPassword());
        String confirma = String.valueOf(jconfirmasenha.getPassword());
        
        if(!senha.isEmpty() && !jnome.getText().isEmpty() && !jlogin.getText().isEmpty() && !jemail.getText().isEmpty()){
            if(senha.equals(confirma)){
                if(usuario == null){
                    usuario = new Usuario();
                    usuario.setNome(jnome.getText());
                    usuario.setLogin(jlogin.getText());
                    usuario.setEmail(jemail.getText());
                    usuario.setSenha(Criptografia.getCriptografia().HashSHA512(senha));
                    usuario.setStatus(1);
                    Banco.getBanco().cadastrar(usuario);
                    jbutaosalvar.setEnabled(false);
                    jbutaonovo.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
                }else{
                    usuario.setNome(jnome.getText());
                    usuario.setLogin(jlogin.getText());
                    usuario.setEmail(jemail.getText());
                    usuario.setSenha(Criptografia.getCriptografia().HashSHA512(senha));
                    usuario.setStatus(1);
                    Banco.getBanco().editarUsuario(usuario);
                    JOptionPane.showMessageDialog(null, "Usuario modificado com sucesso!");
                    this.dispose();
                }

            }else{
                JOptionPane.showMessageDialog(null, "Repita a senha no campo 'CONFIRMAÇÃO DA SENHA'!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Digite todas as informações de usuários!");
        }
    }
    
    private void novo(){
        jnome.setText("");
        jlogin.setText("");
        jemail.setText("");
        jsenha.setText("");
        jconfirmasenha.setText("");
        jnome.requestFocus();
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbutaonovo;
    private javax.swing.JButton jbutaosalvar;
    private javax.swing.JPasswordField jconfirmasenha;
    private javax.swing.JTextField jemail;
    private javax.swing.JTextField jlogin;
    private javax.swing.JTextField jnome;
    private javax.swing.JPasswordField jsenha;
    // End of variables declaration//GEN-END:variables
}
