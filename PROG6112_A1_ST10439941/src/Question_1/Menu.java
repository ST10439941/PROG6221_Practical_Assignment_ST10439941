
import Question_1.Student;
import java.util.Scanner;

public class Menu{

    Scanner in = new Scanner(System.in);

    public void startApplication() {
        int userInput;
        System.out.println("\nSTUDENT MANAGEMENT APPLICATION"
                + "\n*************************************"
                + "\nEnter (1) to launch menu or any other key to exit");
        userInput = in.nextInt();
        in.nextLine();
        
        if (userInput == 1) {
            showMenu();
        } else {
            System.out.println("Exit. GoodBye");
        }
    }
    

    public void showMenu() {
        int choice;
        

        do {
            System.out.println("Please select one of the following menu items:"
                    + "\n(1) Capture a new student."
                    + "\n(2) Search for a Student."
                    + "\n(3) Delete a student."
                    + "\n(4) Print student report."
                    + "\n(5) Exit Application");
            choice = in.nextInt();
            in.nextLine();

            switch(choice) {
                case 1: 
                    Student.SaveStudent(0, "", 0, "", "");
                    startApplication();
                    return; 
                case 2: 
                    Student.SearchStudent(0);
                    startApplication();
                    return;
                case 3: 
                    Student.DeleteStudent(0);
                    startApplication();
                    return; 
                case 4: 
                    Student.StudentReport();
                    startApplication();
                    return;
                case 5: 
                    Student.ExitStudentApplication();
                    break;    
            }
        } while (choice != 5);
    }
}
