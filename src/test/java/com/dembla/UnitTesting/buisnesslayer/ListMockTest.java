package com.dembla.UnitTesting.buisnesslayer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListMockTest {


    @Mock
    List mock ;

    @Test
    public void testbasic(){
        when(mock.size()).thenReturn(5) ;
        assertEquals(5,mock.size()) ;
    }

    @Test
    public void testReturnMultipleValue(){
        when(mock.size()).thenReturn(5).thenReturn(10) ;
        assertEquals(5,mock.size()) ;
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameter() {
        when(mock.get(0)).thenReturn("mayank")  ;
        when(mock.get(1)).thenReturn("dembla")  ;
        assertEquals("mayank",mock.get(0));
        assertEquals("dembla",mock.get(1));
        assertEquals(null,mock.get(2));        // get default value.
    }


}
