package br.com.imobiliaria.rest;

import br.com.imobiliaria.dao.ImagemDAO;
import br.com.imobiliaria.dao.ImovelDAO;
import br.com.imobiliaria.dao.InformacaoDAO;
import br.com.imobiliaria.model.Imagem;
import br.com.imobiliaria.model.Imovel;
import br.com.imobiliaria.model.Informacao;
import com.google.gson.Gson;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
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
@Path("imoveis")
@Produces(MediaType.APPLICATION_JSON)
public class ImovelResourse {

    @Inject
    private ImagemDAO imagemDAO;

    @Inject
    private ImovelDAO imovelDAO;

    @Inject
    private InformacaoDAO informacaoDAO;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Imovel insert(Imovel imovel) {
        imovelDAO.insere(imovel);
        return imovel;
    }

    @GET
    public List<Imovel> list() {
        return imovelDAO.lista();
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        imovelDAO.excluir(id);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Imovel update(@PathParam("id") Long id, Imovel imovel) {
        if (!Objects.equals(id, imovel.getId())) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return imovelDAO.atualizar(imovel);
    }

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long id) {
        final Imovel imovel = imovelDAO.buscar(id);
        if (imovel == null) {
            throw new EntityNotFoundException();
        }
        return Response.ok(imovel).build();
    }

    @GET
    @Path("{id}/imagens")
    public Response listImagens(@PathParam("id") Long id) {        
        List<Long> imagens = imagemDAO.lista(id).stream()
                .map(e -> e.getId())
                .collect(Collectors.toList());
//        GenericEntity<List<Long>> list = new GenericEntity<List<Long>>(imagens) {
//        };

        Gson gson = new Gson();

        return Response.ok(gson.toJson(imagens)).build();
    }

    @GET
    @Path("{imovelId}/imagens/{imagemId}")
    @Produces("image/*")
    public Response find(@PathParam("imovelId") Long imovelId, @PathParam("imagemId") Long imagemId) {
        final Imagem imagem = imagemDAO.buscar(imagemId);
        if (imagem == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(imagem.getImagem()).build();
    }
    
    @GET
    @Path("{id}/informacoes")
    public List<Informacao> listInformacoes(@PathParam("id") Long id) {        
        return informacaoDAO.listaInf(id);
    }
    
}
