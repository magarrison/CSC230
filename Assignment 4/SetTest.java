/**
Name: Michael Garrison
Date: 3/24/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/

public class SetTest{
    public static void main(String[] args) {
        // a set that is not full
        SetInterface<String> aSet = new ArraySet<String>();
        
        //tests on an empty set
        testIsFull(aSet, false);
        
        // adding strings
        String[] contentsOfSet1 = {"A","A","B","A","C","A"};
        testAdd(aSet, contentsOfSet1);
        testIsFull(aSet, false);
        
        //a set will be full
        aSet = new ArraySet<String>(7);
        System.out.println("\nA new empty set:");
        
        //tests on an empty set
        testIsFull(aSet, false);
        
        //adding strings
        String[] contentsOfSet2 = {"A","B","A","C","B","C","D"};
        testAdd(aSet, contentsOfSet2);
        testIsFull(aSet, true);
    } //end main
   
    //Tests the method add
    private static void testAdd(SetInterface<String> aSet, String[] content){
        System.out.println("Adding to the bag: ");
        for(int i=0; i < content.length; i++){
            aSet.add(content[i]);
            System.out.println(content[i] + "");
        } //end for
        System.out.println();
        displaySet(aSet);
    } //end testAdd
    
    //Tests the method isFull
    // correntResult indicates what isFull should return
    private static void testIsFull(SetInterface<String> aSet, boolean correctResult){
        System.out.println("\nTesting the method isFull with ");
        if(correctResult){
            System.out.println("a full set:");
        }
        else{
            System.out.println("a set that is not full:");
        }
        System.out.println("isFull finds the set ");
        if(correctResult && aSet.isFull()){
            System.out.println("full: OK.");
        }
        else if(correctResult){
            System.out.println("not full, but it is full: ERROR.");
        }
        else if(!correctResult && aSet.isFull()){
            System.out.println("full, but it is not full: ERROR.");
        }
        else{
            System.out.println("not full: OK.");
        }
    } //end testIsFull
    
    // Tests the method toArray while displaying the set.
    private static void displaySet(SetInterface<String> aSet){
        System.out.println("The set contains the following string(s):");
        Object[] setArray = aSet.toArray();
        for(int i=0; i < setArray.length; i++){
            System.out.println(setArray[i] + "");
        } //end for
        System.out.println();
    } //end displayBag
} //end SetTest