import java.util.*;
public class qfiveofstacks {
 public static void main(String[] args) {
    System.out.println("Enter a heterogram password");
     Scanner sc = new Scanner(System.in);
     String password = sc.next();

     int passwordLength = password.length();

     Stack<Character> letters = new Stack<>();

     for (int i = 0; i < passwordLength; i++) {
         letters.push(password.charAt(i));
     }
     

     String reversedPassword = " ";

     //keep removing the top letter until it is empty. store the popped letter in reversedPassword
     while (!letters.isEmpty()) {
            reversedPassword += letters.pop();
        }
         System.out.println("Reversed password: " + reversedPassword);

        // Check whether the locker opens
        if (reversedPassword.equals(password)) {
            System.out.println("The locker is open.");
        } else {
            System.out.println("The locker is still locked.");
        }

        sc.close();

 }
}
