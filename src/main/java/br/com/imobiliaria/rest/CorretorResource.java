
package br.com.imobiliaria.rest;

import br.com.imobiliaria.dao.CorretorDAO;
import br.com.imobiliaria.model.Corretor;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("corretores")
@Produces(MediaType.APPLICATION_JSON)
public class CorretorResource {
  
    @Inject
    private CorretorDAO corretorDAO;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Corretor insert(Corretor corretor){
        corretorDAO.insere(corretor);
        return corretor;
    }
    
    @GET
    public List<Corretor> list(){
        return corretorDAO.lista();
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id){
        corretorDAO.excluir(id);
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Corretor update(@PathParam("id") Long id, Corretor corretor) {
        if (!Objects.equals(id, corretor.getId())) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return corretorDAO.atualizar(corretor);
    }
    
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long id) {
        final Corretor corretor = corretorDAO.buscar(id);
        if (corretor == null) {
            throw new EntityNotFoundException();
        }
        return Response.ok(corretor).build();
    }
    
}