/**
Name: Michael Garrison
Date: 2/19/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/
public abstract class Sequence implements SequenceOps{
private double firstTerm; //declares variable first term
    
public Sequence(){ //default constructor
        firstTerm = 1; //sets the first term to 1
}

public Sequence(double n){ //constructor that takes parameters
    firstTerm = n; //sets first term
}

public double getFirstTerm(){ //method to get the first term
    return firstTerm; //returns the first term
}
    
public String toString(){ //method to write string
    return super.toString(); //passes results from SequenceOps and returns them as Strings
}
    
}