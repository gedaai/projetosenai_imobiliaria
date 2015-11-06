
package br.com.imobiliaria.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ImovelDAO {
    
    @PersistenceContext(unitName = "imobiliariaPU")
    private EntityManager em;
    
}
