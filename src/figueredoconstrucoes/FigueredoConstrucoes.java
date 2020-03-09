/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figueredoconstrucoes;

import entidades.Fornecedor;
import janelas.TelaLogin;
import java.text.DecimalFormat;
import java.util.List;
import persistencia.Banco;
import persistencia.Criptografia;

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
        TelaLogin telalogin = new TelaLogin();
        telalogin.setVisible(true);
        //DecimalFormat doisDigitos = new DecimalFormat("R$ ###,##0.00");
        //System.out.println(doisDigitos.format(0.5));
        
    }
    
    
    
}
