import java.util.Stack;
public class reversewithstack {
    public static void main(String[] args) {
        Stack <Character> letters = new Stack<>();
        String word = "cat";

       for(char c : word.toCharArray()){
         letters.push(c);
       }
       StringBuilder rev = new StringBuilder();
       while(!letters.isEmpty()){
        rev.append(letters.pop());
       }
       System.out.println(rev);
    }
}
