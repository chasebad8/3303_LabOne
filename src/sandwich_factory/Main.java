package sandwich_factory;

/**
 * Create 1 Table, 3 Chef, and 1 Agent objects.  
 * Pass the Chefs and Agent as a Thread argument.
 * Pass the Table object into all of the Chef and 
 * Agent objects
 * 
 * @author chase
 *
 */
public class Main {

	public static void main(String[] args) {
		
		//create a new Table object
		Table table = new Table();
		
		//Create 4 new threads
		Thread chefBread = new Thread(new Chef("bread", table), "chefBread");
		Thread chefJam = new Thread(new Chef("jam", table), "chefJam");
		Thread chefButter = new Thread(new Chef("butter", table), "chefButter");
		Thread agent = new Thread(new Agent(table), "agent");
		
		//call the start() method that comes with the Thread class
		chefBread.start();
		chefJam.start();
		chefButter.start();
		agent.start();
	}

}