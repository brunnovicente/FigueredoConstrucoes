/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

 
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
 

/**
 * Classe responsável pela criptografia
 * @author brunn
 */
public class Criptografia{
    
    private static Criptografia singleton;
    private static SecretKeySpec secretKey;
    private static byte[] key;
    
    public static Criptografia getCriptografia(){
        if(singleton==null) {
            singleton = new Criptografia();
        }
            return singleton;
    }
    
     public void setKey(String myKey) 
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    
    public String encrypt(String strToEncrypt) 
    {
        try
        {
            String secret = "iambatmaniambatmaniambatman-1104";
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
    
    public String decrypt(String strToDecrypt) 
    {
        try
        {
            String secret = "iambatmaniambatmaniambatman-1104";
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    
       
    /**
     * Criptografa a senha usando SHA512
     * @param senha: Senha a ser criptografada
     * @return Hash da senha 
     */
    public String HashSHA512(String senha){
   
        MessageDigest md = null; 
        try { 
        md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        } 
        try {
            md.update(senha.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
 
        return sb.toString();
 /*
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	System.out.println("Hex format : " + hexString.toString());
   */
    }
    
    
     /**
      * Criptografa a senha usando MD5
      * @param senha: Senha a ser criptografada
      * @return Senha criptografada
      */
    public String Hashmd5(String senha){  
      
            String sen = "";  
            MessageDigest md = null;  
            BigInteger hash = null;
            try {  
                md = MessageDigest.getInstance("MD5");  
            } catch (NoSuchAlgorithmException e) {  
                e.printStackTrace();  
            } 
            
            try { 
                hash = new BigInteger(1, md.digest(senha.getBytes("UTF-8")));  
            } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        }
            sen = hash.toString(16);  
            return sen;
        
    }  
    
}