/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas.auxiliar;

import janelas.JanelaPrincipal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import persistencia.Banco;

/**
 *
 * @author Bruno
 */
public class Iniciando extends Thread{
    
    private boolean vida = false;
    private String login;
    private String senha;
    private JFrame janelalogin;
        
    public Iniciando(JFrame janelalogin, String login, String senha){
        this.login = login;
        this.senha = senha;
        this.janelalogin = janelalogin;
    }
    
    
    @Override
    public void run(){
        vida = true;
        System.out.println("INICANDO O SISTEMA...............................................");
        iniciandoSistema();
        vida = false;
    }
    
    public void iniciandoSistema(){
        try {
            if(Banco.getBanco().fazerLogin(login, senha)){
                JanelaPrincipal janela = new JanelaPrincipal();
                janela.setVisible(true);
                janelalogin.dispose();
            }
        } catch (Exception ex) {
            janelalogin.setVisible(true);
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public boolean taViva(){
        return vida;
    }
    
    
}//Fim da Classe
