/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author brunn
 */
@Entity
@Table(name="vendas")
public class Venda {
    
    public static final int ATIVO = 1;
    public static final int DESATIVADO = 0;
    
    @Id
    @GeneratedValue
    private int id;
    
    private Date data;
    private double total;
    private int status;
    
    @ManyToOne 
    @JoinColumn(name = "cliente")
    private Cliente cliente;
    
    @ManyToOne 
    @JoinColumn(name = "usuario")
    private Usuario usuario;
    
    @OneToMany(cascade = (CascadeType.ALL), fetch = FetchType.EAGER)
    @JoinColumn(name = "venda")
    private List<Item> itens;
    
    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public double getTotal() {
        return total;
    }

    public int getStatus() {
        return status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
        
}
