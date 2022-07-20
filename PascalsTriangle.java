/*
 * Solution to LeetCode "Pascal's Triangle" challenge - Jason Lawrence, July 19, 2022. 
 * Given an integer numRos, return the first numRows of Pascal's triangle"
 */



package leetCodeChallenge1;

import java.util.*;
import java.lang.*;

class PascalsTriange {
    public List<List<Integer>> generate(int numRows) {
       
       
       
    /*for numRows --
        create an array of arrays(of ints)  **note: using "ArrayList here instead of Array because LeetCode method definition requires a List<> to be returned; it seems memory 
        and space inefficient to complete the problem using arrays and then use java libraries to convert from array to an ArrayList before returning that from the function.
       
        General overview:
        
        -make an arrayList of arrayLists(Integers), uninitialized with values for now. (see note above)
        -populate the first row with 1 (per problem parameters, 1 <= numRows <=30)
        -for subsequent rows, add each ArrayList one at a time and populate its values using the algorithm below (first and last values of each row are always equal to 1 in value;
        -elements that are *not* the first or last index of a row are assigned a value based on a sum the row prior (row - 1). -> see line 49.
                     
        */
       
       List<List<Integer>> masterArray = new ArrayList<List<Integer>>();
       
       
        List<Integer> row0 = new ArrayList<Integer>();
        row0.add(1);    //creating row 1 (always exists)
        masterArray.add(row0);                //and populating it with value of 1.
           
           
        for(int i = 1; i < numRows; i++){    //adding additional rows after row 0 (uninitialized values)
        List<Integer> newRow = new ArrayList<Integer>();
           
               
        for(int j = 0; j <=i ; j++)      
                  //adding
                if(j == 0 || j == i){
                    newRow.add(j, 1);
                }
                else{
                    newRow.add(masterArray.get(i-1).get(j-1)+ masterArray.get(i-1).get(j) );
                }
           
            masterArray.add(newRow);   //add the new row once initialized
        }
           
       
        return masterArray;
       
    }
}
