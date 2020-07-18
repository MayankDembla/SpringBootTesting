package com.dembla.UnitTesting.buisnesslayer;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class BuisnessClass {

   public int calculateSum(int[] data){
       int sum = 0 ;
       for(int value : data ){
           sum += value ;
       }
       return sum ;
   }


   public int product(int[] input){
       int product = 1  ;

       for(int val : input ){
           product *= val  ;
       }
       return  product ;
   }

}
