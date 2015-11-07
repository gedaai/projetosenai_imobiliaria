
package br.com.imobiliaria.dao;

import br.com.imobiliaria.model.Imovel;
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
        return em.merge(imovel);
    }

    public List<Imovel> lista() {
        TypedQuery<Imovel> q = em.createQuery("SELECT i "
                + "FROM Imovel i ORDER BY i.id", Imovel.class);
        return q.getResultList();
    }
    
    
    
}
