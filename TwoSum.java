package leetCodeChallenge1;

import java.util.Arrays;


public class TwoSum {
   
   
   
   
    public int[] twoSum(int[] nums, int target) {
       
       int var1 = 0;
       int var2= 0;
       int sum = 0;
       int[] solutionArray = new int[2];
       
       for(int i = 0; i < nums.length; i++){
           for(int j = i+1; j < nums.length; j++){
               sum = nums[i] + nums[j];
               
               if(sum == target){
                   solutionArray[0] = i;
                   solutionArray[1] = j;
                   return solutionArray;
                   
               }
              //else nothing - iterate through inner loop again / j increments
               
             
           }
       }
           
       
       
       
       
        return  solutionArray;
    }
}