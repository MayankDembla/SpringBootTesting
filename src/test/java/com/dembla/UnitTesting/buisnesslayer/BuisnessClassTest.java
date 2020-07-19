package com.dembla.UnitTesting.buisnesslayer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

class BuisnessClassTest {

    @Test
    void calculateSum_basicScanerio() {

        BuisnessClass buisnessClass = new BuisnessClass() ;

        int result = buisnessClass.calculateSum( new int[] {1,2,3,4} );
        int expectedResult = 10 ;

        assertEquals(expectedResult , result );
    }

    @Test
    void product_basicTest() {

      BuisnessClass buisnessClass = new BuisnessClass() ;

      int result = buisnessClass.product(new int[]{2,3,4}) ;
      int expectedResult = 24 ;

      assertEquals(expectedResult,result );
    }
}