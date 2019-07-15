import java.io.*;  // import file
import java.util.Scanner; // import keyboard Scanner
/**
Name: Michael Garrison
Date: 2/19/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/
public class SequenceTest{
    public static void main(String[] args) throws IOException {
Sequence sequence; //create instance of sequence
        
Scanner kb = new Scanner(System.in); //create scanner object
       
System.out.print("Enter a file name:"); //get file name
String fileName = kb.nextLine(); //declare string
        
File file = new File(fileName); //open the file
Scanner fin = new Scanner(file); //declare scanner file in

while (fin.hasNext()) { //start while loop structure
String a = fin.next(); 
        if(a.equals("A")){ //if the sequence is arithmetic
        double n = fin.nextDouble();  //get first term
        double d = fin.nextDouble(); //get common difference
        sequence = new ArithmeticSequence(n,d); //pass first term and common difference to ArithmeticSequence method
        System.out.println("The first 10 terms in the sequence are: ");
        System.out.println(sequence.toString()); //prints out first 10 terms
        System.out.println("The sum of the first 5 terms = " + sequence.toString()); //prints out sum of first 5 terms
        
        }
        else if(a.equals("G")){ //if the sequence is geometric
        double n = fin.nextDouble();  //get first term
        double r = fin.nextDouble(); //get common ratio
        sequence = new GeometricSequence(n,r); //pass first term and common ratio to GeometricSequence method
        System.out.println("The first 10 terms in the sequence are: ");
        System.out.println(sequence.toString()); //prints out first 10 terms
        System.out.println("The sum of the first 5 terms = " + sequence.toString()); //prints out sum of first 5 terms
        }
        else if(a.equals("F")){ //if the sequence is geometric
        double n = fin.nextDouble(); //get first term
        double s = fin.nextDouble(); //get second term
        sequence = new FibonacciSequence(n,s); //pass first term and second term to GeometricSequence method
        sequence.toString();
        System.out.println("The first 10 terms in the sequence are: ");
        System.out.println(sequence.toString()); //prints out first 10 terms
        System.out.println("The sum of the first 5 terms = " + sequence.toString()); //prints out sum of first 5 terms
        }
        else{ //else do nothing
        }
         }
    }
}