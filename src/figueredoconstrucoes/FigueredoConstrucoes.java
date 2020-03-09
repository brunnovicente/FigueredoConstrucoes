/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figueredoconstrucoes;

import entidades.Fornecedor;
import janelas.TelaLogin;
import java.util.List;
import persistencia.Banco;

/**
 *
 * @author brunn
 */
public class FigueredoConstrucoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //TelaLogin telalogin = new TelaLogin();
        //telalogin.setVisible(true);
        
        List<Fornecedor> fornecedor = Banco.getBanco().consultaFornecedor("");
        for(Fornecedor f: fornecedor){
            System.out.println(f.getProdutos().size());
        }
        
    }
    
    
    
}
