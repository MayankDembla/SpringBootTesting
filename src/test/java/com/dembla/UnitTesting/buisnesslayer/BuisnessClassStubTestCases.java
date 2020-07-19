package com.dembla.UnitTesting.buisnesslayer;

import com.dembla.UnitTesting.services.DataStore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuisnessClassStubTestCases {

    // Data Store TestCases

    @Test
    void calculateSumUsingDataStore(){

        BuisnessClass buisnessClass = new BuisnessClass() ;
        buisnessClass.setDataStore(new SomeDataServiceStub());
        int result = buisnessClass.calculateeSum() ;
        int expectedreuslt = 10 ;
        assertEquals(expectedreuslt, result );

    }
    @Test
    void calculateSumUsingDataStore_novalue(){

        BuisnessClass buisnessClass = new BuisnessClass() ;
        buisnessClass.setDataStore(new SomeDataServiceStubNoValue());
        int result = buisnessClass.calculateeSum() ;
        int expectedreuslt = 0;
        assertEquals(expectedreuslt, result );

    }

}


class SomeDataServiceStub implements DataStore {

    @Override
    public int[] retrieveData() {
        return  new int[] {1,2,3,4} ;
    }
}


class SomeDataServiceStubNoValue implements DataStore {

    @Override
    public int[] retrieveData() {
        return  new int[] {} ;
    }
}