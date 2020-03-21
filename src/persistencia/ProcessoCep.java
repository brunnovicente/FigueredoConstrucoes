/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JTextField;

/**
 *
 * @author brunn
 */
public class ProcessoCep extends Thread{
    
    private JTextField jcidade;
    private JTextField jbairro;
    private JTextField jestado;
    private JTextField jendereco;
    private JTextField jnumero;
    private String cep;
    
    @Override
    public void run() {
        
    }//Fim do Run

    public ProcessoCep(JTextField jcidade, JTextField jbairro, JTextField jestado, JTextField jendereco, JTextField jnumero, String cep) {
        this.jcidade = jcidade;
        this.jendereco = jendereco;
        this.jbairro = jbairro;
        this.jestado = jestado;
        this.jnumero = jnumero;
        this.cep = cep;
    }
    
    
    
    public void buscarCep() 
    {
        String json;        

        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();
            
            // JOptionPane.showMessageDialog(null, json);
            
            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");                       
            String array[] = new String[30];
            array = json.split("\n");
            
            // JOptionPane.showMessageDialog(null, array);
                             
            String logradouro = array[7];            
            String bairro = array[15];
            String cidade = array[19]; 
            String uf = array[23];
            
            jcidade.setText(cidade);
            jbairro.setText(bairro);
            jendereco.setText(logradouro);
            jestado.setText(uf);
            
            if(jendereco.getText().isEmpty()){
                jendereco.requestFocus();
            }else{
                jnumero.requestFocus();
            }
            //JOptionPane.showMessageDialog(null, logradouro + " " + bairro + " " + cidade + " " + uf);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }//Fim da Busca
    
    
    
}//Fim da Classe
