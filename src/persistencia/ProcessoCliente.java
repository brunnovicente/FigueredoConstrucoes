/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Cliente;
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
public class ProcessoCliente extends Thread {

    private JTable tabela;
    private List<Cliente> clientes;
    private String chave;
    private List<Cliente> lista;
   
    public ProcessoCliente(JTable tabela, String chave, List<Cliente> lista) {
        this.tabela = tabela;
        this.chave = chave;
        this.lista = lista;
    }

    
    @Override
    public void run() {
        this.clientes = Banco.getBanco().consultaCliente(this.chave);
        this.preencherTabela();
        
    }//Fim do Run
    
    public void preencherTabela(){
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        for (Cliente cliente : this.clientes){
            //DecimalFormat df = new DecimalFormat("#,###.00");
            //DecimalFormat df = new DecimalFormat("R$ ###,##0.00");
            String[] linha = new String[4];
            linha[0] = cliente.getNome();
            linha[1] = cliente.getTelefone1();
            linha[2] = cliente.getTelefone2();
            linha[3] = cliente.getEmail();

            modelo.addRow(linha);
            this.lista.add(cliente);
            }
    }//Fim Busca CHave
    
    
            
    

}
