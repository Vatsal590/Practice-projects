import java.util.*;
public class qsixofstacks {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        
        Stack<String> commands = new Stack<>();

        commands.push("Delete word");
        commands.push("Insert image");
        String word = commands.peek();

        System.out.println(word);
    }
}
