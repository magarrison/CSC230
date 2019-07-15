/**
Name: Michael Garrison
Date: 2/11/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/

public class PerishableProduct extends Product{
    
    private int daysOnShelf;  //declare private int daysOnShelf
    private int daysToKeep;   //declare private int daysToKeep

/**
* Specifies the single constructor that uses parameters from the superclass (Product)
*/
public PerishableProduct(String m, double p, int c, int d){
                super(m, p, c);
                daysToKeep = d;
	}
}