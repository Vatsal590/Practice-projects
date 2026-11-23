
import java.util.*;

public class twodquadrats {
    public static void main(String[] args) {
        int [][] flower_grid = new int[10][10];

        //rondomly populate the quadrat with flowers
        Random rand = new Random();

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                flower_grid[row][col] = rand.nextInt(4); // just counts 0, 1, 2, 3
                
            }// end inner loop
            
        }// end outer loop
        
        // print out the flower_grid using a nested loop
        for (int i = 0; i < flower_grid.length; i++) {
            for (int j = 0; j < flower_grid[i].length; j++) {

                System.out.print(flower_grid[i][j] + " ");
                
            }
            System.out.println();
            
        }
        // create 2d array that tracks if we visited the cell or not yet
        boolean[][] visited = new boolean[10][10];
      

        // randomly pick 10 unique cells out of the 2D array
        int[] samples = new int[10];    // good 2 point q - what happens if scientist needs 12
        int max = flower_grid[0][0];

        // we say arrays are immutable and as we are not guaranteed to get the same 10 initial spaces. 


        int count = 0; // to make sure we are not out of bounds
        while (count < samples.length) {  // then we are not restricted to a specific value

          int row = rand.nextInt(10);
          int col = rand.nextInt(10);
          System.out.println(row + " " + col + " " + flower_grid[row][col]);

          
          if(!visited[row][col]){                      
            
            visited[row][col] = true; // mark cell as true
            samples[count] = flower_grid[row][col];//NOT Adding the coordinate.
              System.out.println("picked cell " + row + " , " + col);
          }
          count++;


        }
      System.out.println("Sampled valued 10 unique cells");
      for(int i =0; i < samples.length; i++){
        System.out.println(samples[i] + " ");
      }

      Stack<int[]> sampleStack = new Stack<>();

      //push our 2d flower arrays on the stack
      sampleStack.push(samples);
      System.out.println(sampleStack);

      //print the results of the method
      int sum = sumStack(samplesStack);
      double avg = averageStack(samplesStack);

      //print out 
      System.out.println("Sum of sampels: " + sum);
      System.out.println("Avg of sampels: " + avg);
      System.out.println("Max number of flowers in a cell: " + max);

    }//end main


    public static void printStack(Stack<int[]> stack){ // public means we have visibility modifiers
      Stack<int[]> temp = (Stack<int[]>) stack.clone(); //parenthesis are casting
      // you have to tell it what class

      while(!temp.isEmpty()){ // ALWAYS CHECK IF IT IS EMPTY. USE of dot notation
        int[] arr = temp.pop();
        System.out.println("Array from Stack: ");
        for (int val : arr) { // type var : data_name
            System.out.println(val + " ");
        } // end of for

        System.out.println();

      }// end of while
    
    }//end of method

     //returns the sum of all integers (eg.. flowers) in all arrays on the stack
     public static int sumStack(Stack<int[]> stack){           // stack is a variable name


      //create a temp stack by cloaning
      Stack<int[]> temp = (Stack<int[]>) stack.clone();
      
      //int total to hold the total
      //while loop that checks if empty, then pops items off the stack
      //uses an acumulator to get the total

      return total;
     }

     //returns the cell with th emx number of flowers
     public static int MaxCell(int[][]flower_grid) {
         //write a nested loop to go through the cell
         //set first set to max
         //if the number of flowers in the next cell is greater than the flowers in the first cell, then it becomes the max
         return max;
     }

     // returns the avg of all integers of all arrays on the stack
     public static double averageStack(Stack<int[]> stack){ // we are passing [] and not [][] because

      //create a temp stack by cloaning
      //int total to hold the total
      //while loop that checks if empty, then pops items off the stack
      //uses an acumulator to get the total
      //divide by the number of arrays that hold 10 samples

      return avg;
     }  

}// end class


