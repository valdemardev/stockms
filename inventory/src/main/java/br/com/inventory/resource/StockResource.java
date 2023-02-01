package br.com.inventory.resource;

import br.com.inventory.controller.StockController;
import br.com.inventory.entity.Stock;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/stock")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StockResource {

    @Inject
    private StockController stockController;

    @GET
    public List<Stock> findAll() {
        return Stock.listAll();
    }

    @POST
    @Transactional
    public Response create(Stock stock) {
        Stock.persist(stock);
        return Response.ok(stock).status(201).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Stock stock) {

        if (stockController.isStockNameNotEmpty(stock)) {
            return Response.ok("Stock was not found").type(MediaType.APPLICATION_JSON_TYPE).build();
        }

        Stock stockEntity = stockController.update(id, stock);

        return Response.ok(stockEntity).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Stock stockEntity = Stock.findById(id);

        if (stockEntity == null) {
            throw new WebApplicationException("Stock with id " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        stockEntity.delete();
        return Response.status(204).build();
    }
}