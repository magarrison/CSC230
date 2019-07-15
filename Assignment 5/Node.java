/**
Name: Michael Garrison
Date: 4/1/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/

public class Node<T> {

    private T data; // entry in set
    private Node next; // link to next node

    public Node(T dataPortion) {
        this(dataPortion, null);
    } // end constructor

    public Node(T dataPortion, Node nextNode) {
        data = dataPortion;
        next = nextNode;
    } // end constructor

    public T getData() {
        return data;
    } // end getData

    public void setData(T newData) {
        data = newData;
    } // end setData

    public Node getNextNode() {
        return next;
    } // end getNextNode

    public void setNextNode(Node nextNode) {
        next = nextNode;
    } // end setNextNode;

} // end Node
