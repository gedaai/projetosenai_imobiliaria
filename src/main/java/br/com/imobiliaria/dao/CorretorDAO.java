
package br.com.imobiliaria.dao;

import br.com.imobiliaria.model.Corretor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    
    public Corretor login(Corretor corretor) {
        
        if (lista().isEmpty()) {
            Corretor c = new Corretor();
            c.setLogin("leonardo");
            c.setSenha("leonardo");
            c.setNome("Leonardo Zanivan");
            insere(c);
        }
        
        try {
            String jpql = "SELECT u FROM Corretor u "
                    + "WHERE u.login = :login AND u.senha = :senha";
            TypedQuery<Corretor> q = em.createQuery(jpql, Corretor.class);
            q.setParameter("login", corretor.getLogin());
            q.setParameter("senha", corretor.getSenha());
            return q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
