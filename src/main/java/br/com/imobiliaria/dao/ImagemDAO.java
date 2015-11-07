
package br.com.imobiliaria.dao;

import br.com.imobiliaria.model.Imagem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ImagemDAO {

    @PersistenceContext(unitName = "imobiliariaPU")
    private EntityManager em;
    
    public void insere(Imagem imagem) {
        em.persist(imagem);
    }
    
    public void excluir(Long id) {
        em.remove(em.getReference(Imagem.class, id));
    }
    
    public Imagem buscar(Long id) {
        return em.find(Imagem.class, id);
    }
    
    public Imagem atualizar(Imagem imagem) {
        return em.merge(imagem);
    }

    public List<Imagem> lista() {
        TypedQuery<Imagem> q = em.createQuery("SELECT i "
                + "FROM Imagem i ORDER BY i.id", Imagem.class);
        return q.getResultList();
    }
    
}
