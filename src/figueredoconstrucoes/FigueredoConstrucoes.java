/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figueredoconstrucoes;

import janelas.TelaLogin;
import java.io.IOException;

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
        
        
        //exec();
        
                
    }
    
    
    private static void exec(){ 
        Process exec; 
        try { 
            exec = Runtime.getRuntime().exec("mysqldump -u root -p1104 figueredo > d:/figueredo.sql"); 
            if ( exec.waitFor() == 0)
                System.out.println("Executado."); 
            else 
                System.out.println("ERRO"); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
    }
    
    
}
