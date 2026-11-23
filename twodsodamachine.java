import java.util.Scanner;
public class twodsodamachine {
    public static void main(String[] args) {
        System.out.println("Enter a drink");
        Scanner sc = new Scanner (System.in);
        String choice = sc.nextLine();
        
        String[][] sodas = {
            {"Cola", "Sprite", "Fanta", "Pepsi"},
            {"Cola", "Sprite", "Fanta", "Pepsi"},         
            {"Cola", "Sprite", "Fanta", "Pepsi"},
            {"Cola", "Sprite", "Fanta", "Pepsi"},
            {"Cola", "Sprite", "Fanta", "Pepsi"},
        };
        /*
        load soda machine
        String[][] sodas = new String[5][5];
        sodas[0][0] = "Coke";
        sodas[0][1] = "Sprite";
        sodas[0][2] = "Fanta";
        sodas[0][3] = "Pepsi";
        sodas[1][0] = "Coke";

        */
        //sell a soda
        for (int row = 0; row < sodas.length; row++) {
            if(sodas[row][1].equalsIgnoreCase("choice")){
                sodas[row][1] = "EMPTY";
                System.out.println(choice + " purchased");
                break;
            }
            System.out.println();
        }

    }


}
