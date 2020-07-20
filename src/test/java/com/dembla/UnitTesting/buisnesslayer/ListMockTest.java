package com.dembla.UnitTesting.buisnesslayer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
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


    @Test
    public void multipleArgumetCapturing(){

        // SUT
        mock.add("someString1") ;
        mock.add("someString2") ;

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class) ;
        verify(mock, times(2)).add(captor.capture()) ;

        List<String> allValues = captor.getAllValues() ;
        assertEquals("someString1",allValues.get(0));
        assertEquals("someString2",allValues.get(1));

    }

    @Test
    public  void mocking(){

        ArrayList arrayListmock = mock(ArrayList.class) ;
        System.out.println( arrayListmock.get(0) ); // null
        System.out.println(arrayListmock.size() );  // 0
        System.out.println(arrayListmock.add( "Test1") );
        System.out.println(arrayListmock.add( "Test2"))  ;

        // Mock does not retain behaviour (code) of the Original class !
        System.out.println( arrayListmock.size() );  // This is 0

        when(arrayListmock.size()).thenReturn(5) ;
        System.out.println( arrayListmock.size() ); // 5

    }

     @Test
    public  void Spying(){
        ArrayList arrayListSpy = spy(ArrayList.class) ;
        arrayListSpy.add("Test") ;
        System.out.println( arrayListSpy.get(0) ); // Exception if not add
        System.out.println(arrayListSpy.size() );  // 1
        arrayListSpy.add( "Test1") ;
        arrayListSpy.add( "Test2") ;

        // Spy does retain behaviour (code) of the Original class !
        System.out.println( arrayListSpy.size() );  // This is 3 not 0

        when(arrayListSpy.size()).thenReturn(5) ;
        System.out.println( arrayListSpy.size() ); // 5

//        Remember
          arrayListSpy.add("I am at 4 but it show size as 5") ;
        System.out.println(arrayListSpy.size()); // 5

         // Verify
         verify(arrayListSpy).add("I am at 4 but it show size as 5") ;

    }

}
