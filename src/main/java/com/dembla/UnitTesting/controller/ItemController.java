package com.dembla.UnitTesting.controller;

import com.dembla.UnitTesting.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item helloWorld(){
        return new Item("Ball",10,100) ;
    }

}
