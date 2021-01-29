package sandwich_factory;

/**
 * <h1>Emulate a Chef making a sandwich!</h1>
 * 
 * Implement the Runnable interface to allow for the use of 
 * java's Threading class.  A Chef may make a sandwich when
 * two of the ingredients they don't have are on the table
 * 
 * @author chase
 *
 */
public class Chef implements Runnable {
	
	//A unique ingredient that each Chef can make
	private String specialty;
	
	//Stores all the ingredients on the table and other control data
	private Table table;
	
	public Chef (String specialty, Table table) {
		this.table = table;
		this.specialty = specialty;
	}
	
	/**
	 * Check if the table has ingredients.  If the table
	 * has ingredients check if it's the right ingredients.
	 * If it is the right ingredients then make a sandwich.
	 */
	public void run() {
		while(true) {
			if(!this.table.checkIngredients().get(this.specialty)) {
				this.table.getIngredients();
				System.out.println("Chef " + this.specialty + " made a sandwich!\n");
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
	}
}
