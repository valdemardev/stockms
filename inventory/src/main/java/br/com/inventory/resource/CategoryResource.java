package br.com.inventory.resource;

import br.com.inventory.controller.CategoryController;
import br.com.inventory.entity.Category;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

    @Inject
    private CategoryController catController;

    @GET
    public List<Category> findAll() {
        return Category.listAll();
    }

    @POST
    @Transactional
    public Response create(Category cat) {
        Category.persist(cat);
        return Response.ok(cat).status(201).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Category cat) {

        if (catController.isCategoryNameNotEmpty(cat)) {
            return Response.ok("Category was not found").type(MediaType.APPLICATION_JSON_TYPE).build();
        }

        Category catEntity = catController.update(id, cat);

        return Response.ok(catEntity).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Category catEntity = Category.findById(id);

        if (catEntity == null) {
            throw new WebApplicationException("Category with id " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        catEntity.delete();
        return Response.status(204).build();
    }
}