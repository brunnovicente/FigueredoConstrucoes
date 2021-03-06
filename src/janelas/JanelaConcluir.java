/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import entidades.Item;
import entidades.Venda;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import persistencia.Banco;

/**
 *
 * @author brunn
 */
public class JanelaConcluir extends javax.swing.JDialog {
    private Venda venda;
    private DecimalFormat formato = new DecimalFormat("R$ ###,##0.00");
    /**
     * Creates new form JanelaConcluir
     */
    public JanelaConcluir(java.awt.Frame parent, boolean modal, Venda venda) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.venda = venda;
        jtotal.setText(formato.format(this.venda.getTotal()));
        jvalorpago.requestFocus();
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
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jvalorpago = new javax.swing.JTextField();
        jpagamento = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jbutao = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtroco = new javax.swing.JTextField();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(380, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Finalizar Venda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Total da Venda");

        jtotal.setEditable(false);
        jtotal.setBackground(new java.awt.Color(255, 255, 255));
        jtotal.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Valor Pago");

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
        jpagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dinheiro", "Cartão" }));
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

        jbutao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jbutao.setText("OK");
        jbutao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutaoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Troco");

        jtroco.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jtroco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtrocoActionPerformed(evt);
            }
        });
        jtroco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtrocoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jbutao)
                .addContainerGap(136, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(jtotal)
                    .addComponent(jvalorpago)
                    .addComponent(jpagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtroco)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbutao)
                .addContainerGap())
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
            jvalorpago.requestFocus();
        }
        if(selecionado == 1){
            jvalorpago.setText("R$ "+this.venda.getTotal());
            if(!jvalorpago.isEnabled()){
                jvalorpago.setEnabled(true);
            }
            jtroco.setText("R$ 0");
        }
        if(selecionado == 2){
            jvalorpago.setEnabled(false);
            jvalorpago.setText("R$ 0");
            jtroco.setText("R$ 0");
        }
    }//GEN-LAST:event_jpagamentoItemStateChanged

    private void jvalorpagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jvalorpagoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            double digitado = Double.parseDouble(jvalorpago.getText().replace(",", "."));
            jtroco.setText(formato.format(digitado - this.venda.getTotal()));
        }
    }//GEN-LAST:event_jvalorpagoKeyPressed

    private void jbutaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutaoActionPerformed
        this.finalizarVenda();
    }//GEN-LAST:event_jbutaoActionPerformed

    private void jtrocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtrocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtrocoActionPerformed

    private void jtrocoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtrocoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtrocoKeyPressed

    
    private void finalizarVenda(){
        int selecionado = jpagamento.getSelectedIndex();
        this.venda.setStatus(Venda.ATIVO);
        if(selecionado < 2){
            if(selecionado == 0){
                this.venda.setPagamento(Venda.dinheiro);
            }else{
                this.venda.setPagamento(Venda.cartao);
            }
        }else{
            this.venda.setPagamento(Venda.pendente);
        }
        
        Banco.getBanco().cadastrar(this.venda);
        for(Item i : this.venda.getItens()){
            try {
                Banco.getBanco().editarProduto(i.getProduto());
            } catch (Exception ex) {
                Logger.getLogger(JanelaConcluir.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JOptionPane.showMessageDialog(null, "Venda finalizada com sucesso!", "Vender", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbutao;
    private javax.swing.JComboBox jpagamento;
    private javax.swing.JTextField jtotal;
    private javax.swing.JTextField jtroco;
    private javax.swing.JTextField jvalorpago;
    // End of variables declaration//GEN-END:variables
}
