/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Cliente;
import entidades.Fornecedor;
import entidades.Produto;
import entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author brunn
 */
public class Banco {
    
    private static Banco banco;
    private static Cliente clientePadrao;
    public static Usuario usuario;
    
    EntityManagerFactory factory;// = Persistence.createEntityManagerFactory("bancopecas");
    EntityManager em;// = factory.createEntityManager();
    
//    public Banco(){
//        this.abrirInstancia();
//        this.fecharInstancia();
//    }
    
    public static Banco getBanco() {
        if (banco == null) {
            banco = new Banco();
        }
        return banco;
    }
    
    /**
     * Retorna o usuário logado no sistema
     * @return Objeto usuário
     */
    public static Usuario getUsuarioLogado(){
        return usuario;
    }
    
    public static Cliente getCliente(){
        return clientePadrao;
    }
    /**
     * Conecta a classe ao banco de dados
     */
    public void abrirInstancia(){
       factory = Persistence.createEntityManagerFactory("estoque");
       em = factory.createEntityManager();
   }
   
    /**
     * Fecha a conexão com o Banco de Dados
     */
    public void fecharInstancia(){
        this.factory.close();
    }
    
    public Usuario getUsuario(String login){
        this.abrirInstancia();
        em = factory.createEntityManager();
        
        List<Usuario> lista = null;

        Query res = em.createQuery("SELECT "
                + "u "
                + "FROM Usuario as u "
                + "WHERE u.login = '"+login+"'");

        lista = res.getResultList();
        
        em.clear();
        em.close();
        this.fecharInstancia();
        
        if(lista.isEmpty()){
            return null;
        }
        
        return lista.get(0);
    }
    
    public boolean fazerLogin(String login, String senha) throws Exception{
        this.gerarDados();
        Usuario user = this.getUsuario(login);
        
        if(user != null){
            if(user.getSenha().equals(Criptografia.getCriptografia().HashSHA512(senha))){
                usuario = user;
                return true;
            }else{
                throw new Exception("Senha Inválida!");
            }
        }else{
            throw new Exception("Usuário inválido!");
        }
    
    }
    
    public void gerarDados(){
        this.clientePadrao();
        Usuario user = this.getUsuario("admin");
                
        if(clientePadrao == null){
            Cliente cliente = new Cliente();
            cliente.setCpf("000.000.000-00");
            cliente.setNome("Padrão");
            cliente.setStatus(Cliente.ATIVO);
            this.cadastrar(cliente);
            this.clientePadrao();
        }
        if(user == null){
            user = new Usuario();
            user.setEmail("user@user.com");
            user.setLogin("admin");
            user.setSenha(Criptografia.getCriptografia().HashSHA512("admin"));
            user.setNome("Admin");
            user.setStatus(Usuario.ATIVO);
            this.cadastrar(user);
        }
    }
    
    public void clientePadrao(){
        this.abrirInstancia();
        em = factory.createEntityManager();
        List<Cliente> lista = null;

        Query res = em.createQuery("SELECT "
                + "c "
                + "FROM Cliente as c WHERE c.cpf = '000.000.000-00'");
        lista = res.getResultList();
        
        em.clear();
        em.close();
        this.fecharInstancia();
        if(lista.isEmpty()){
            clientePadrao = null;
        }else{
            clientePadrao = lista.get(0);
        }
    }
    
    // FUNÇÕES DE CADASTRO
    
    public void cadastrar(Object objeto){
        this.abrirInstancia();
        this.em.getTransaction().begin();
        this.em.persist(objeto);
        this.em.getTransaction().commit();
        this.fecharInstancia();
    }
    
    public void editarUsuario(Usuario usuario){
        this.abrirInstancia();
        this.em.getTransaction().begin();
        this.em.merge(usuario);
        this.em.getTransaction().commit();
        this.fecharInstancia();
    }
    
    //FUNÇÕES DE CONSULTA
    
    public List<Usuario> consultaUsuario(){
        this.abrirInstancia();
        em = factory.createEntityManager();
        List<Usuario> lista = null;

        Query res = em.createQuery("SELECT "
                + "u "
                + "FROM Usuario as u WHERE status = "+Usuario.ATIVO
                + " ORDER BY u.nome");
        lista = res.getResultList();
        
        em.clear();
        em.close();
        this.fecharInstancia();
        return lista;
    }
    
    public List<Produto> consultaProduto(String chave){
        this.abrirInstancia();
        em = factory.createEntityManager();
        List<Produto> lista = null;

        Query res = em.createQuery("SELECT "
                + "p "
                + "FROM Produto as p "
                + "WHERE (p.descricao LIKE '%"+chave+"%' OR p.codigobarras = '"+chave+"')AND p.status = 1 ORDER BY p.descricao");
        lista = res.getResultList();
        
        em.clear();
        em.close();
        this.fecharInstancia();
        return lista;
    }
    
    public List<Fornecedor> consultaFornecedor(String chave){
        this.abrirInstancia();
        em = factory.createEntityManager();
        List<Fornecedor> lista = null;

        Query res = em.createQuery("SELECT "
                + "f "
                + "FROM Fornecedor as f "
                + "WHERE (f.razao LIKE '%"+chave+"%' OR f.cnpj = '"+chave+"')AND f.status = "+Fornecedor.ATIVO+" ORDER BY f.razao");
        lista = res.getResultList();
        
        em.clear();
        em.close();
        this.fecharInstancia();
        return lista;
    }
    
    //FUNÇÕES DE EDIÇÃO
    public void editarProduto(Produto produto){
        this.abrirInstancia();
        this.em.getTransaction().begin();
        this.em.merge(produto);
        this.em.getTransaction().commit();
        this.fecharInstancia();
    }
    
    public void editarFornecedor(Fornecedor fornecedor){
        this.abrirInstancia();
        this.em.getTransaction().begin();
        this.em.merge(fornecedor);
        this.em.getTransaction().commit();
        this.fecharInstancia();
    }
    
}//Fim da Classe
