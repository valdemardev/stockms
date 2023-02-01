package br.com.inventory.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.annotation.processing.Generated;
import javax.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Stock extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column 
    private Date fabDate, expirationDate;

    @Column
    private Employee employee;

    @Column
    private Category category;

    @Column 
    private Double price;
    
    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    
    public void setName(String name){
        this.name = name; 
    }

    public String getName(){
        return this.name;
    }
    
    public void setFabDate(Date fabDate){
        this.fabDate = fabDate; 
    }

    public Date getFabDate(){
        return this.fabDate;
    }

    
    public void setExpirationDate(Date expirationDate){
        this.expirationDate= expirationDate; 
    }

    public Date getExpirationDate(){
        return this.expirationDate;
    }

    
    public void setEmployee(Employee employee){
        this.employee.setId(employee.getId()); 
        this.employee.setName(employee.getName());
        this.employee.setSeniorityLevel(employee.getSeniorityLevel());
    }

    public Employee getEmployee(){
        return this.employee;
    }    
    
    public void setPrice(Double price){
        this.price = price;
    }

    public Double getPrice(){
        return this.price;
    }


    public void setCategory(Category category){
        this.category.setDescription(category.getDescription());
        this.category.setId(category.getId());
        this.category.setName(category.getName());
        this.category.setSerialNumber(category.getSerialNumber());
    }

    public Category getCategory(){
        return this.category;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;

        if(o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(id, stock.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}