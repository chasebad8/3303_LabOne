package sandwich_factory;

/**
 * 
 * <h1> The Agent makes ingredients for the Chef to
 * 		make a sandwich with! <h1>
 * 
 * The Agent places two unique ingredients on the 
 * Table for the Chef to take.  The Agent then waits
 * until the Chef is done with the ingredients
 * @author chase
 *
 */
public class Agent implements Runnable {
	
	//The two ingredients that randomly get made
	private String ingredientOne;
	private String ingredientTwo;
	
	//Stores all the ingredients on the table and other control data
	private Table table;
	
	public Agent(Table table) {
		
		this.table = table;
		this.ingredientOne = null;
		this.ingredientTwo = null;
	}
	
	/**
	 * Use java's Math library to generate a random value
	 * @return a random value either "bread", "jam", or "butter"
	 */
	public String generateRandomIngredient() {
		String[] ingredients = {"bread", "jam", "butter"};
		int randomIngredient = (int) (Math.random() * 3);
		return ingredients[randomIngredient];
	}
	
	/**
	 * Change the local ingredient variables to contain values
	 */
	public void findIngredients() {
		this.ingredientOne = this.generateRandomIngredient();
		this.ingredientTwo = this.generateRandomIngredient();
		
		while(true) {
			if(this.ingredientTwo.equals(this.ingredientOne)) {
				this.ingredientTwo = this.generateRandomIngredient();
			}
			else {
				break;
			}
		}
	}
	
	/**
	 * Create two unique random ingredients, and then
	 * place them on the table whenever the table is empty
	 */
	public void run() 
	{
		while(true) {
			this.findIngredients();
			System.out.println("Ingredients: " + this.ingredientOne + ", " + this.ingredientTwo);
			this.table.putIngredients(this.ingredientOne, this.ingredientTwo);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
	}
}
