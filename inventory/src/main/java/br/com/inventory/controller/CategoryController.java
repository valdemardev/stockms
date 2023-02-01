package br.com.inventory.controller;

import br.com.inventory.entity.Category;


import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class CategoryController {

    public Category update(Long id, Category cat) {
        Category catEntity = Category.findById(id);

        if (catEntity == null) {
            throw new WebApplicationException("Category with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        catEntity.setName(cat.getName());
        catEntity.setDescription(cat.getDescription());
        catEntity.setSerialNumber(cat.getSerialNumber());

        return catEntity;
    }

    /**
     * This method is main purpose to show simple "Business" example
     * @param cat
     * @return
     */
    public boolean isCategoryNameNotEmpty(Category cat) {
        return cat.getName().isEmpty();
    }
}
