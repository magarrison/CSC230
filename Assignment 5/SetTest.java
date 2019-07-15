/**
Name: Michael Garrison
Date: 4/1/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/

public class SetTest {

    public static void main(String[] args) {
        System.out.println("Creating an empty set.");
        SetInterface<String> aSet = new LinkedSet<String>();
        testIsEmpty(aSet, true);
        displaySet(aSet);
        String[] contentsOfSet = {"A", "D", "B", "A", "C", "A", "D"};
        testAdd(aSet, contentsOfSet);
        testIsEmpty(aSet, false);
        testIsFull(aSet, false);
    } // end main

// Precondition: If set is empty, the parameter empty should be true, else false.   
    private static void testIsEmpty(SetInterface<String> set, boolean empty) {
        System.out.print("\nTesting isEmpty with ");
        if (empty) {
            System.out.println("an empty set:");
        } else {
            System.out.println("a set that is not empty:");
        }
        System.out.print("isEmpty finds the set ");
        if (empty && set.isEmpty()) {
            System.out.println("empty: OK.");
        } else if (empty) {
            System.out.println("not empty, but it is: ERROR.");
        } else if (!empty && set.isEmpty()) {
            System.out.println("empty, but it is not empty: ERROR.");
        } else {
            System.out.println("not empty: OK.");
        } // end if
    } // end testIsEmpty

 // Tests the method isFull: correctResult indicates what isFull should return.   
    private static void testIsFull(SetInterface<String> aSet, boolean correctResult) {
        System.out.print("\nTesting the method isFull with ");
        if (correctResult) {
            System.out.println("a full set:");
        } else {
            System.out.println("a set that is not full:");
        }
        System.out.print("isFull finds the set ");
        if (correctResult && aSet.isFull()) {
            System.out.println("full: OK.");
        } else if (correctResult) {
            System.out.println("not full, but it is full: ERROR.");
        } else if (!correctResult && aSet.isFull()) {
            System.out.println("full, but it is not full: ERROR.");
        } else {
            System.out.println("not full: OK.");
        } // end if
    } // end testIsFull

  // Tests the method add.
    private static void testAdd(SetInterface<String> aSet, String[] content) {
        System.out.print("Adding to the set: ");
        for (int index = 0; index < content.length; index++) {
            aSet.add(content[index]);
            System.out.print(content[index] + " ");
        } // end for
        System.out.println();
        displaySet(aSet);
    } // end testAdd

 // Tests the method toArray while displaying the set.
    private static void displaySet(SetInterface<String> aSet) {
        System.out.println("The set contains " + aSet.getCurrentSize()
                + " string(s), as follows:");
        Object[] setArray = aSet.toArray();
        for (int index = 0; index < setArray.length; index++) {
            System.out.print(setArray[index] + " ");
        } // end for
        System.out.println();
    } // end displaySet
} // end SetTest