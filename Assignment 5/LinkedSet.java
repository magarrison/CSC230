/**
Name: Michael Garrison
Date: 4/1/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/

public class LinkedSet<T> implements SetInterface<T>{
    private Node firstNode; // reference to first node
    private int numberOfEntries;
   
// Creates an empty set   
    public LinkedSet(){
        firstNode = null;
        numberOfEntries = 0;
} // end default constructor
    
// Sees whether this set is empty. Returns true if the set is empty, or false if not
    public boolean isEmpty(){
        return (numberOfEntries == 0);
} // end isEmpty()
    
    public boolean isFull(){
      return false;
 } // end isFull
    
// Adds a new entry to this set. Returns true if the addition is successful, or false if not
    public boolean add(T newEntry){
        boolean result = true;
        if(!(isEmpty())){ //if the set is full return false
            result = false;
        }
        else if(contains(newEntry)){ // if the item is already in the set, return false
            result = false;
        }
        else{ //adds the item to the set
        firstNode = new Node(newEntry, firstNode);
        numberOfEntries++;
        } // end if
        return result;
} // end add(T newEntry)
    
 // Returns the set as a string
    public String toString(){
        String s = "";
        Node cur = firstNode;
        while(cur != firstNode){
            s += cur.getData().toString();
            cur = cur.getNextNode();
        }
        return s;
} //end toString()
    
  // Gets the current number of entries in this set. Returns the integer number of entries currently in the set
    public int getCurrentSize(){
        return numberOfEntries;
} // end getCurrentSize()
    
 // Tests whether this set contains a given entry. Return true if the set contains anEntry, or false otherwise
    public boolean contains(T anEntry){
        boolean found = false;
        Node currentNode = firstNode;
        
        while(!found && (currentNode != null)){
            if(anEntry.equals(currentNode.getData())){
                found = true;
            }
            else{
                currentNode = currentNode.getNextNode();
            }
        } // end while
        return found;
} // end contains(T anEntry)
    
  public T[] toArray(){
      // the cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // unchecked cast
      int index = 0;
      Node currentNode = firstNode;
      while ((index < numberOfEntries) && (currentNode != null))
      {
         result[index] = (T) currentNode.getData();
         index++;
         currentNode = currentNode.getNextNode();
      } // end while
      return result;
} // end toArray
    
    public T remove(){
        T result = null;
        if (firstNode != null){
            result = (T) firstNode.getData();
            firstNode = firstNode.getNextNode(); // removes first node from chain
            numberOfEntries--;
        } // end if
        return result;
} // end remove()
    
    private Node getReferenceTo(T anEntry){
        boolean found = false;
        Node currentNode = firstNode;
        
        while(!found && (currentNode != null)){
            if(anEntry.equals(currentNode.getData())){
                found = true;
            }
            else{
                currentNode = currentNode.getNextNode();
            }
        } // end while
        return currentNode;
} // end getReferenceTo(T anEntry)

    public boolean remove(T anEntry){
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);
        
        if(nodeN != null){
            nodeN.setData(firstNode.getData()); // replace located entry with entry in first node
            remove();
            result = true;
        } // end if
        return result;
} // end remove(T anEntry)
    
    public void clear(){
        while (!isEmpty()){
            remove();
        }
} // end clear()
    
/**  I am not sure how to design the union, intersection, and difference in a way that will compile. 
     Therefore I have commented out this code.

//Adds the elements in two different sets and combines them into one set. Returns a set with all of the elements of both sets.
    public T[] union(T set1, T set2){
        tmpSet = new Node(newEntry, firstNode);
        for(int i=0; i < set1.getData(); i++){
              tmpSet.add(set1.getNext()); // for all elements in set1 add to tmpSet if possible
          }
        for(int i=0; i < set2.getData(); i++){
               tmpSet.add(set2.getNext()); // for all elements in set2 add to tmpSet if possible
      }
        return tmpSet;
} // end union(T set1, T set2)
    
//Takes two sets and returns a set with all of the common elements between the two sets.
    public T[] intersection(T set1, T set2){
         tmpSet = new Node(newEntry, firstNode);
         for(int i=0; i < set1.getData(); i++){
             if(set2.contains(set1.getData())){ // look at each element in set1 and compare to each element in set2
                 tmpSet.add(set1.getData()); // if the element(set1) = element(set2) then add it to new set
                 }
             }
         return tmpSet;
} // end intersection(T set1, T set2)
    
 //Takes two sets and returns a set with all of the elements in this first set that are not in the second set.
     public T[] difference(T set1, T set2){
         tmpSet = new Node(newEntry, firstNode);
        for(int i=0; i < set1.getData(); i++){
               tmpSet.add(set1.getNext()); // for all elements in set1 add to tmpSet if possible
      }
        for(int i=0; i < set1.getData(); i++){
               if(tmpSet.contains(set2.getData())){ // if tmpSet contains elements in set2
                 tmpSet.remove(set2.getData()); // remove those elements
             }
         }
         return tmpSet;
} //end difference(T set1, T set2)
*/
    
      @Override
    public T[] union(T set1, T set2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T[] intersection(T set1, T set2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T[] difference(T set1, T set2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    } //end LinkedSet
