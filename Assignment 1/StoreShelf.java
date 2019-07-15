/**
Name: Michael Garrison
Date: 1/28/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/
public class StoreShelf {
	/**
	 * The spaces on the shelf. Each array element holds a reference
	 * to a Product that is displayed in that space.
	 * A null reference indicates an empty space.
	 */
	private Product[][] spaces;
	
	public StoreShelf(int m, int n) {
		spaces = new Product[m][n];
	}
	
	/**
	 * Method to add Products to the StoreShelf
	 */
	public void addProduct(int m, int n, Product p) {
		spaces[m][n] = p;
	}
	
	/**
	 * Returns the price of the Product with the specified name. 
	 * Returns -1 if there is no Product with the specified name.
	 * NO 2 PRODUCTS WILL HAVE THE SAME NAME
	 */
        public double getPrice(String productName){
           double price; //declares the double variable price
           price = productName.getPrice(); //gets the price of the product by calling the getPrice method in Product.java
           return price; //returns the price to the method that called it
        }
	
	/**
	 * Checks each space, if the Product count is below 10,
	 * the Product Information should be printed to Standard Out
	 * Once all spaces have been checked the line
	 * 'End of List' should be printed.
	 */
	public void printRestockList() {
            if(spaces.getCount() < 10) { //starts decision structure to determine if Product count is below 10 by calling getCount method in Product.java
                System.out.println(spaces.toString()); //prints the Product Information out by calling the toString method in Product.java
                System.out.println("End of List"); //prints out the String 'End of List' to signify the end of the list.
            }
            else { //if Product count is greater than or equal to 10, do nothing.
            }
        }
}