package com.dembla.UnitTesting.controller;

import com.dembla.UnitTesting.model.Item;
import com.dembla.UnitTesting.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService ;

    @GetMapping("/dummy-item")
    public Item helloWorld(){
        return new Item("Ball",10,100) ;
    }

    @GetMapping("/dummy-itemUsingService")
    public Item helloWorldUsingService(){
        return itemService.retrievehardCodedItemname();
    }

    @GetMapping("/all-items")
    public List<Item> retrievallItem(){

        return itemService.retrieveAllElements() ;
    }


}
