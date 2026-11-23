
import java.util.Stack;
class Main {
    public static void main(String[] args) {
        Stack <String> books = new Stack <String>();
        books.add("Harry Potter");
        books.add("Bible");
        books.add("Encyclopedia");
        books.add("percy jackson");
        books.add("book");

        System.out.println(books.size());
        System.out.println(books.peek());

    }
}