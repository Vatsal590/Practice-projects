import java.util.Stack;
import java.util.Scanner;

public class StackMirrorCipher {
    public static void main(String[] args) {
        //instantiate a stack data structure

        Stack<Character> msg_stack = new Stack<Character>();
        //scanner calss to input data

        Scanner scan = new Scanner(System.in);

        //print a message to the user to input a message

        System.out.println("Please enter a message to reverse");

        //get data/message from user
        
        String message = scan.nextLine().trim().toUpperCase();

        
        //instantiate a blank string to hold the reverse message
        String reverse = "";

        //loop through each letter in the message, reverse it
        // pushing the letter onto the stack

        for (int i = 0; i < message.length(); i++) {
            msg_stack.push(message.charAt(i)); // automatically reverses the message
        }

        
        //check if it is (not) empty

        while(!msg_stack.isEmpty()){
            reverse += msg_stack.pop(); // adding the letter that is popped of one by one to reverse
            // reverse += msg_stack.pop(); is the same as reverse = reverse + mas_stack.pop();
        }

        //pop it off the stack and add it to the revesed msg variable

        System.out.println("\nReversed messgae:");
        System.out.println(reverse);

        //print out the reversed msg

    }
}

// do this not only with a stack but a loop and array

//part 2- do with arrays and loops that count down
// part 3 - do from reversed to normal message
// part 3





/*

for notes, if there is array. we dont use () in the for loops for .length
*/