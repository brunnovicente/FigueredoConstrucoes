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
    private String codigoBarra;
    private String descricao;
    private double preco;
    private double minimo;
    private double estoque;
    private int status;
    @Column(name = "foto", unique = false, nullable = true, length = 1000000)
    private byte[] foto;    
    
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
        return codigoBarra;
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
        this.codigoBarra = codigobarra;
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

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    

}
