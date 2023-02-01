package br.com.inventory.controller;

import br.com.inventory.entity.Employee;


import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class EmployeeController {

    public Employee update(Long id, Employee emp) {
        Employee empEntity = Employee.findById(id);

        if (empEntity == null) {
            throw new WebApplicationException("Employee with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        empEntity.setName(emp.getName());
        empEntity.setSeniorityLevel(emp.getSeniorityLevel());

        return empEntity;
    }

    /**
     * This method is main purpose to show simple "Business" example
     * @param emp
     * @return
     */
    public boolean isEmployeeNameNotEmpty(Employee emp) {
        return emp.getName().isEmpty();
    }
}
