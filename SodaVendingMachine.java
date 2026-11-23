import java.util.Scanner;

public class SodaVendingMachine {

    // Size of the vending machine
    static final int ROWS = 6;
    static final int COLS = 10;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Create a blank 6 x 10 array
        String[][] sodas = new String[ROWS][COLS];

        int choice;

        // Main menu
        do {
            System.out.println("\n===== SODA VENDING MACHINE =====");
            System.out.println("1. Create Inventory");
            System.out.println("2. Review Inventory");
            System.out.println("3. Restock Sodas");
            System.out.println("4. Change Soda Brand");
            System.out.println("5. Purchase Soda");
            System.out.println("6. Search for Soda");
            System.out.println("7. Check Stock Warning");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                scan.nextLine();
            } else {
                scan.nextLine();
                choice = 0;
            }

            switch (choice) {
                case 1:
                    createInventory(sodas, scan);
                    break;
                case 2:
                    reviewInventory(sodas);
                    break;
                case 3:
                    restockSodas(sodas, scan);
                    break;
                case 4:
                    changeBrand(sodas, scan);
                    break;
                case 5:
                    purchaseSoda(sodas, scan);
                    break;
                case 6:
                    searchSoda(sodas, scan);
                    break;
                case 7:
                    stockWarning(sodas);
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid menu choice.");
            }

        } while (choice != 8);

        scan.close();
    }

    // METHOD 1: CREATE INVENTORY
    public static void createInventory(String[][] sodas, Scanner scan) {
        System.out.println("\nCREATE INVENTORY");
        System.out.println("Enter a soda name for each slot.");
        System.out.println("Press Enter to leave a slot empty.");

        for (int row = 0; row < sodas.length; row++) {
            for (int col = 0; col < sodas[row].length; col++) {
                System.out.print("Row " + row + ", Column " + col + ": ");
                String name = scan.nextLine().trim();

                if (name.isEmpty()) {
                    sodas[row][col] = null;
                } else {
                    sodas[row][col] = name;
                }
            }
        }

        System.out.println("Inventory created!");
        stockWarning(sodas);
    }

    // METHOD 2: REVIEW INVENTORY
    public static void reviewInventory(String[][] sodas) {
        System.out.println("\nCURRENT SODA INVENTORY");

        // Print column headings
        System.out.printf("%8s", "Row/Col");
        for (int col = 0; col < sodas[0].length; col++) {
            System.out.printf("%-18d", col);
        }
        System.out.println();

        // Print each row
        for (int row = 0; row < sodas.length; row++) {
            System.out.printf("%8d", row);

            for (int col = 0; col < sodas[row].length; col++) {
                if (sodas[row][col] == null) {
                    System.out.printf("%-18s", "[EMPTY]");
                } else {
                    System.out.printf("%-18s", sodas[row][col]);
                }
            }
            System.out.println();
        }

        // Count available sodas
        int count = 0;

        for (int row = 0; row < sodas.length; row++) {
            for (int col = 0; col < sodas[row].length; col++) {
                if (sodas[row][col] != null) {
                    count++;
                }
            }
        }

        System.out.println("\nSodas in stock: " + count);
        System.out.println("Total capacity: " + (ROWS * COLS));
    }

    // METHOD 3: RESTOCK EMPTY POSITIONS
    public static void restockSodas(String[][] sodas, Scanner scan) {
        System.out.println("\nRESTOCK SODAS");

        boolean restocked = false;

        for (int row = 0; row < sodas.length; row++) {
            for (int col = 0; col < sodas[row].length; col++) {
                if (sodas[row][col] == null) {
                    System.out.println("Empty slot found at Row " + row + ", Column " + col + ".");

                    System.out.print("Enter soda name to restock (or press Enter to skip): ");
                    String name = scan.nextLine().trim();

                    if (!name.isEmpty()) {
                        sodas[row][col] = name;
                        restocked = true;
                        System.out.println("Slot restocked with " + name + ".");
                    }
                }
            }
        }

        if (restocked) {
            System.out.println("Restocking complete!");
        } else {
            System.out.println("No empty slots were restocked.");
        }

        stockWarning(sodas);
    }

    // METHOD 4: CHANGE SODA BRAND
    public static void changeBrand(String[][] sodas, Scanner scan) {
        System.out.println("\nCHANGE SODA BRAND");

        System.out.print("Enter row (0-5): ");
        int row = readNumber(scan);

        System.out.print("Enter column (0-9): ");
        int col = readNumber(scan);

        if (validPosition(sodas, row, col)) {
            System.out.println("Current soda: " + sodas[row][col]);
            System.out.print("Enter new soda brand: ");
            String newBrand = scan.nextLine().trim();

            if (!newBrand.isEmpty()) {
                sodas[row][col] = newBrand;
                System.out.println("Soda brand updated!");
            } else {
                System.out.println("No changes made.");
            }
        } else {
            System.out.println("Invalid position.");
        }
    }

    // METHOD 5: PURCHASE SODA
    public static void purchaseSoda(String[][] sodas, Scanner scan) {
        System.out.println("\nPURCHASE SODA");

        System.out.print("Enter row (0-5): ");
        int row = readNumber(scan);

        System.out.print("Enter column (0-9): ");
        int col = readNumber(scan);

        if (validPosition(sodas, row, col)) {
            if (sodas[row][col] != null) {
                System.out.println("Purchased: " + sodas[row][col]);

                // Remove soda from inventory
                sodas[row][col] = null;

                System.out.println("Thank you for your purchase!");

                // Check stock after purchase
                stockWarning(sodas);
            } else {
                System.out.println("This slot is empty.");
            }
        } else {
            System.out.println("Invalid position.");
        }
    }

    // METHOD 6: LINEAR SEARCH
    public static void searchSoda(String[][] sodas, Scanner scan) {
        System.out.println("\nSEARCH FOR SODA");

        System.out.print("Enter the soda name to search for: ");
        String target = scan.nextLine().trim();

        boolean found = false;

        for (int row = 0; row < sodas.length; row++) {
            for (int col = 0; col < sodas[row].length; col++) {
                if (sodas[row][col] != null && sodas[row][col].equalsIgnoreCase(target)) {
                    System.out.println("Found " + sodas[row][col] + " at Row " + row + ", Column " + col + ".");
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Sorry, " + target + " was not found in the vending machine.");
        }
    }

    // METHOD 7: STOCK WARNING
    public static void stockWarning(String[][] sodas) {
        int count = 0;
        int capacity = 0;

        // Count occupied slots and total slots
        for (int row = 0; row < sodas.length; row++) {
            capacity += sodas[row].length;

            for (int col = 0; col < sodas[row].length; col++) {
                if (sodas[row][col] != null) {
                    count++;
                }
            }
        }

        double percentage = 0;

        if (capacity > 0) {
            percentage = (double) count / capacity * 100;
        }

        System.out.printf("Current stock: %.1f%%%n", percentage);
        System.out.println("Sodas remaining: " + count);

        if (percentage < 30) {
            System.out.println("*****************************");
            System.out.println("WARNING: LOW SODA STOCK!");
            System.out.println("RESTOCKING IS REQUIRED!");
            System.out.println("*****************************");
        } else {
            System.out.println("Stock level is sufficient.");
        }
    }

    // HELPER METHOD: VALIDATE POSITION
    public static boolean validPosition(String[][] sodas, int row, int col) {
        if (row < 0 || row >= sodas.length) {
            return false;
        }

        if (col < 0 || col >= sodas[row].length) {
            return false;
        }

        return true;
    }

    // HELPER METHOD: READ AN INTEGER
    public static int readNumber(Scanner scan) {
        if (scan.hasNextInt()) {
            int number = scan.nextInt();
            scan.nextLine();
            return number;
        } else {
            scan.nextLine();
            return -1;
        }
    }
}