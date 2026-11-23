import java.util.Scanner;

class SodaVending {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Create a blank 6 x 10 soda machine
        String[][] sodas = new String[6][10];

        // Price for each row (company)
        double[] prices = {1.50, 1.50, 2.00, 2.00, 1.75, 2.50};

        int choice;

        // Customer menu
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
            System.out.print("Enter choice: ");

            choice = readNumber(scan);

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
                    purchaseSoda(sodas, prices, scan);
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

    // 1. CREATE INVENTORY
    public static void createInventory(String[][] sodas, Scanner scan) {

        System.out.println("\nCREATE INVENTORY");
        System.out.println("Enter a soda for each position.");
        System.out.println("Press Enter to leave a position empty.");

        for (int row = 0; row < sodas.length; row++) {
            for (int col = 0; col < sodas[row].length; col++) {

                System.out.print("[" + row + "][" + col + "]: ");
                String name = scan.nextLine().trim();

                if (name.isEmpty()) {
                    sodas[row][col] = null;
                } else {
                    sodas[row][col] = name;
                }
            }
        }

        System.out.println("Inventory created.");
        stockWarning(sodas);
    }

    // 2. REVIEW INVENTORY
    public static void reviewInventory(String[][] sodas) {

        System.out.println("\n===== CURRENT INVENTORY =====");

        System.out.printf("%8s", "Row/Col");

        for (int col = 0; col < sodas[0].length; col++) {
            System.out.printf("%-18d", col);
        }
        System.out.println();

        int count = 0;

        for (int row = 0; row < sodas.length; row++) {

            System.out.printf("%8d", row);

            for (int col = 0; col < sodas[row].length; col++) {

                if (sodas[row][col] == null) {
                    System.out.printf("%-18s", "[EMPTY]");
                } else {
                    System.out.printf("%-18s", sodas[row][col]);
                    count++;
                }
            }
            System.out.println();
        }

        System.out.println("\nSodas in stock: " + count);
        System.out.println("Total capacity: " +
                (sodas.length * sodas[0].length));
    }

    // 3. RESTOCK EMPTY POSITIONS
    public static void restockSodas(String[][] sodas, Scanner scan) {

        System.out.println("\nRESTOCK SODAS");

        boolean restocked = false;

        for (int row = 0; row < sodas.length; row++) {
            for (int col = 0; col < sodas[row].length; col++) {

                if (sodas[row][col] == null) {

                    System.out.println("Empty slot found at [" + row + "][" + col + "].");
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
            System.out.println("Restocking complete.");
        } else {
            System.out.println("No empty slots were restocked.");
        }

        stockWarning(sodas);
    }

    // 4. CHANGE SODA BRAND
    public static void changeBrand(String[][] sodas, Scanner scan) {

        System.out.print("Enter row (0-5): ");
        int row = readNumber(scan);

        System.out.print("Enter column (0-9): ");
        int col = readNumber(scan);

        if (validPosition(sodas, row, col)) {

            System.out.println("Current soda: " + sodas[row][col]);

            System.out.print("Enter new soda: ");
            String name = scan.nextLine().trim();

            if (!name.isEmpty()) {
                sodas[row][col] = name;
                System.out.println("Soda updated.");
            } else {
                System.out.println("No changes made.");
            }

        } else {
            System.out.println("Invalid position.");
        }
    }

    // 5. PURCHASE SODA
    public static void purchaseSoda(
            String[][] sodas, double[] prices, Scanner scan) {

        reviewInventory(sodas);

        System.out.print("\nEnter row (0-5): ");
        int row = readNumber(scan);

        System.out.print("Enter column (0-9): ");
        int col = readNumber(scan);

        if (!validPosition(sodas, row, col)) {
            System.out.println("Invalid position.");
            return;
        }

        if (sodas[row][col] == null) {
            System.out.println("Sorry, this soda is sold out.");
            return;
        }

        String sodaName = sodas[row][col];
        double price = prices[row];

        System.out.println("Selected: " + sodaName);
        System.out.printf("Price: €%.2f%n", price);

        // Ask for payment
        double money = askForMoney(scan, price);

        // Calculate change
        double change = calculateChange(money, price);

        // Remove soda after payment
        sodas[row][col] = null;

        System.out.println("Dispensing: " + sodaName);

        returnChange(change);

        stockWarning(sodas);
    }

    // ASK FOR MONEY
    public static double askForMoney(Scanner scan, double price) {

        double money = 0;

        while (money < price) {

            System.out.printf("Remaining: €%.2f%n", price - money);
            System.out.print("Insert money (€): ");

            if (scan.hasNextDouble()) {

                double payment = scan.nextDouble();
                scan.nextLine();

                if (Double.isFinite(payment) && payment > 0) {
                    money = money + payment;
                } else {
                    System.out.println("Invalid amount.");
                }

            } else {
                scan.nextLine();
                System.out.println("Enter a valid amount.");
            }
        }

        return money;
    }

    // CALCULATE CHANGE
    public static double calculateChange(double money, double price) {
        return money - price;
    }

    // RETURN CHANGE
    public static void returnChange(double change) {

        System.out.printf("Change returned: €%.2f%n", change);
        System.out.println("Thank you for your purchase!");
    }

    // 6. LINEAR SEARCH
    public static void searchSoda(String[][] sodas, Scanner scan) {

        System.out.print("Enter soda name: ");
        String target = scan.nextLine().trim();

        if (target.isEmpty()) {
            System.out.println("Enter a soda name.");
            return;
        }

        boolean found = false;
        int count = 0;

        for (int row = 0; row < sodas.length; row++) {
            for (int col = 0; col < sodas[row].length; col++) {

                if (sodas[row][col] != null &&
                        sodas[row][col].equalsIgnoreCase(target)) {

                    System.out.println("Found at [" + row + "][" + col + "]");
                    found = true;
                    count++;
                }
            }
        }

        if (found) {
            System.out.println("Total found: " + count);
        } else {
            System.out.println("Soda not found.");
        }
    }

    // 7. STOCK WARNING
    public static void stockWarning(String[][] sodas) {

        int totalStock = 0;
        int totalCapacity = 0;

        // Count total sodas and capacity
        for (int row = 0; row < sodas.length; row++) {

            totalCapacity += sodas[row].length;

            for (int col = 0; col < sodas[row].length; col++) {

                if (sodas[row][col] != null) {
                    totalStock++;
                }
            }
        }

        double percentage =
                (double) totalStock / totalCapacity * 100;

        System.out.println("\n===== STOCK REPORT =====");
        System.out.println("Sodas remaining: " + totalStock);
        System.out.printf("Stock level: %.1f%%%n", percentage);

        // Warning 1: Below 30% stock
        if (percentage < 30) {
            System.out.println("WARNING: LOW STOCK!");
            System.out.println("Machine needs restocking.");
        }

        // Warning 2: Empty columns
        for (int col = 0; col < sodas[0].length; col++) {

            int columnStock = 0;

            for (int row = 0; row < sodas.length; row++) {

                if (sodas[row][col] != null) {
                    columnStock++;
                }
            }

            if (columnStock == 0) {
                System.out.println("WARNING: Column " + col +
                        " is EMPTY! Restocking required.");
            }
        }
    }

    // VALIDATE ARRAY POSITION
    public static boolean validPosition(
            String[][] sodas, int row, int col) {

        if (row < 0 || row >= sodas.length) {
            return false;
        }

        if (col < 0 || col >= sodas[row].length) {
            return false;
        }

        return true;
    }

    // READ INTEGER INPUT
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