package com.dembla.UnitTesting.services;

import com.dembla.UnitTesting.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemService {

    public Item retrievehardCodedItemname(){
        return  new Item("Test",10,100) ;
    }

}
