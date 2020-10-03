/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author brunn
 */
@Entity
@Table(name="entradas")
public class Entrada {
    
    @Id
    @GeneratedValue
    private int id;
    
    private double quantidade;
    private Date data;
    private double preco_compra;
    
    @ManyToOne 
    @JoinColumn(name = "produto_id")
    private Produto produto;
    
    @ManyToOne 
    @JoinColumn(name = "user_id")
    private User usuario;
    
    @ManyToOne 
    @JoinColumn(name = "fornecedore_id")
    private Fornecedor fornecedor;
    
    public int getId() {
        return id;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public Date getData() {
        return data;
    }

    public double getPreco_compra() {
        return preco_compra;
    }

    public Produto getProduto() {
        return produto;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setPreco_compra(double preco_compra) {
        this.preco_compra = preco_compra;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

}
