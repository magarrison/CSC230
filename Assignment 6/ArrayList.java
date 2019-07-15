import java.util.Arrays;
/**
Name: Michael Garrison
Date: 4/17/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/

public class ArrayList<T>{
    private T[] list; // array of list entries
    private int numberOfEntries;
    private static final int defaultCapacity = 25;
    
   //Creates an empty list whose initial capacity is 25.
   public ArrayList(){
        this(defaultCapacity);
    } //end default constructor
    
   //Creates an empty list having a given initial capacity. 
   public ArrayList(int initialCapacity){
        numberOfEntries = 0;
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempList = (T[])new Object[initialCapacity];
        list = tempList;
    } // end constructor
    
    public void addToBeginning(T newEntry){
        //for every element in array(in reverse order)
        for(int j = numberOfEntries; j > 0; j++){
            list[j] = list[j-1];
        }
        //add new element
        list[0] = newEntry;
        numberOfEntries++;
    }
    
    public void addToEnd(T newEntry){
        ensureCapacity();
        list[numberOfEntries] = newEntry;
        numberOfEntries++;
    } // end addToEnd
    
   public boolean add(int newPosition, T newEntry){
       boolean isSuccessful = true;
       if((newPosition >= 1) && (newPosition <= numberOfEntries +1)){
           ensureCapacity();
           makeRoom(newPosition);
           list[newPosition -1] = newEntry;
           numberOfEntries++;
       }
       else{
           isSuccessful = false;
       }
       return isSuccessful;
   } // end add  
   
   //Removes one unspecified entry from the list, if possible. Returns either the removed entry, if the removal was successful, or null
    public T remove(){
        T result = null;
        if(numberOfEntries > 0){
            numberOfEntries--;
            result = list[numberOfEntries];
            list[numberOfEntries] = null;
            } //end if
        return result;
    } //end remove
   
   public T remove(int givenPosition){
       T result = null; // return value
       if((givenPosition >= 1) && (givenPosition <= numberOfEntries)){
           assert !isEmpty();
           result = list[givenPosition -1]; // get entry to be removed
           // move subsequent entries toward entry to be removed, unless it is last in list
           if(givenPosition < numberOfEntries){
               removeGap(givenPosition);
           }
           numberOfEntries--;
       } // end if
       return result; //return reference to removed entry, or null if either list is empty or givenPosition is invalid.
   } // end remove
   
   //Sees whether this list is empty. Returns true if the list is empty, or false if not
   public boolean isEmpty(){
       return numberOfEntries == 0; // or getLength() == 0
   } //end isEmpty
   
   public void clear(){
       while (!isEmpty()){
        remove();
       }
   } // end clear
   
   // Tests whether this list contains a given entry.
   public boolean contains(T anEntry){
       boolean found = false;
       for(int i=0; !found && (i < numberOfEntries); i++){
           if(anEntry.equals(list[i])){
               found = true;
           }
       } // end for
       return found;
   }
   
   // Counts the number of times a given entry appears in this list.
   public int getFrequencyOf(T anEntry){
       int counter = 0;
       for(int i=0; i < numberOfEntries; i++){
           if(anEntry.equals(list[i])){
               counter++;
           } // end if
       } // end for
       return counter;
   } // end getFrequencyOf
   
   // Makes room for a new entry at newPosition.
   // Precondition: 1 <= newPosition <= numberOfEntries+1; numberOfEntries is list's length before addition.
   private void makeRoom(int newPosition){
       assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1);
       int newIndex = newPosition - 1;
       int lastIndex = numberOfEntries - 1;
       //move each entry to next higher index, starting at end of list and continuing until the entry at newIndex is moved
       for(int i=lastIndex; i >= newIndex; i--){
           list[i+1] = list[i];
       } // end for
   } // end makeRoom
   
   // Shifts entries that are beyond the entry to be removed to the next lower position.
   // Precondition: 1 <= givenPosition < numberOfEntries; numberOfEntries is list's length before removal.
   private void removeGap(int givenPosition){
       assert (givenPosition >= 1) && (givenPosition < numberOfEntries);
       int removedIndex = givenPosition - 1;
       int lastIndex = numberOfEntries - 1;
       for(int i=removedIndex; i < lastIndex; i++){
           list[i] = list[i+1];
       } // end for
   } // end removeGap
   
// Doubles the size of the array list if it is full.
   private void ensureCapacity(){
       if(numberOfEntries == list.length){
           list = Arrays.copyOf(list, 2 * list.length);
       }
   } // end ensureCapacity
} // end ArrayList