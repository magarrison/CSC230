/**
Name: Michael Garrison
Date: 4/17/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/

public class LinkedList<T>{
    private Node firstNode; // reference to first node
    private int numberOfEntries;
    
    public LinkedList(){
        clear();
    } // end default constructor
    
    public final void clear(){
        firstNode = null;
        numberOfEntries = 0;
    } // end clear
    
    public void addToBeginning(T newEntry){
        Node newNode = new Node(newEntry);
        newNode.setNextNode(firstNode);
        firstNode = newNode;
        numberOfEntries++;
    } // end addToBeginning
    
    public void addToEnd(T newEntry){
        Node newNode = new Node(newEntry);
        if(isEmpty()){
            firstNode = newNode;
        }
        else{ // add to end of nonempty list
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode); // makes last node reference new mode
        } // end if
        numberOfEntries++;
    } // end addToEnd
    
    public boolean add(int newPosition, T newEntry){
        boolean isSuccessful = true;
        if((newPosition >= 1) && (newPosition <= numberOfEntries + 1)){
            Node newNode = new Node(newEntry);
            if(newPosition == 1){ // case 1
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            }
            else{ // case 2: list is not empty and newPosition > 1
                Node nodeBefore = getNodeAt(newPosition -1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            } // end if
            numberOfEntries++;
        }
        else{
            isSuccessful = false;
        } // end if
        return isSuccessful;
    } // end add
    
    public T remove(int givenPosition){
        T result = null;
        if((givenPosition >= 1) && (givenPosition <= numberOfEntries)){
            assert !isEmpty();
            if(givenPosition == 1){
                result = (T) firstNode.getData();
                firstNode = firstNode.getNextNode();
            }
            else{
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);
                result = (T) nodeToRemove.getData();
            } // end if
            numberOfEntries--;
        } // end if
        return result;
    } // end remove
    
    // Sees whether this list is empty. Returns true if the list is empty, or false if not
    public boolean isEmpty(){
        boolean result;
        if (numberOfEntries == 0){ // or getLength() == 0
            assert firstNode == null;
            result = true;
        }
        else{
            assert firstNode != null;
            result = false;
        } // end if
        return result;
} // end isEmpty
    
    // Tests whether this list contains a given entry.
    public boolean contains(T anEntry){
        boolean found = false;
        Node currentNode = firstNode;
        while(!found && (currentNode != null)){
            if(anEntry.equals(currentNode.getData())){
                found = true;
            }
            else{
                currentNode = currentNode.getNextNode();
            } // end if
        } // end while
        return found;
    } // end contains
    
   // Counts the number of times a given entry appears in this list.
   public int getFrequencyOf(T anEntry){
       int counter = 0;
       Node currentNode = firstNode;
       while(currentNode != null){
           if(anEntry.equals(currentNode)){
               counter++;
           } // end if
           currentNode = currentNode.getNextNode();
       } // end while
       return counter;
   } // end getFrequencyOf
   
   // Returns a reference to the node at a given position.
   // Precondition: The chain is not empty; 1 <= givenPosition <= numberOfNodes
   private Node getNodeAt(int givenPosition){
       assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
       Node currentNode = firstNode;
       // traverse the list to locate the desired node
       for(int i=1; i < givenPosition; i++){
           currentNode = currentNode.getNextNode();
       } // end for
       assert currentNode != null;
       return currentNode;
   } // end getNodeAt
} // end LinkedList