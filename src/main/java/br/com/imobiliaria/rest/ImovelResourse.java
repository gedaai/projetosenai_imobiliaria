package br.com.imobiliaria.rest;

import br.com.imobiliaria.dao.ImovelDAO;
import br.com.imobiliaria.model.Imovel;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("imoveis")
@Produces(MediaType.APPLICATION_JSON)
public class ImovelResourse {
    
    @Inject
    private ImovelDAO imovelDAO;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Imovel insert(Imovel imovel){
        imovelDAO.insere(imovel);
        return imovel;
    }
    
    @GET
    public List<Imovel> list(){
        return imovelDAO.lista();
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id){
        imovelDAO.excluir(id);
    }
}
