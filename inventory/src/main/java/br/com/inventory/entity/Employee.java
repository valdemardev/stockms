package br.com.inventory.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.annotation.processing.Generated;
import javax.persistence.*;

import java.util.Objects;

@Entity
public class Employee extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name, seniorityLevel;
    
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

    public void setSeniorityLevel(String seniorityLevel){
         this.seniorityLevel = seniorityLevel;
    }
    
    public String getSeniorityLevel(){
        return this.seniorityLevel;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;

        if(o == null || getClass() != o.getClass()) return false;
        Employee emp = (Employee) o;
        return Objects.equals(id, emp.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}