/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package janelas.auxiliar;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import persistencia.ProcessoProduto;

/**
 *
 * @author brunn_000
 */
public class BarraBusca extends Thread{
    
    private JProgressBar jbarra;
    private boolean rodar;
//    private boolean acabou;
    private JDialog janela;
    private JLabel texto;
//    private JFrame janelalogin;

    private ProcessoProduto processo;
    
    public BarraBusca(JDialog janela, JProgressBar jbarra, JLabel texto, ProcessoProduto processo){
        this.jbarra = jbarra;
        this.rodar = true;
        this.janela = janela;
        this.texto = texto;
        this.processo = processo;
        this.processo.start();
        
    }

   
    @Override
    public void run(){
        
        int valor = jbarra.getValue();
        
        while(rodar){
            //jbarra.setIndeterminate(true);
            try {
                Thread.sleep(700);
            } catch (InterruptedException ex) {
                Logger.getLogger(BarraBusca.class.getName()).log(Level.SEVERE, null, ex);
            }            
            
            
            if(processo.taViva()){
                if(jbarra.getValue() < 100){
                    valor += 7;
                    jbarra.setValue(valor);
                }else{
                    this.texto.setText("Carregando Produtos...");
                    jbarra.setValue(0);
                    //valor = 7;
                }
            }else{
                    if(!processo.taViva()){
                        this.parar();
                        //this.janelalogin.setVisible(true);
                        this.janela.dispose();
                        //this.janela.dispose();
                    }
            }
            System.out.println("Executando...");
        }
        
    }//Fim do RUN
    
    public void parar(){
        this.rodar = false;
    }
    
}//Fim da barra
