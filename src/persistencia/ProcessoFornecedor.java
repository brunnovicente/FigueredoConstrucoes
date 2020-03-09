/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Fornecedor;
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
public class ProcessoFornecedor extends Thread {

    private JTable tabela;
    private List<Fornecedor> fornecedores;
    private String chave;
    private List<Fornecedor> lista;
   
    public ProcessoFornecedor(JTable tabela, String chave, List<Fornecedor> lista) {
        this.tabela = tabela;
        this.chave = chave;
        this.lista = lista;
    }

    
    @Override
    public void run() {
        this.fornecedores = Banco.getBanco().consultaFornecedor(this.chave);
        this.preencherTabela();
        
    }//Fim do Run
    
    public void preencherTabela(){
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        for (Fornecedor fornecedor : this.fornecedores){
            //DecimalFormat df = new DecimalFormat("#,###.00");
            String[] linha = new String[3];
            linha[0] = fornecedor.getId()+"";
            linha[1] = fornecedor.getCnpj();
            linha[2] = fornecedor.getRazao();
            //linha[3] = fornecedor.getEndereco();
            //linha[4] = fornecedor.getTelefone1();
            //linha[5] = fornecedor.getTelefone2();

            modelo.addRow(linha);
            this.lista.add(fornecedor);
            }
    }//Fim Busca CHave
    
    
            
    

}
