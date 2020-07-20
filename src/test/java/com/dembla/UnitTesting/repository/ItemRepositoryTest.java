package com.dembla.UnitTesting.repository;

import com.dembla.UnitTesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ItemRepositoryTest {

  @Autowired
  private ItemRepository itemRepository ;

  @Test
  public void testFindAll(){
      List<Item> items = itemRepository.findAll();

      assertEquals(4 ,items.size());
  }

}