
package br.com.imobiliaria.rest;

import br.com.imobiliaria.dao.InformacaoDAO;
import br.com.imobiliaria.model.Informacao;
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
@Path("informacoes")
@Produces(MediaType.APPLICATION_JSON)
public class InformacaoResource {
    
    @Inject
    private InformacaoDAO informacaoDAO;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Informacao insert(Informacao informacao){
        System.out.println("AQUI: "+informacao.getDescricao()+" - "+informacao.getEmail());
        informacaoDAO.insere(informacao);
        return informacao;
    }
    
    @GET
    public List<Informacao> list(){
        return informacaoDAO.lista();
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id){
        informacaoDAO.excluir(id);
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Informacao update(@PathParam("id") Long id, Informacao informacao) {
        if (!Objects.equals(id, informacao.getId())) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return informacaoDAO.atualizar(informacao);
    }
    
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long id) {
        final Informacao informacao = informacaoDAO.buscar(id);
        if (informacao == null) {
            throw new EntityNotFoundException();
        }
        return Response.ok(informacao).build();
    }
    
}
