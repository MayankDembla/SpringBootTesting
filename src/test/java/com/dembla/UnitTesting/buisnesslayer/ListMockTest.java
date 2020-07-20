package com.dembla.UnitTesting.buisnesslayer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListMockTest {


    @Mock
    List<String> mock ;

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


    @Test
    public void returnWithGenricType(){
        when(mock.get(anyInt())).thenReturn("mayank") ;
        assertEquals("mayank",mock.get(0));
        assertEquals("mayank",mock.get(5));
    }

   // Verify Method under Test
   // Check if a Specific method is Called with a Specific Value on a Mock.
   @Test
    public void verificationBasics(){
        // SUT
        String value1 = mock.get(0) ;
        String value2 = mock.get(1) ;

        // Verify
       verify(mock).get(0) ;
       verify(mock, times(2)).get(anyInt()) ;
       verify(mock, atLeast(1)).get(anyInt()) ;
       verify(mock, atLeastOnce()).get(anyInt()) ;
       verify(mock, atMost(2)).get(anyInt()) ;
       verify(mock, never()).get(2) ;
   }


   // Capturing argument passed to the method

    @Test
    public void argumentCapturing(){
        // SUT - System Under Test
        mock.add("SomeString") ; // need to find out what Argument is passed

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class) ;
        verify(mock).add(captor.capture()) ; // verify if this method is called ?

        assertEquals("SomeString",captor.getValue());
    }

}
