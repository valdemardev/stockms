package br.com.inventory.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.annotation.processing.Generated;
import javax.persistence.*;

import java.util.Objects;

@Entity
public class Category extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id, serialNumber;

    @Column
    private String name, description;
    
    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    public void setSerialNumber(Long serialNumber){
        this.serialNumber = serialNumber;
    }

    public Long getSerialNumber(){
        return this.serialNumber;
    }

    public void setName(String name){
        this.name = name; 
    }

    public String getName(){
        return this.name;
    }

    public void setDescription(String description){
         this.description = description;
    }
    
    public String getDescription(){
        return this.description;
    }


    @Override
    public boolean equals(Object o){
        if(this == o) return true;

        if(o == null || getClass() != o.getClass()) return false;
        Category cat = (Category) o;
        return Objects.equals(id, cat.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}