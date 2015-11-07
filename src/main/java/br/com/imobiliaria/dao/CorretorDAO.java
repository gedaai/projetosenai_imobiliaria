
package br.com.imobiliaria.dao;

import br.com.imobiliaria.model.Corretor;
import static br.com.imobiliaria.model.Informacao_.imovel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CorretorDAO {
    
    @PersistenceContext(unitName = "imobiliariaPU")
    private EntityManager em;
    
    public void insere(Corretor corretor) {
        em.persist(corretor);
    }
    
    public void excluir(Long id) {
        em.remove(em.getReference(Corretor.class, id));
    }
    
    public Corretor buscar(Long id) {
        return em.find(Corretor.class, id);
    }
    
    public Corretor atualizar(Corretor corretor) {
        return em.merge(corretor);
    }

    public List<Corretor> lista() {
        TypedQuery<Corretor> q = em.createQuery("SELECT c "
                + "FROM Corretor c ORDER BY c.id", Corretor.class);
        return q.getResultList();
    }
    
}
