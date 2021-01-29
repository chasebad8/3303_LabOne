package sandwich_factory;

import java.util.Hashtable;

/**
 * Ingredients for a sandwich can be placed and
 * taken off of the table.  A count of the total
 * number of sandwich's made is kept.
 * 
 * @author chase
 *
 */
public class Table {
	
	//total number of sandwich's made
	private int sandwichCount;
	
	//A hashtable that contains the 3 ingredients
	private Hashtable<String, Boolean> ingredients;
	
	//a boolean if the table is empty or not
	private boolean empty;
	
	public Table() {
		this.empty = true;
		this.sandwichCount = 0;
		this.ingredients = new Hashtable<String, Boolean>();
		this.ingredients.put("bread", false);
		this.ingredients.put("butter", false);
		this.ingredients.put("jam", false);
	}
	
	/**
	 * The Agent calls this class to place two ingredients onto the table
	 * 
	 * @param ingredientOne The first ingredient
	 * @param ingredientTwo The second ingredient
	 */
	public synchronized void putIngredients(String ingredientOne, String ingredientTwo) {
		while(!this.empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		
		this.empty = false;
		this.ingredients.replace(ingredientOne, true);
		this.ingredients.replace(ingredientTwo, true);
		notifyAll();
	}
	
	/**
	 * The Chef checks the current ingredients on the hashtable
	 * 
	 * @return a hashtable containing with the current ingredients on the table set as true
	 */
	public synchronized Hashtable<String, Boolean> checkIngredients() {
		while(this.empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				return null;
			}
		}
		notifyAll();
		return this.ingredients;
	}
	
	/**
	 * The Chef calls this when the two ingredients on the table are the ones that they need
	 * This function also adds to the sandwich count, and then clears the table.
	 */
	public synchronized void getIngredients() {
		while(this.empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		
		this.sandwichCount ++;
		
		if(this.sandwichCount >= 20) {
			System.out.println("\n20 Sandwiches have been made!");
			System.exit(0);
		}
		
		this.ingredients.replace("bread", false);
		this.ingredients.replace("butter", false);
		this.ingredients.replace("jam", false);
		this.empty = true;
		notifyAll();
	}
	
}
