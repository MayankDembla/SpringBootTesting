package com.dembla.UnitTesting.buisnesslayer;

import com.dembla.UnitTesting.services.DataStore;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class BuisnessClass {

  private DataStore dataStore  ;

   public void setDataStore(DataStore dataStore){
       this.dataStore = dataStore ;
   }


   // ############## Api's using the Data Store ########## //

   public int calculateeSum(){

      int[] data = dataStore.retrieveData() ;
      int sum = 0 ;
      for( int val : data)
          sum += val ;

      return  sum ;
   }


   public int product() {

       int[] data = dataStore.retrieveData();
       int product = 1;

       for (int val : data) {
           product *= val;
       }
       return product;
   }

   //   ########## Basic API's  hard Fixed Data ########## //

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
