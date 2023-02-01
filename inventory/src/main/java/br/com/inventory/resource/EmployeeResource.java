package br.com.inventory.resource;

import br.com.inventory.controller.EmployeeController;
import br.com.inventory.entity.Employee;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @Inject
    private EmployeeController empController;

    @GET
    public List<Employee> findAll() {
        return Employee.listAll();
    }

    @POST
    @Transactional
    public Response create(Employee emp) {
        Employee.persist(emp);
        return Response.ok(emp).status(201).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Employee emp) {

        if (empController.isEmployeeNameNotEmpty(emp)) {
            return Response.ok("Employee was not found").type(MediaType.APPLICATION_JSON_TYPE).build();
        }

        Employee empEntity = empController.update(id, emp);

        return Response.ok(empEntity).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Employee empEntity = Employee.findById(id);

        if (empEntity == null) {
            throw new WebApplicationException("Employee with id " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        empEntity.delete();
        return Response.status(204).build();
    }
}