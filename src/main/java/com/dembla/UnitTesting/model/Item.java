package com.dembla.UnitTesting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    private String name ;

    @Id
    private int id = 1;
    private int price ;
    private  int quantity ;

    @Transient
    private int value ;

    public Item(String test, int i, int i1) {
        this.name = test ;
        this.price = i ;
        this.quantity = i1 ;
        this.id = id++ ;
    }
}
