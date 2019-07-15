/**
Name: Michael Garrison
Date: 4/29/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/

public class ListTest {

    public static void main(String[] args) {
        System.out.println("Creating an empty list.");
        ArrayList list = new  ArrayList();
        testIsEmpty(list, true);
        displayList(list);
        int[] contentsOfList = {45,23,89,2,67,10,456,0};
        testAdd(list, contentsOfList);
        testIsEmpty(list, false);
        testIsFull(list, false);
    } // end main

// Precondition: If list is empty, the parameter empty should be true, else false.   
    private static void testIsEmpty(ArrayList list, boolean empty) {
        System.out.print("\nTesting isEmpty with ");
        if (empty) {
            System.out.println("an empty list:");
        } else {
            System.out.println("a list that is not empty:");
        }
        System.out.print("isEmpty finds the list ");
        if (empty && list.isEmpty()) {
            System.out.println("empty: OK.");
        } else if (empty) {
            System.out.println("not empty, but it is: ERROR.");
        } else if (!empty && list.isEmpty()) {
            System.out.println("empty, but it is not empty: ERROR.");
        } else {
            System.out.println("not empty: OK.");
        } // end if
    } // end testIsEmpty

 // Tests the method isFull: correctResult indicates what isFull should return.   
    private static void testIsFull(ArrayList list, boolean correctResult) {
        System.out.print("\nTesting the method isFull with ");
        if (correctResult) {
            System.out.println("a full list:");
        } else {
            System.out.println("a list that is not full:");
        }
        System.out.print("isFull finds the list ");
        if (correctResult && list.isFull()) {
            System.out.println("full: OK.");
        } else if (correctResult) {
            System.out.println("not full, but it is full: ERROR.");
        } else if (!correctResult && list.isFull()) {
            System.out.println("full, but it is not full: ERROR.");
        } else {
            System.out.println("not full: OK.");
        } // end if
    } // end testIsFull

  // Tests the method add.
    private static void testAdd(ArrayList list, int[] content) {
        System.out.print("Adding to the list: ");
        for (int index = 0; index < content[index]; index++) {
            list.addToEnd(content);
        } // end for
        System.out.println();
        displayList(list);
    } // end testAdd

 // Tests the method toArray while displaying the list.
    private static void displayList(ArrayList list) {
        System.out.println("The list contains " + list.getCurrentSize()
                + " string(s), as follows:");
        Object[] listArray = list.toArray();
        for (int index = 0; index < listArray.length; index++) {
            System.out.print(listArray[index] + " ");
        } // end for
        System.out.println();
    } // end displayList
} // end ListTest