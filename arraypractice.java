public class arraypractice {
    public static void main(String[] args) {
        
        //create an array and populate it directly
        String[] holidays = new String[4];
        
        holidays[0] = "Diwali";
        holidays[1] = "October Fest";
        holidays[2] = "National Holiday";
        holidays[3] = "Halloween";

        String[] holiday = {"Diwali ", "Christmas"};

        for (int i = 0; i < holiday.length; i++) {
            System.out.println(holiday[i]);
        }
        
       



    }
}
