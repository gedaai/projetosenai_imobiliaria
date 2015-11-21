
package br.com.imobiliaria.dao;

import br.com.imobiliaria.model.Imagem;
import br.com.imobiliaria.model.Imovel;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ImovelDAO {
    
    @PersistenceContext(unitName = "imobiliariaPU")
    private EntityManager em;
    
    public void insere(Imovel imovel) {
        em.persist(imovel);
    }
    
    public void excluir(Long id) {
        em.remove(em.getReference(Imovel.class, id));
    }
    
    public Imovel buscar(Long id) {
        return em.find(Imovel.class, id);
    }
    
    public Imovel atualizar(Imovel imovel) {
        
        List<Imagem> imagens = new ArrayList<>();
        Imagem imagem = new Imagem();
        imagem.setImovel(imovel);
        FileInputStream fileInputStream=null;
        
        /*File file = new File("C:\\Imagens\\teste1.jpg");
        //File file = new File("teste1.jpg");
        
        byte[] bFile = new byte[(int) file.length()];
        
        try {
            //convert file into array of bytes
	    fileInputStream = new FileInputStream(file);
	    fileInputStream.read(bFile);
	    fileInputStream.close();
            
         }catch(Exception e){
        	e.printStackTrace();
        }
        imagem.setImagem(bFile);
        
        imagens.add(imagem);
        
        imagem = new Imagem();
        imagem.setImovel(imovel);
        fileInputStream=null;
        
        file = new File("C:\\Imagens\\teste2.jpg");
        
        bFile = new byte[(int) file.length()];
        
        try {
            //convert file into array of bytes
	    fileInputStream = new FileInputStream(file);
	    fileInputStream.read(bFile);
	    fileInputStream.close();
            
         }catch(Exception e){
        	e.printStackTrace();
        }
        imagem.setImagem(bFile);
        
        imagens.add(imagem);
        
        imagem = new Imagem();
        imagem.setImovel(imovel);
        fileInputStream=null;
        
        file = new File("C:\\Imagens\\teste3.jpg");
        
        bFile = new byte[(int) file.length()];
        
        try {
            //convert file into array of bytes
	    fileInputStream = new FileInputStream(file);
	    fileInputStream.read(bFile);
	    fileInputStream.close();
            
         }catch(Exception e){
        	e.printStackTrace();
        }
        imagem.setImagem(bFile);
        */
        imagens.add(imagem);
        
        imovel.setImagens(imagens);
        return em.merge(imovel);
    }

    public List<Imovel> lista() {
        
        TypedQuery<Imovel> q = em.createQuery("SELECT i "
                + "FROM Imovel i ORDER BY i.id", Imovel.class);
        return q.getResultList();
    }
  
}
