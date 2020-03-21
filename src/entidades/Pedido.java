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
@Table(name="pedidos")
public class Pedido {
    
    public static final int PENDENTE = 0;
    public static final int ENTREGUE = 1;
    
    @Id
    @GeneratedValue
    private int id;
    
    private Date dataPedido;
    private Date dataEntrega;
    private double quantidade;
    private int status;
    
    @ManyToOne 
    @JoinColumn(name = "produto")
    private Produto produto;

    public int getId() {
        return id;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public int getStatus() {
        return status;
    }

    public Produto getProduto() {
        return produto;
    }
    
}//Fim da Classe
