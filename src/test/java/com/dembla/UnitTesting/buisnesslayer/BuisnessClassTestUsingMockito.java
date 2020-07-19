package com.dembla.UnitTesting.buisnesslayer;

import com.dembla.UnitTesting.services.DataStore;
import org.hibernate.id.enhanced.DatabaseStructure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuisnessClassTestUsingMockito {

    BuisnessClass buisnessClass = new BuisnessClass() ;
    DataStore dataStore = mock(DataStore.class) ;

    @BeforeEach
    public void before(){
        buisnessClass.setDataStore(dataStore);
    }

    @Test
    public void calculateSumUsingMockito(){

        when(dataStore.retrieveData()).thenReturn(new  int[]{1,2,3,4}) ;
        assertEquals(10, buisnessClass.calculateeSum());
    }

    @Test
    public void calculateSumNoValue(){

        when(dataStore.retrieveData()).thenReturn(new int[]{}) ;
        assertEquals(0, buisnessClass.calculateeSum());
    }

    @Test
    public void calculateSumOneValue(){

        when(dataStore.retrieveData()).thenReturn(new int[]{5}) ;
        assertEquals(5, buisnessClass.calculateeSum());
    }


}
