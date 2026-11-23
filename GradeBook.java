import java.util.*;

public class GradeBook{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> grades = new ArrayList<>();

        names.add("Vatsal");
        grades.add(95.0);
        int choice = 0;
        
        do{
       
        System.out.println("\n ---GradeBook---");
        System.out.println("1. Add student");
        System.out.println("2. View students");
        System.out.println("3. Update grade");
        System.out.println("4. Delete student");
        System.out.println("5. Show statistics");
        System.out.println("0. Exit");

        try{
            System.out.print("Choose an option");
            choice = sc.nextInt();
            sc.nextLine();
        } catch(Exception e){
            System.out.print("Please enter a valid input");
            sc.nextLine(); // Removes invalid input
            continue;
        }

            if(choice == 1){
            System.out.println("Enter a name");
            String name = sc.nextLine();
            System.out.println("Enter the grade");
            double grade = sc.nextDouble();
            sc.nextLine();

            if(grade >= 0 && grade <= 100){
                names.add(name);
                grades.add(grade);
                System.out.println("Student added");
            } else{
                System.out.println("Grade must be between 0 and 100.");
            }
                
            } else if(choice == 2){

                for(int i=0; i < names.size();i++){
                    System.out.println(i+1 + "." + names.get(i) + " - " + grades.get(i));
                }
                
}

           else if (choice == 3){
                System.out.print("Enter student number: ");
                int index = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter new grade: ");
                double newGrade = sc.nextDouble();
                sc.nextLine();

                grades.set(index - 1 , newGrade);
            }

            else if (choice == 4){
                // DELETE STUDENT
System.out.print("Enter student number: ");
int index = sc.nextInt();
sc.nextLine();

if (index >= 0 && index < names.size()) {
String removedName = names.remove(index - 1);
grades.remove(index - 1);

System.out.println(removedName + " was deleted.");
} else {
System.out.println("Invalid student number.");
}

            }

            else if (choice == 5){
                if(grades.size() == 0){
                    System.out.println("Cannot do");
                }else{

                    double sum = 0.0;
                    double min = grades.get(0);
                    double max = grades.get(0);

                     for(double grade : grades){
                         sum = sum + grade;
                         if(grade < min){
                             min = grade;
                         }
                         if(grade>max){
                             max = grade;
                         }
                         double average = sum / grades.size();

                    System.out.println("\n--- STATISTICS ---");
System.out.println("Number of students: " + grades.size());
System.out.println("Sum: " + sum);
System.out.println("Average: " + average);
System.out.println("Minimum: " + min);
System.out.println("Maximum: " + max);
System.out.println("Range: " + (max - min));

                         
                }
               
            }
            }
            
            }while( choice != 0);
          System.out.println("Exited");
        


    }





            

        
    }
