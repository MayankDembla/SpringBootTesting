package com.dembla.UnitTesting.buisnesslayer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ListMockTest {


    @Test
    public void testbasic(){
        List mock = Mockito.mock(List.class) ;
        when(mock.size()).thenReturn(5) ;
        assertEquals(5,mock.size()) ;
    }

    @Test
    public void testReturnMultipleValue(){
        List mock = Mockito.mock(List.class) ;
        when(mock.size()).thenReturn(5).thenReturn(10) ;
        assertEquals(5,mock.size()) ;
        assertEquals(10, mock.size());
    }



}
