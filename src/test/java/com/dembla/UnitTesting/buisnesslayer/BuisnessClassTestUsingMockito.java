package com.dembla.UnitTesting.buisnesslayer;

import com.dembla.UnitTesting.services.DataStore;
import org.hibernate.id.enhanced.DatabaseStructure;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuisnessClassTestUsingMockito {

    @Test
    public void calculateSumUsingMockito(){

        BuisnessClass buisnessClass = new BuisnessClass() ;

        DataStore dataStore = mock(DataStore.class) ;
        when(dataStore.retrieveData()).thenReturn(new  int[]{1,2,3,4}) ;

        buisnessClass.setDataStore(dataStore);
        int result = buisnessClass.calculateeSum() ;
        int actualresult = 10 ;

        assertEquals(actualresult,result);
    }

    @Test
    public void calculateSumNoValue(){

        BuisnessClass buisnessClass = new BuisnessClass() ;

        DataStore dataaStore = mock(DataStore.class) ;
        when(dataaStore.retrieveData()).thenReturn(new int[]{}) ;

        buisnessClass.setDataStore(dataaStore) ;

         int result = buisnessClass.calculateeSum() ;
         int actualResult = 0 ;
          assertEquals(actualResult,result);
    }

    @Test
    public void calculateSumOneValue(){

        BuisnessClass buisnessClass = new BuisnessClass() ;

        DataStore dataaStore = mock(DataStore.class) ;
        when(dataaStore.retrieveData()).thenReturn(new int[]{5}) ;

        buisnessClass.setDataStore(dataaStore) ;

        int result = buisnessClass.calculateeSum() ;
        int actualResult = 5 ;
        assertEquals(actualResult,result);
    }


}
