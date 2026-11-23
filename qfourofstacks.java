import java.util.Stack;
public class qfourofstacks {
    public static void main(String[] args) {
        Stack<String> cities = new Stack<>();
        cities.push("Paris");
        cities.push("LA");
        cities.push("Barcelona");
        cities.push("Delhi");
        cities.push("Tokyo");

        String cityToFind = "Paris";

        int position = cities.search(cityToFind);

        if(position != -1){
            System.out.println("The city is in the iternary list");
            System.out.println("Here is the list " + cities);// prints it in the incorrect order for some reason.
            System.out.println("Its position is " + position);
            
        } 
        
    }
}
