package com.dembla.UnitTesting.services;

import com.dembla.UnitTesting.model.Item;
import com.dembla.UnitTesting.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemService {

    @Autowired
    ItemRepository itemRepository ;

    public Item retrievehardCodedItemname(){
        return  new Item("Test",10,100) ;
    }

    public List<Item> retrieveAllElements(){
        return  itemRepository.findAll() ;
    }

}
