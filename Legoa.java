import java.util.Stack;

public class Legoa {
    public static void main(String[] args){
        System.out.println("Lego Stack Exercise");
        Stack<Character> colors = new Stack<Character>(); // you are calling a new constructor

        //add to the stack
        colors.add('y'); // for char single quots. with stacks we can reverse things.
        colors.add('b');
        colors.add('r');
        colors.add('g');
        colors.add('p');

        System.out.println(colors);

        for (int i = 0; i < colors.size(); i++) {
            System.out.println("Colours on the stack");
            System.out.println(colors.pop());
        }


    }
}
