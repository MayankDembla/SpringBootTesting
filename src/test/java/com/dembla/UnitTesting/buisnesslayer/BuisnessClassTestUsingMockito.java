package com.dembla.UnitTesting.buisnesslayer;

import com.dembla.UnitTesting.services.DataStore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuisnessClassTestUsingMockito {

    @InjectMocks
    BuisnessClass buisnessClass ;

    @Mock
    DataStore dataStore ;             // = mock(DataStore.class) ;

//    @BeforeEach
//    public void before(){
//        buisnessClass.setDataStore(dataStore);
//    }

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
