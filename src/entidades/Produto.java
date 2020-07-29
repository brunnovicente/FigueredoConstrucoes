/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author brunn
 */
@Entity
@Table(name="produtos")
public class Produto {
    
    public static final int ATIVO = 1;
    public static final int DESATIVADO = 0;
    
    @Id
    @GeneratedValue
    private int id;
    
    @Column(unique=true)
    private String codigobarra;
    private String descricao;
    private double preco;
    private double minimo;
    private double estoque;
    private int status;
    
    //@ManyToMany
    //@JoinTable(name="produto_fornecedor", joinColumns = {@JoinColumn(name="produto_id")}, inverseJoinColumns = {@JoinColumn(name="fornecedor_id")})
    @OneToMany(cascade = (CascadeType.ALL), fetch = FetchType.EAGER)
    @JoinColumn(name = "produto")
    private List<Produto_fornecedor> fornecedor;
    
    public static int getATIVO() {
        return ATIVO;
    }

    public static int getDESATIVADO() {
        return DESATIVADO;
    }

    public int getId() {
        return id;
    }

    public String getCodigobarras() {
        return codigobarra;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }
    
    public double getMinimo() {
        return minimo;
    }

    public double getEstoque() {
        return estoque;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodigobarras(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
       
    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Produto_fornecedor> getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(List<Produto_fornecedor> fornecedor) {
        this.fornecedor = fornecedor;
    }

}
