/**
Name: Michael Garrison
Date: 3/24/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/

public interface SetInterface<T>{
    //Gets the current number of entries in this set. Returns the integer number of entries currenly in the set
    public int getCurrentSize();
    //Sees whether this set is full. Returns true if the set is full, or false if not
    public boolean isFull();
    //Sees thether this set is empty. Returns true if the set is empty or false if not
    public boolean isEmpty();
    //Adds a new entry to this set. Returns true if the addition is successful, or false if not
    public boolean add(T newEntry);
    //Removes one unspecified entry from this set, if possible. Returns either the removed entry, if the removal was successful, or null
    public T remove();
    //Removes the occurance of a given entry from this set, if possible. Returns true if removal was successful, or false if not
    public boolean remove(T anEntry);
    //Removes all entries from this set.
    public void clear();
    //Tests whether this set contains a given entry. Return true if the set contains anEntry, or false otherwise
    public boolean contains(T anEntry);
    //Retrieves all entries that are in this set.
    public T[] toArray();
    //Adds the elements in two different sets and combines them into one set. Returns a set with all of the elements of this set and the specified set.
    public T[] union(T array[]);
    //Takes a set and returns a set with all of the common elements between the set and the specified set.
    public T[] intersection();
    //Takes a set and returns a set with all of the elements in this set, that are not in the specified set.
    public T[] difference();
}