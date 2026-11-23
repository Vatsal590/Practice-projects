import java.util.ArrayList;


public class arraylist {
    public static void main(String[] args) {
        ArrayList<String> chefs = new ArrayList<>();
        chefs.add("Gordan Ramsey");
        chefs.add("Jamie Oliver");
        chefs.add("Vatsal Agarwala");

        System.out.println(chefs);
        
        chefs.remove("Jamie Oliver");

        String new_chef1 = new String("me");
        chefs.set(1, new_chef1);
        //chefs.get(1);  - gets the item at 1st index
        int i = 0;

        while(i<chefs.size()){
            System.out.println(chefs.get(i));
            i++;
        } 
        i=0;
        do{
            System.out.println(chefs.get(i));
            i++;
        } while (i<chefs.size());


        
        for(i = 0; i<chefs.size(); i++){
            System.out.println(chefs.get(i));
        }

        for (String chef : chefs){
            // System.out.println(chef);
            System.out.print(chef + "\t");

        }

    

        

}
}


size get isempty remove add set contains addfirst addlast clear 