/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Produto;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persistencia.Banco;

/**
 *
 * @author brunn_000
 */
public class ProcessoProduto extends Thread {

    private JTable tabela;
    private List<Produto> produtos;
    private String chave;
    private List<Produto> lista;
    private boolean viva;
   
    public ProcessoProduto(JTable tabela, String chave, List<Produto> lista) {
        this.tabela = tabela;
        this.chave = chave;
        this.lista = lista;
    }

    
    @Override
    public void run() {
        this.viva = true;
        this.produtos = Banco.getBanco().consultaProduto(this.chave);
        this.preencherTabela();
        this.viva = false;
        
    }//Fim do Run
    
    public void preencherTabela(){
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        for (Produto produto : this.produtos){
            //DecimalFormat df = new DecimalFormat("#,###.00");
            DecimalFormat df = new DecimalFormat("R$ ###,##0.00");
            String[] linha = new String[4];
            linha[0] = produto.getDescricao();
            linha[1] = df.format(produto.getPreco());
            linha[2] = produto.getEstoque()+"";

            modelo.addRow(linha);
            this.lista.add(produto);
            }
    }//Fim Busca CHave
    
    
    public boolean taViva(){
        return viva;
    }        
    

}
