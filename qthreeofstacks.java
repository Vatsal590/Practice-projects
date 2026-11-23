import java.util.Stack;
public class qthreeofstacks {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>();
        names.push("John");
        names.push("Tim");
        names.push("Harvey");
        names.push("Mike");
        names.push("Jake");
        
        if (!names.isEmpty()) {
            System.out.println("Students who got on the bus: ");
            

             while (!names.isEmpty()){
            String student = names.pop();
            System.out.println(student + "got on: ");
        }

        System.out.println("All students got on");
        }

       
    }

}
