package com.dembla.UnitTesting.services;

import com.dembla.UnitTesting.model.Item;
import com.dembla.UnitTesting.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ItemServiceTest {

    @InjectMocks
    private ItemService itemService ;

    @Mock
    private ItemRepository itemRepository ;

    @Test
    void retrieveAllElements() {

    when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item("Test",10,10),
                                                            new Item("Test2",10,10))) ;

     List<Item> testing = itemService.retrieveAllElements() ;

     assertEquals(100,testing.get(0).getValue());
     assertEquals(100,testing.get(1).getValue());

    }
}