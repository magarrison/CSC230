/**
Name: Michael Garrison
Date: 2/19/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/
public class ArithmeticSequence extends Sequence implements SequenceOps{
    private double commonDifference; //declares common difference variable
    
public ArithmeticSequence(){ //default constructor
    super(); //sets first term to 1
    commonDifference = 0; //sets common difference to 0
}

public ArithmeticSequence(double n, double d){ //constructor that takes parameters
    super(n); //passes first term to SequenceOps
    commonDifference = d; //sets common difference
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