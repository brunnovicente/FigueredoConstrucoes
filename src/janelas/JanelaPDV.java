/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import entidades.Cliente;
import entidades.Item;
import entidades.Produto;
import entidades.Usuario;
import entidades.Venda;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import persistencia.Banco;

/**
 *
 * @author brunn
 */
public class JanelaPDV extends javax.swing.JDialog {
    
    private DecimalFormat formato = new DecimalFormat("R$ ###,##0.00");
    private java.awt.Frame pai;
    private List<Produto> lista;
    private Produto produto = null;
    private Venda venda;
    private Cliente cliente;
    /**
     * Creates new form CadastroVenda
     */
    public JanelaPDV(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.pai = parent;
        jusuario.setText(Banco.getUsuarioLogado().getNome());
        jcliente.setText(Banco.getCliente().getNome());
        jdescricao.setHorizontalAlignment(JTextField.CENTER);
        jsubtotal.setHorizontalAlignment(JTextField.RIGHT);
        this.venda = new Venda();
        this.cliente = Banco.getCliente();
        venda.setUsuario(Banco.getUsuarioLogado());
        venda.setCliente(this.cliente);
        
        this.lista = new ArrayList();
        jcodigo.requestFocus();
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
        jdescricao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabela = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jcodigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jquantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jpreco = new javax.swing.JTextField();
        jestoque = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jsubtotal = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jusuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcliente = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Caixa Aberto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(432, 432, 432))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jdescricao.setEditable(false);
        jdescricao.setBackground(new java.awt.Color(255, 255, 255));
        jdescricao.setFont(new java.awt.Font("Tahoma", 0, 42)); // NOI18N

        jtabela.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIÇÃO", "PREÇO", "QTD", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtabela.setRowHeight(28);
        jtabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtabela);
        if (jtabela.getColumnModel().getColumnCount() > 0) {
            jtabela.getColumnModel().getColumn(0).setResizable(false);
            jtabela.getColumnModel().getColumn(0).setPreferredWidth(300);
            jtabela.getColumnModel().getColumn(1).setResizable(false);
            jtabela.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtabela.getColumnModel().getColumn(2).setResizable(false);
            jtabela.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtabela.getColumnModel().getColumn(3).setResizable(false);
            jtabela.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Código de Barras");

        jcodigo.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcodigoKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisa2.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Quantidade");

        jquantidade.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jquantidade.setText("1");
        jquantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jquantidadeKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Preço Unitário");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Estoque");

        jpreco.setEditable(false);
        jpreco.setBackground(new java.awt.Color(255, 255, 255));
        jpreco.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N

        jestoque.setEditable(false);
        jestoque.setBackground(new java.awt.Color(255, 255, 255));
        jestoque.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Subtotal");

        jsubtotal.setEditable(false);
        jsubtotal.setBackground(new java.awt.Color(0, 0, 204));
        jsubtotal.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jsubtotal.setForeground(new java.awt.Color(255, 255, 255));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Salvar.png"))); // NOI18N
        jButton3.setText("SALVAR");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jButton4.setText("CONCLUIR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente e Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Usuário");

        jusuario.setEditable(false);
        jusuario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Cliente");

        jcliente.setEditable(false);
        jcliente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisa2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(jButton2))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Add.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jquantidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                                    .addComponent(jcodigo, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jpreco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jestoque, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jdescricao)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(238, 238, 238)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(375, 375, 375)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jsubtotal))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jpreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jestoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcodigoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.buscarProduto();
        }
        if(evt.getKeyCode() == KeyEvent.VK_F12){
            this.concluirVenda();
        }
    }//GEN-LAST:event_jcodigoKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.adicionarItemNaVenda();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jquantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jquantidadeKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.adicionarItemNaVenda();
        }
    }//GEN-LAST:event_jquantidadeKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.concluirVenda();
    }//GEN-LAST:event_jButton4ActionPerformed
    
    private void buscarProduto(){
        produto = Banco.getBanco().consultaProdutoCodigo(jcodigo.getText());
        jestoque.setText(produto.getEstoque()+"");
        jpreco.setText(formato.format(produto.getPreco()));
        jdescricao.setText(produto.getDescricao());
        if(produto != null){
            jquantidade.requestFocus();
        }
    }
    
    private void adicionarItemNaVenda(){
        Item item = new Item();
        double estoque = Double.parseDouble(jquantidade.getText());
        if(estoque <= this.produto.getEstoque()){
            item.setProduto(this.produto);
            item.setVenda(this.venda);
            item.setQuantidade(Double.parseDouble(jquantidade.getText()));
            item.setTotal(item.getQuantidade() * produto.getPreco());
            item.getProduto().setEstoque(item.getProduto().getEstoque() - item.getQuantidade());
            venda.getItens().add(item);
            venda.setTotal(this.venda.getTotal()+item.getTotal());

            jdescricao.setText("");
            jquantidade.setText("1");
            jpreco.setText("");
            jestoque.setText("");
            jcodigo.setText("");

            jsubtotal.setText(formato.format(venda.getTotal()));
            this.adicionarItemTabela(item);
            this.produto = null;
            this.cliente = Banco.getCliente();
            jcodigo.requestFocus();
        }else{
            JOptionPane.showMessageDialog(null, "A quantidade não pode ser maior que o estoque disponível!","Estoque", JOptionPane.WARNING_MESSAGE);
        }
    }
   
    
    private void adicionarItemTabela(Item item){

        DefaultTableModel modelo = (DefaultTableModel) jtabela.getModel();
        String[] linha = new String[4];
        linha[0] = item.getProduto().getDescricao();
        linha[1] = formato.format(item.getProduto().getPreco());
        linha[2] = "" + item.getQuantidade();
        linha[3] = formato.format(item.getTotal());
        modelo.addRow(linha);
   
    }
    
    /*
    private void concluirVenda(){
        this.venda.setData(new Date());
        this.venda.setStatus(Venda.ATIVO);
        Banco.getBanco().cadastrar(this.venda);
        for(Item item : this.venda.getItens()){
            try {
                Banco.getBanco().editarProduto(item.getProduto());
            } catch (Exception ex) {
                Logger.getLogger(JanelaPDV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JOptionPane.showMessageDialog(null, "Venda concluída com sucesso!");
        this.limparTabela();
        this.venda = new Venda();
        this.venda = new Venda();
        venda.setUsuario(Banco.getUsuarioLogado());
        venda.setCliente(this.cliente);
        this.lista = new ArrayList();
        this.cliente = Banco.getCliente();
        jcodigo.requestFocus();
    }
    */
    
    private void concluirVenda(){
        this.venda.setData(new Date());
        this.venda.setStatus(Venda.ATIVO);
        JanelaConcluir janela = new JanelaConcluir(this.pai, true, this.venda);
        janela.setVisible(true);
        this.limparTabela();
        this.venda = new Venda();
        venda.setUsuario(Banco.getUsuarioLogado());
        venda.setCliente(this.cliente);
        this.lista = new ArrayList();
        this.cliente = Banco.getCliente();
        jcodigo.requestFocus();
    }
    public void limparTabela(){
        DefaultTableModel modelo = (DefaultTableModel) jtabela.getModel();
        int tam = modelo.getRowCount();
        for(int i=0;i<tam;i++){
            modelo.removeRow(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jcliente;
    private javax.swing.JTextField jcodigo;
    private javax.swing.JTextField jdescricao;
    private javax.swing.JTextField jestoque;
    private javax.swing.JTextField jpreco;
    private javax.swing.JTextField jquantidade;
    private javax.swing.JTextField jsubtotal;
    private javax.swing.JTable jtabela;
    private javax.swing.JTextField jusuario;
    // End of variables declaration//GEN-END:variables
}
