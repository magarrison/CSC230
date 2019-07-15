/**
Name: Michael Garrison
Date: 3/24/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/

public class ArraySet<T> implements SetInterface<T>{
    private final T[] set;
    private static final int defaultCapacity = 25;
    private int numberOfEntries;
    
    //Creates an empty set whose initial capacity is 25.
    public ArraySet(){
        this(defaultCapacity);
    } //end default constructor
    
    //Creates an empty set having a given initial capacity.
    public ArraySet(int capacity){
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempSet = (T[]) new Object[capacity];
        set = tempSet;
    } //end constructor
    
     //Adds a new entry to this set. Returns true if the addition is successful, or false if not
    public boolean add(T newEntry){
        boolean result = true;
        if(!(isEmpty())){
            result = false;
        }
        else if(contains(newEntry)){
            result = false;
        }
        else{
            set[numberOfEntries] = newEntry;
            numberOfEntries++;
        } //end if
        return result;
    } //end add
    
    //Removes one unspecified entry from this set, if possible. Returns either the removed entry, if the removal was successful, or null
    public T remove(){
        T result = null;
        if(numberOfEntries > 0){
            numberOfEntries--;
            result = set[numberOfEntries];
            set[numberOfEntries] = null;
            } //end if
        return result;
    } //end remove
    
    //Removes the occurance of a given entry from this set, if possible. Returns true if removal was successful, or false if not
    public boolean remove(T anEntry){
        boolean result = contains(anEntry);
        if(result == true){
            remove();
        }
        return result;
   } //end second remove
    
    //Sees whether this set is full. Returns true if the set is full, or false if not
    public boolean isFull(){
        return numberOfEntries == set.length;
    } //end isFull
    
    //Sees whether this set is empty. Returns true if the set is empty, or false if not
    public boolean isEmpty(){
        return numberOfEntries == 0;
    } //end isEmpty
    
    //Gets the current number of entries in this set. Returns the integer number of entries currenly in the set
    public int getCurrentSize(){
        return numberOfEntries;
    }
    
   //Removes all entries from this set.
    public void clear(){
        while (!isEmpty()){
            remove();
        }
    } //end clear
    
     //Tests whether this set contains a given entry. Return true if the set contains anEntry, or false otherwise
    public boolean contains(T anEntry){
        boolean found = false;
        for(int i=0; !found && (i < numberOfEntries); i++){
            if(anEntry.equals(set[index])){
                found = true;
            } //end if
        } //end for
        return found;
    } //end contains
    
    //Retrieves all entries that are in this set.
    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new  Object[numberOfEntries];
        for(int i=0; i < numberOfEntries; i++){
            result[i] = set[i];
        } //end for
        return result;
    } //end toArray
    
    //Adds the elements in two different sets and combines them into one set. Returns a set with all of the elements of this set and the specified set.
    public T[] union(T[] array1, T[] array2){
        T[] total = null;
        total = (T[]) new Object[array1.length+array2.length];
        for(int i=0; i < array1.length; i++){
            total[i] = array1[i];               
            }
        for(int i=0; i < array2.length; i++){
            total[array1.length + i] = array2[i];
        }
        T[] inter = intersection(array1, array2);
        T[] union = (T[]) new Object[total.length - inter.length -1];
        int j=0;
        for(int i=0; i < total.length; i++){
            for(int k=0; k < inter.length; k++){
                if(total[i] != inter[k]){
                    union[j] = total[i];
                    j++;
                }
            }
        }
        return union;
    } //end union
   
    //Takes a set and returns a set with all of the common elements between the set and the specified set.
    public T[] intersection(T[] array1, T[] array2){
        int length = 0;
        for(int i=0; i < array1.length;  i++){
            for(int j=0; j < array2.length; j++){
                if(array1[i] == array2[j]){
                    length++;
                }
            }
        }
        @SuppressWarnings("unchecked")
        T[] array3 = (T[]) new Object[length];
        for(int i=0; i < array1.length; i++){
            for(int j=0; j < array2.length; j++){
                if(array1[i] == array2[j]){
                    array3[length - i] = array1[i];
                    length--;
                }
            }
        }
        return array3;
    }
}