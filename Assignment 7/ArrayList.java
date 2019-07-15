import java.util.Arrays;
/**
Name: Michael Garrison
Date: 4/29/2014
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
   
  //Retrieves all entries that are in this list.
    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new  Object[numberOfEntries];
        for(int i=0; i < numberOfEntries; i++){
            result[i] = list[i];
        } //end for
        return result;
    } //end toArray
   
   //Sees whether this list is full. Returns true if the list is full, or false if not
    public boolean isFull(){
        return numberOfEntries == list.length;
    } //end isFull
   
   //Sees whether this list is empty. Returns true if the list is empty, or false if not
   public boolean isEmpty(){
       return numberOfEntries == 0; // or getLength() == 0
   } //end isEmpty
   
   //Gets the current number of entries in this list. Returns the integer number of entries currenly in the list
    public int getCurrentSize(){
        return numberOfEntries;
    } // end getCurrentSize
   
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
   
   // Swaps two indexes in an array
   private static void swap(Object[] arr, int i, int j){
       Object temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
   } // end Swap
   
  // Finds the index of the smallest value in a portion of an array.
   private static <T extends Comparable<? super T>>
   int getIndexOfSmallest(T[] arr, int first, int last){
       T min = arr[first];
       int indexOfMin = first;
       for(int i = first+1; i <= last; i++){
           if(arr[i].compareTo(min) < 0){
               min = arr[i];
               indexOfMin = i;
           } // end if
           // Assertion: min is the smallest of arr[first] through arr[i]
           } // end for
       return indexOfMin;
       } // end getIndexOfSmallest
   
   //Sorts the first n objects in an array into ascending order.
   public static <T extends Comparable<? super T>>
           void SelectionSort(T[] arr, int n){
               for(int i=0; i < n-1; i++){
                   int indexOfNextSmallest = getIndexOfSmallest(arr, i, n-1);
                   swap(arr, i, indexOfNextSmallest);
                   // Assertion: arr[0] <= arr[1] <= ... <= arr[i] <= all other a[j]
               } // end for
           } // end selectionSort
 
   // Inserts anEntry into the sorted array entries arr[begin] through arr[end]
   public static <T extends Comparable<? super T>>
           void InsertInOrder(int anEntry, int[] arr, int begin, int end){
               if(anEntry >= arr[end]){
                   arr[end + 1] = anEntry;
               }
               else if(begin < end){
                   arr[end+1] = arr[end];
                   InsertInOrder(anEntry, arr, begin, end-1);
               }
               else{ // begin == end and anEntry < arr[end]
                   arr[end+1] = arr[end];
                   arr[end] = anEntry;
               } // end if
           } // end insertInOrder
   
   // Sorts the array entries arr[first] through arr[last] recursively.
   public static <T extends Comparable<? super T>>     
           void InsertionSort(int[] arr, int first, int last){
               if(first < last){
                   // sort all but the last entry
                   InsertionSort(arr, first, last-1);
                   // insert the last entry in sorted order
                   InsertInOrder(arr[last], arr, first, last-1);
               } // end if
           } // end insertionSort
  
  // returns the index of the desiredValue (mid), or -1 if the desiredValue is not in the list          
  public static <T extends Comparable<? super T>> 
           int BinarySearch(int[] arr, int desiredValue, int lBound, int rBound){
               int solution = -1; // returns -1 if the desiredValue is not in the list.
               int mid = ((rBound - lBound)/2);
               if(arr[mid] == desiredValue){
                   solution = mid;
               }
               else if(desiredValue < arr[mid]){
                   solution = BinarySearch(arr, desiredValue, lBound, (mid-1));
               }
               else{
                   solution = BinarySearch(arr, desiredValue, (mid+1), rBound);
               } // end if
               return solution;
           } // end BinarySearch
   } // end ArrayList