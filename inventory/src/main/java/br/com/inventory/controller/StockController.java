package br.com.inventory.controller;

import br.com.inventory.entity.Stock;


import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class StockController {

    public Stock update(Long id, Stock stock) {
        Stock stockEntity = Stock.findById(id);

        if (stockEntity == null) {
            throw new WebApplicationException("Inventory with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        stockEntity.setName(stock.getName());
        stockEntity.setCategory(stock.getCategory());
        stockEntity.setEmployee(stock.getEmployee());
        stockEntity.setExpirationDate(stock.getExpirationDate());
        stockEntity.setFabDate(stock.getFabDate());
        stockEntity.setPrice(stock.getPrice());
        
        return stockEntity;
    }

    /**
     * This method is main purpose to show simple "Business" example
     * @param stock
     * @return
     */
    public boolean isStockNameNotEmpty(Stock stock) {
        return stock.getName().isEmpty();
    }
}
