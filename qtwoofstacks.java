import java.util.Stack;
public class qtwoofstacks {
    public static void main(String[] args) {
        Stack<Integer> grades = new Stack<Integer>();
        grades.push(95);
        grades.push(92);
        grades.push(97);
        grades.push(96);
        grades.push(99);

        for (int i = 0; i < 3; i++) {
            grades.pop();
        }

        int a = grades.get(0);
        int b = grades.get(1);

        int avg = (a+b)/2;

        System.out.println(avg);

    }
}
