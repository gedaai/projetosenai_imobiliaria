
package br.com.imobiliaria.dao;

import br.com.imobiliaria.model.Informacao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class InformacaoDAO {

    
    @PersistenceContext(unitName = "imobiliariaPU")
    private EntityManager em;
    
    public void insere(Informacao informacao) {
        em.persist(informacao);
    }
    
    public void excluir(Long id) {
        em.remove(em.getReference(Informacao.class, id));
    }
    
    public Informacao buscar(Long id) {
        return em.find(Informacao.class, id);
    }
    
    public Informacao atualizar(Informacao informacao) {
        return em.merge(informacao);
    }

    
    public List<Informacao> lista() {
        TypedQuery<Informacao> q = em.createQuery("SELECT i "
                + "FROM Informacao i ORDER BY i.id", Informacao.class);
        
        return q.getResultList();
    }
    
    public List<Informacao> listaInf(Long idImovel) {
        TypedQuery<Informacao> q = em.createQuery("SELECT i "
                + "FROM Informacao i WHERE i.imovel.id= :idImovel ORDER BY i.id", Informacao.class)
                .setParameter("idImovel", idImovel);
        
        return q.getResultList();
    }
    
    
}
