/**
Name: Michael Garrison
Date: 2/19/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/
public class GeometricSequence extends Sequence implements SequenceOps{
    private double commonRatio; //declares common ratio variable
    
public GeometricSequence(){ //default constructor
    super(); //sets first term to 1
    commonRatio = 1; //sets common ratio to 1
}

public GeometricSequence(double n, double r){ //constructor that takes parameters
    super(n); //passes first term to SequenceOps
    commonRatio = r; //sets common ratio 
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