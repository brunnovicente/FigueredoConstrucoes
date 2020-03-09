/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import entidades.Fornecedor;
import entidades.Produto;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.Banco;
import persistencia.ProcessoFornecedor;

/**
 *
 * @author brunn
 */
public class ConsultaFornecedor extends javax.swing.JDialog {
    
    private List<Fornecedor> lista;
    private JFrame pai;
    
    /**
     * Creates new form ConsultaFornecedor
     */
    public ConsultaFornecedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.pai = (JFrame) parent;
        this.buscarFornecedor();
        this.jchave.requestFocus();
    }
    
    private void buscarFornecedor(){
        this.limparTabela();
        this.lista = new ArrayList<>();
        ProcessoFornecedor busca = new ProcessoFornecedor(jtabela,jchave.getText(), this.lista);
        busca.start();
        this.jchave.requestFocus();
    }
     
    private void editar(){
         int item = jtabela.getSelectedRow();
         //CadastroProduto janela = new CadastroProduto(this.pai, true, this.lista.get(item));
         //janela.setVisible(true);
     }//Fim do ver
    
    private void excluir(){
        int v = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse Fornecedor?", "EXCLUIR FORNECEDOR", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(v == JOptionPane.YES_OPTION){
            int item = jtabela.getSelectedRow();
            Fornecedor p = this.lista.get(item);
            p.setStatus(Fornecedor.DESATIVADO);
            Banco.getBanco().editarFornecedor(p);
            this.buscarFornecedor();
        }
    }
    
          
    private void limparTabela(){
        DefaultTableModel model = (DefaultTableModel) jtabela.getModel();
        //Limpa a tabela antes de adicionar os novos dados
        int tam = model.getRowCount();
        for(int i=0;i<tam;i++){
            model.removeRow(0);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jchave = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Busca"));

        jtabela.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jtabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNPJ", "RAZÃO SOCIAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtabela.setRowHeight(40);
        jtabela.getTableHeader().setReorderingAllowed(false);
        jtabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtabelaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtabela);
        if (jtabela.getColumnModel().getColumnCount() > 0) {
            jtabela.getColumnModel().getColumn(0).setResizable(false);
            jtabela.getColumnModel().getColumn(0).setPreferredWidth(100);
            jtabela.getColumnModel().getColumn(1).setResizable(false);
            jtabela.getColumnModel().getColumn(1).setPreferredWidth(600);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Buscar");

        jchave.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jchave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jchaveKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisa2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1082, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jchave)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jchave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Add.png"))); // NOI18N
        jButton2.setText("NOVO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Lixeira2.png"))); // NOI18N
        jButton3.setText("EXCLUIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Editar2.png"))); // NOI18N
        jButton4.setText("EDITAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));
        jPanel2.setForeground(new java.awt.Color(0, 0, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(623, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gerência de Fornecedores");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(344, 344, 344))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 11, Short.MAX_VALUE))
        );

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
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1114, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.buscarFornecedor();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CadastroFornecedor cadastrofornecedor = new CadastroFornecedor(pai, true);
        cadastrofornecedor.setVisible(true);
        this.buscarFornecedor();
        jchave.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.excluir();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtabelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtabelaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            VisualizaFornecedor visualiza = new VisualizaFornecedor(pai, true, this.lista.get(jtabela.getSelectedRow()));
            visualiza.setVisible(true);
        }
        if(evt.getKeyCode() == KeyEvent.VK_DELETE){
            this.excluir();
        }
    }//GEN-LAST:event_jtabelaKeyPressed

    private void jchaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jchaveKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.buscarFornecedor();
        }
        if(evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP){
            this.jtabela.requestFocus();
        }
        
    }//GEN-LAST:event_jchaveKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Fornecedor fornecedor = this.lista.get(jtabela.getSelectedRow());
        CadastroFornecedor cadastrofornecedor = new CadastroFornecedor(this.pai, true, fornecedor);
        cadastrofornecedor.setVisible(true);
        this.buscarFornecedor();
    }//GEN-LAST:event_jButton4ActionPerformed

 
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jchave;
    private javax.swing.JTable jtabela;
    // End of variables declaration//GEN-END:variables
}
