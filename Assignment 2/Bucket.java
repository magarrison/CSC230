/**
Name: Michael Garrison
Date: 2/11/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/

public class Bucket<T>{   

 private int quantity;     //declare private int quanitity to keep count of what's in the bucket
 
public Bucket(){           //default constructor
}

/**
 * Method to add Items to the Bucket
*/

public void addItem(T item){
  quantity++;               //increments the counter variable quantity
}
/**
 * Method to report if the Bucket is empty.
*/
public boolean isEmpty(){
 if (quantity > 0){        
     return false;
 }
 else{
     return true;
 }
}
}


