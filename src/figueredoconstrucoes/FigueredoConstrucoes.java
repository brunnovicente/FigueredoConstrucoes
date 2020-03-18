/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figueredoconstrucoes;

import entidades.Fornecedor;
import entidades.Item;
import entidades.Produto;
import entidades.Venda;
import janelas.TelaLogin;
import java.text.DecimalFormat;
import java.util.Date;
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
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        TelaLogin telalogin = new TelaLogin();
        telalogin.setVisible(true);
        //DecimalFormat doisDigitos = new DecimalFormat("R$ ###,##0.00");
        //System.out.println(doisDigitos.format(0.5));
        /*
        boolean login = Banco.getBanco().fazerLogin("admin", "admin");
        
        Produto p1 = Banco.getBanco().consultaProdutoCodigo("82389742");
        Produto p2 = Banco.getBanco().consultaProdutoCodigo("9238490823");
        Produto p3 = Banco.getBanco().consultaProdutoCodigo("90832789");
        
        Venda venda = new Venda();
        
        Item item1 = new Item();
        item1.setProduto(p1);
        item1.setQuantidade(2);
        item1.setTotal(item1.getQuantidade() * p1.getPreco());
        item1.setVenda(venda);
        venda.getItens().add(item1);
        venda.setTotal(venda.getTotal() + item1.getTotal());
        
        Item item2 = new Item();
        item2.setProduto(p2);
        item2.setQuantidade(3);
        item2.setTotal(item2.getQuantidade() * p2.getPreco());
        item2.setVenda(venda);
        venda.getItens().add(item2);
        venda.setTotal(venda.getTotal() + item2.getTotal());
        
        Item item3 = new Item();
        item3.setProduto(p3);
        item3.setQuantidade(2);
        item3.setTotal(item2.getQuantidade() * p3.getPreco());
        item3.setVenda(venda);
        venda.getItens().add(item3);
        venda.setTotal(venda.getTotal() + item3.getTotal());
        
        venda.setStatus(Venda.ATIVO);
        venda.setData(new Date());
        
        venda.setUsuario(Banco.getUsuarioLogado());
        venda.setCliente(Banco.getCliente());
        
        Banco.getBanco().cadastrar(venda);
        */
    }
    
    
    
}
