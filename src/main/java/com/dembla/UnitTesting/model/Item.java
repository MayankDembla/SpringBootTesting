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
    private int id ;
    private int price ;
    private  int quantity ;

    @Transient
    private int value ;

    public Item(String test, int i, int i1) {
        this.name = test ;
        this.id = i ;
        this.quantity = i1 ;
    }
}
