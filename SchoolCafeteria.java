import java.util.Scanner;
public class CafeteriaMultiReceipt {

    

        String[] foodNames = {"Pizza", "Burger", "Salad", "Fries", "Juice"};
        double[] foodPrices = {3.50, 2.75, 2.00, 1.50, 1.25};

        Scanner scanner = new Scanner(System.in);

        System.out.print("How many friends are ordering today? ");
        int numFriends = scanner.nextInt();

        while (numFriends <= 0) {
            System.out.print("Enter a number greater than 0: ");
            numFriends = scanner.nextInt();
        }

        double grandTotal = 0.0;

        // Takes an order for every friend
        for (int friend = 1; friend <= numFriends; friend++) {

            int[] quantities = new int[foodNames.length];
            double total = 0.0;
            int choice = -1;

            System.out.println("\n===== FRIEND " + friend + "'S ORDER =====");

            // Shows the menu
            for (int i = 0; i < foodNames.length; i++) {
                System.out.printf("%d. %-10s $%.2f%n",
                        i + 1, foodNames[i], foodPrices[i]);
            }

            // Takes orders until the friend enters 0
            while (choice != 0) {
                System.out.println("\n1-5 Add item | 6 Review order | 0 Finish");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                // Add an item
                if (choice >= 1 && choice <= 5) {
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    if (quantity > 0) {
                        int index = choice - 1;

                        quantities[index] += quantity;
                        total += foodPrices[index] * quantity;

                        System.out.println(foodNames[index] + " added.");
                    } else {
                        System.out.println("Quantity must be greater than 0.");
                    }
                }

                // Review current order
                else if (choice == 6) {
                    System.out.println("\n----- CURRENT ORDER -----");

                    for (int i = 0; i < foodNames.length; i++) {
                        if (quantities[i] > 0) {
                            System.out.printf("%-10s x%d%n",
                                    foodNames[i], quantities[i]);
                        }
                    }

                    System.out.printf("Current total: $%.2f%n", total);
                }

                // Checks for invalid choices
                else if (choice != 0) {
                    System.out.println("Invalid option.");
                }
            }

            // Prints a receipt for this friend
            System.out.println("\n====== RECEIPT FOR FRIEND " + friend + " ======");
            System.out.printf("%-10s %5s %10s%n", "Item", "Qty", "Price");
            System.out.println("------------------------------");

            for (int i = 0; i < foodNames.length; i++) {
                if (quantities[i] > 0) {
                    double itemTotal = quantities[i] * foodPrices[i];

                    System.out.printf("%-10s %5d %10.2f%n",
                            foodNames[i], quantities[i], itemTotal);
                }
            }

            System.out.println("------------------------------");
            System.out.printf("Total: $%.2f%n", total);

            grandTotal += total;
        }

        // Prints combined total for all friends
        System.out.println("\n====== GRAND TOTAL ======");
        System.out.printf("All friends combined: $%.2f%n", grandTotal);

        scanner.close();
    }