/**
Name: Michael Garrison
Date: 2/19/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/
public class FibonacciSequence extends Sequence implements SequenceOps{
    private double secondTerm; //declares second term variable
    
public FibonacciSequence(){ //default constructor
    super(); //sets first term to 1
    secondTerm = 1; //sets second term to 1
}

public FibonacciSequence(double n, double s){ //constructor that takes parameters
    super(n); //passes first term to SequenceOps
    secondTerm = s; //sets second term
}

    @Override
    public double getTerm(double n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getSum(double n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
