/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import entidades.Venda;
import java.awt.event.KeyEvent;

/**
 *
 * @author brunn
 */
public class JanelaConcluir extends javax.swing.JDialog {
    private Venda venda;
    /**
     * Creates new form JanelaConcluir
     */
    public JanelaConcluir(java.awt.Frame parent, boolean modal, Venda venda) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.venda = venda;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jvalorpago = new javax.swing.JTextField();
        jpagamento = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jtroco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jbutao = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(380, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Total da Venda");

        jtotal.setEditable(false);
        jtotal.setBackground(new java.awt.Color(255, 255, 255));
        jtotal.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Valor Pago");

        jvalorpago.setBackground(new java.awt.Color(255, 255, 255));
        jvalorpago.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jvalorpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jvalorpagoActionPerformed(evt);
            }
        });
        jvalorpago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jvalorpagoKeyPressed(evt);
            }
        });

        jpagamento.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jpagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dinheiro", "Cartão", "Pendente" }));
        jpagamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jpagamentoItemStateChanged(evt);
            }
        });
        jpagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpagamentoMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Forma de Pagamento");

        jtroco.setEditable(false);
        jtroco.setBackground(new java.awt.Color(255, 255, 255));
        jtroco.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Troco");

        jbutao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jbutao.setText("OK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                    .addComponent(jtotal)
                    .addComponent(jvalorpago)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jtroco)
                    .addComponent(jpagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jbutao)
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jvalorpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbutao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpagamentoMouseClicked
        //jvalorpago.requestFocus();
    }//GEN-LAST:event_jpagamentoMouseClicked

    private void jvalorpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jvalorpagoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jvalorpagoActionPerformed

    private void jpagamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jpagamentoItemStateChanged
        // TODO add your handling code here:
        int selecionado = jpagamento.getSelectedIndex();
        if(selecionado == 0){
            jvalorpago.setText("");
            if(!jvalorpago.isEnabled()){
                jvalorpago.setEnabled(true);
            }
        }
        if(selecionado == 1){
            jvalorpago.setText("R$ "+this.venda.getTotal());
            if(!jvalorpago.isEnabled()){
                jvalorpago.setEnabled(true);
            }
        }
        if(selecionado == 2){
            jvalorpago.setEnabled(false);
            jvalorpago.setText("0");
        }
    }//GEN-LAST:event_jpagamentoItemStateChanged

    private void jvalorpagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jvalorpagoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            double digitado = Double.parseDouble(jvalorpago.getText());
        }
    }//GEN-LAST:event_jvalorpagoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbutao;
    private javax.swing.JComboBox jpagamento;
    private javax.swing.JTextField jtotal;
    private javax.swing.JTextField jtroco;
    private javax.swing.JTextField jvalorpago;
    // End of variables declaration//GEN-END:variables
}
