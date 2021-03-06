/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import entidades.Entrada;
import entidades.Fornecedor;
import entidades.Item;
import entidades.Produto;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import persistencia.Banco;

/**
 *
 * @author brunn
 */
public class JanelaEntrada extends javax.swing.JDialog {

    /**
     * Creates new form JanelaEntrada
     */
    private DecimalFormat formato = new DecimalFormat("R$ ###,##0.00");
    private Produto produto = null;
    private java.awt.Frame pai;
    private Fornecedor fornecedor = null;
    
    public JanelaEntrada(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);        
        this.pai = parent;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        jdata.setText(sdf.format(new Date()));
        jcodigobarra.requestFocus();
    }
    
    private void buscarProduto(){
        this.produto = new Produto();
        ConsultaProdutos janela = new ConsultaProdutos(pai, true, produto, jcodigobarra.getText());
        janela.setVisible(true);
        if(this.produto.getId() > 0){
            jdescricao.setText(produto.getDescricao());
            jestoque.setText(produto.getEstoque()+"");
            jminimo.setText(produto.getMinimo()+"");
            jpreco_atual.setText(formato.format(produto.getPreco()));
            
            if(produto != null){
                jfornecedor.requestFocus();
            }
        }
    }//Fim Buscar Produto
    
    private void buscarProdutoPorCodigo(){
        produto = Banco.getBanco().consultaProdutoCodigo(jcodigobarra.getText());
        //jestoque.setText(produto.getEstoque()+"");
        //jpreco.setText(formato.format(produto.getPreco()));
        jdescricao.setText(produto.getDescricao());
        jestoque.setText(produto.getEstoque()+"");
        jminimo.setText(produto.getMinimo()+"");
        jpreco_atual.setText(formato.format(produto.getPreco()));
        this.fornecedor = new Fornecedor();
        
        if(produto != null){
            jfornecedor.requestFocus();
        }
    }
    
    private void buscaFornecedor(){
        
        ConsultaFornecedor janela = new ConsultaFornecedor(pai, true, this.fornecedor);
        janela.setVisible(true);
        
        if(this.fornecedor.getId() > 0){
            this.jfornecedor.setText(this.fornecedor.getRazao());
            this.jquantidade.requestFocus();
        }
        
    }
    
    private void novo(){
        this.produto = null;
        this.fornecedor = null;
        
        jcodigobarra.setText("");
        jfornecedor.setText("");
        jdescricao.setText("");
        jestoque.setText("");
        jminimo.setText("");
        jquantidade.setText("");
        jpreco.setText("");
        jpreco_novo.setText("");
        jpreco_atual.setText("");
        
        jcodigobarra.requestFocus();
        
    }
    
    private void salvar(){
         Entrada entrada = new Entrada();
        
        this.produto.setPreco(Double.parseDouble(jpreco_novo.getText().replace(",", ".")));
        this.produto.setEstoque(this.produto.getEstoque() + Double.parseDouble(jquantidade.getText().replace(",", ".")));
        
        try {
            Banco.getBanco().editarProduto(this.produto);
            entrada.setData(new Date());
            entrada.setFornecedor(this.fornecedor);
            entrada.setProduto(this.produto);
            entrada.setQuantidade(Double.parseDouble(jquantidade.getText()));
            entrada.setPreco_compra(Double.parseDouble(jpreco.getText()));
            entrada.setUsuario(Banco.getUsuarioLogado());
            
            Banco.getBanco().cadastrar(entrada);
            JOptionPane.showMessageDialog(null, "Entrada cadastrada com sucesso!");
            this.novo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
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

        jPanel3 = new javax.swing.JPanel();
        jtexto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jcodigobarra = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jfornecedor = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jquantidade = new javax.swing.JTextField();
        jpreco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jdescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jestoque = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jminimo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jdata = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jpreco_atual = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jpreco_novo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 0, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 50));

        jtexto.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jtexto.setForeground(new java.awt.Color(255, 255, 255));
        jtexto.setText("Entrada de Produto");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jtexto)
                .addContainerGap(255, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jtexto)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Entrada"));

        jcodigobarra.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jcodigobarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcodigobarraActionPerformed(evt);
            }
        });
        jcodigobarra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcodigobarraKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Código de Barra do Produto");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisa2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Fornecedor");

        jfornecedor.setEditable(false);
        jfornecedor.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jfornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfornecedorActionPerformed(evt);
            }
        });
        jfornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jfornecedorKeyPressed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisa2.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Quantidade");

        jquantidade.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jquantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jquantidadeActionPerformed(evt);
            }
        });
        jquantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jquantidadeKeyPressed(evt);
            }
        });

        jpreco.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jpreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jprecoActionPerformed(evt);
            }
        });
        jpreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jprecoKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Preço Compra");

        jdescricao.setEditable(false);
        jdescricao.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jdescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdescricaoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Descrição");

        jestoque.setEditable(false);
        jestoque.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jestoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jestoqueActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Estoque Atual");

        jminimo.setEditable(false);
        jminimo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jminimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jminimoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Estoque Mínimo");

        jdata.setEditable(false);
        jdata.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdataActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Data");

        jpreco_atual.setEditable(false);
        jpreco_atual.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jpreco_atual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpreco_atualActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Preço Atual");

        jpreco_novo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jpreco_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpreco_novoActionPerformed(evt);
            }
        });
        jpreco_novo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpreco_novoKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Preço Novo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcodigobarra))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jfornecedor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jdescricao)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jestoque, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jminimo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jpreco_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jdata, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jquantidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(jpreco))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jpreco_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jfornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcodigobarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jestoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jminimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpreco_atual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jpreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpreco_novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Salvar.png"))); // NOI18N
        jButton3.setText("SALVAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcodigobarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcodigobarraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcodigobarraActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.buscarProduto();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jfornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jfornecedorActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.buscaFornecedor();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jquantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jquantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jquantidadeActionPerformed

    private void jprecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jprecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jprecoActionPerformed

    private void jdescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdescricaoActionPerformed

    private void jestoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jestoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jestoqueActionPerformed

    private void jdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdataActionPerformed

    private void jcodigobarraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcodigobarraKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.buscarProdutoPorCodigo();
        }else if(evt.getKeyCode() == KeyEvent.VK_F3){
            this.buscarProduto();
        }
    }//GEN-LAST:event_jcodigobarraKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       this.salvar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jpreco_atualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpreco_atualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpreco_atualActionPerformed

    private void jpreco_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpreco_novoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpreco_novoActionPerformed

    private void jminimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jminimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jminimoActionPerformed

    private void jquantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jquantidadeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jpreco.requestFocus();
        }
    }//GEN-LAST:event_jquantidadeKeyPressed

    private void jprecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jprecoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jpreco_novo.requestFocus();
        }
    }//GEN-LAST:event_jprecoKeyPressed

    private void jpreco_novoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpreco_novoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.salvar();
        }
    }//GEN-LAST:event_jpreco_novoKeyPressed

    private void jfornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jfornecedorKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_F3){
            this.buscaFornecedor();
        }
    }//GEN-LAST:event_jfornecedorKeyPressed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jcodigobarra;
    private javax.swing.JTextField jdata;
    private javax.swing.JTextField jdescricao;
    private javax.swing.JTextField jestoque;
    private javax.swing.JTextField jfornecedor;
    private javax.swing.JTextField jminimo;
    private javax.swing.JTextField jpreco;
    private javax.swing.JTextField jpreco_atual;
    private javax.swing.JTextField jpreco_novo;
    private javax.swing.JTextField jquantidade;
    private javax.swing.JLabel jtexto;
    // End of variables declaration//GEN-END:variables
}
