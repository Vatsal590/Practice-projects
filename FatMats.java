import java.util.LinkedList;
import java.util.Queue;

public class FatMats {
    public static void main(String[] args) {

        System.out.println("Welcome to Fat Mat's BBQ. Can I take your order");
        Queue<String> foodline = new LinkedList<String>(); // tend to be good 1 point questions

        foodline.add("Vatsal");
        foodline.add("Mr. Cooper");
        foodline.add("Dom");
        foodline.add("Cinar");

        System.out.println("Customers in line: " + foodline); // this prints as an array with brackets
        // this is not acceptable in test. In test, we use loops to print out the names

        System.out.println("current customer: " + foodline.poll()); //takes it out of the queue, we never see it again. similar to .pop in stacks
        System.out.println("customer next in line: " + foodline.peek()); // just peek
        System.out.println(foodline);

        System.out.println("We have this many customers waiting: " + foodline.size());

        //peek vs element - element would give error. peek would say nothing if the queue was empty
        // serve and poll  are the same. 
        
        /*
 * DEFINITIONS:
 * - .offer(item): Adds a new item to the BACK of the queue (returns false if full).
 * - .serve() / .poll(): Removes and returns the item at the FRONT of the queue (returns null if empty).
 *
 * CONCEPT: First-In, First-Out (FIFO). The first person to join the line is the first to be served.
 */

    }
}
