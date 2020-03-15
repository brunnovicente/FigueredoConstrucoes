/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;


import entidades.Cliente;
import entidades.Produto;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.Banco;
import persistencia.ProcessoCliente;

/**
 *
 * @author Bruno
 */
public class ConsultaCliente extends javax.swing.JDialog {
    
    private List<Cliente> lista;
    private JFrame pai;
    private Cliente cliente;
    /**
     * Creates new form JanelaConsultaProdutos
     * @param parent
     * @param modal
     */
    public ConsultaCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.pai = (JFrame) parent;
        //produto = new Produto();
        this.setLocationRelativeTo(null);

        //this.buscarProduto();
        this.jchave.requestFocus();
        //jbutaoExcluir.setVisible(false);
        jtabela.setAutoCreateRowSorter(true);
        this.buscarCliente();
        this.cliente = null;
       
    }
    
    public ConsultaCliente(java.awt.Frame parent, boolean modal, Cliente cliente) {
        super(parent, modal);
        initComponents();
        
        this.pai = (JFrame) parent;
        //produto = new Produto();
        this.setLocationRelativeTo(null);

        //this.buscarProduto();
        this.jchave.requestFocus();
        //jbutaoExcluir.setVisible(false);
        jtabela.setAutoCreateRowSorter(true);
        this.cliente = cliente;
        jbutaoEditar.setVisible(false);
        jbutaoExcluir.setVisible(false);
    }
       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabela = new javax.swing.JTable();
        jchave = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jbutaoEditar = new javax.swing.JButton();
        jbutaoExcluir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 720));
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados dos Clientes"));

        jtabela.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jtabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "TELEFONE 1", "TELEFONE 2", "E-MAIL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtabela.setRowHeight(40);
        jtabela.getTableHeader().setReorderingAllowed(false);
        jtabela.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtabelaFocusGained(evt);
            }
        });
        jtabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabelaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jtabelaMouseEntered(evt);
            }
        });
        jtabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtabelaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtabela);
        if (jtabela.getColumnModel().getColumnCount() > 0) {
            jtabela.getColumnModel().getColumn(0).setResizable(false);
            jtabela.getColumnModel().getColumn(0).setPreferredWidth(250);
            jtabela.getColumnModel().getColumn(1).setResizable(false);
            jtabela.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtabela.getColumnModel().getColumn(2).setResizable(false);
            jtabela.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtabela.getColumnModel().getColumn(3).setResizable(false);
            jtabela.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        jchave.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jchave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchaveActionPerformed(evt);
            }
        });
        jchave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jchaveKeyPressed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisa2.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Buscar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 966, Short.MAX_VALUE))
                            .addComponent(jchave))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jchave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbutaoEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Editar2.png"))); // NOI18N
        jbutaoEditar.setText("EDITAR");
        jbutaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutaoEditarActionPerformed(evt);
            }
        });

        jbutaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Lixeira2.png"))); // NOI18N
        jbutaoExcluir.setText("EXCLUIR");
        jbutaoExcluir.setToolTipText("");
        jbutaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutaoExcluirActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 0, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gerência de Clientes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(383, 383, 383)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1120, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbutaoEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbutaoExcluir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbutaoExcluir)
                    .addComponent(jbutaoEditar))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.buscarCliente();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jtabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabelaMouseClicked
        if(evt.getClickCount() == 2){
//            if(produto == null){
//                //if(!FachadaControle.getFachadaControle().getUsuarioLogado().getTipo().equals(Usuario.TIPO_VENDEDOR)){
//                    //this.editar();
//                this.ver();
//                //}
//            }else{
//                this.mandarProdutoPraVenda();
//            }
//        }else{
//            this.produtoSelecionado(this.jTabelaPesquisa.getSelectedRow());
        }
    }//GEN-LAST:event_jtabelaMouseClicked

    private void jtabelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtabelaKeyPressed
//        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
//            if(produto == null){
//                this.ver();
//            }else{
//                this.mandarProdutoPraVenda();
//            }
//        }if(evt.getKeyCode() == KeyEvent.VK_DOWN){
//            int sel = jTabelaPesquisa.getSelectedRow();
//            //if(sel >= 0){
//                this.produtoSelecionado(sel+1);
//            //}else{
//                //this.produtoSelecionado(0);
//            //}
//        }if(evt.getKeyCode() == KeyEvent.VK_UP){
//            int sel = jTabelaPesquisa.getSelectedRow();
//            this.produtoSelecionado(sel - 1);
//        }
        
        
    }//GEN-LAST:event_jtabelaKeyPressed

    private void jchaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jchaveKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.buscarCliente();
        }else if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN){
            jtabela.requestFocus();
        }/*else{
            this.buscarProduto();
        }*/
    }//GEN-LAST:event_jchaveKeyPressed

    private void jchaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchaveActionPerformed
        
    }//GEN-LAST:event_jchaveActionPerformed

    private void jbutaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutaoEditarActionPerformed
        this.editar();
        this.buscarCliente();
    }//GEN-LAST:event_jbutaoEditarActionPerformed

    private void jtabelaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtabelaFocusGained

    }//GEN-LAST:event_jtabelaFocusGained

    private void jtabelaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabelaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jtabelaMouseEntered

    private void jbutaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutaoExcluirActionPerformed
         int v = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este cliente?", "Excluir Cliente", JOptionPane.YES_NO_OPTION);
         if(v == 0){
            this.excluir();
            this.buscarCliente();
         }
    }//GEN-LAST:event_jbutaoExcluirActionPerformed
   
    private void buscarCliente(){
        this.limparTabelas();
        this.lista = new ArrayList<>();
        ProcessoCliente processo = new ProcessoCliente(jtabela, jchave.getText(), this.lista);
        processo.start();
        jchave.requestFocus();
    }
           
    private void editar(){
         int item = jtabela.getSelectedRow();
         CadastroCliente janela = new CadastroCliente(this.pai, true, this.lista.get(item));
         janela.setVisible(true);
     }//Fim do ver
    
    private void excluir(){
        int item = jtabela.getSelectedRow();
        Cliente c = this.lista.get(item);
        c.setStatus(Produto.DESATIVADO);
        Banco.getBanco().editarCliente(c);
    }
          
    private void limparTabelas(){
        DefaultTableModel model = (DefaultTableModel) jtabela.getModel();
        //Limpa a tabela antes de adicionar os novos dados
        int tam = model.getRowCount();
        for(int i=0;i<tam;i++){
            model.removeRow(0);
        }
    }
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /*
//         * Set the Nimbus look and feel
//         */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /*
//         * If Nimbus (introduced in Java SE 6) is not available, stay with the
//         * default look and feel. For details see
//         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JanelaConsultaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JanelaConsultaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JanelaConsultaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JanelaConsultaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /*
//         * Create and display the dialog
//         */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                JanelaConsultaProdutos dialog = new JanelaConsultaProdutos(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbutaoEditar;
    private javax.swing.JButton jbutaoExcluir;
    private javax.swing.JTextField jchave;
    private javax.swing.JTable jtabela;
    // End of variables declaration//GEN-END:variables
}
