package Question_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Student {
    public int id;
    public String name;
    public int age;
    public String email;
    public String course;
    
    private final static ArrayList<Student> studentlist = new ArrayList<>();
    private final static Scanner sc = new Scanner (System.in);
    
    // constructors
    public Student(int id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;          
    }
    
    // getters and setters
    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age){
        this.age = age ;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getCourse() {
        return course;
    }
    
    public void setCourse(String course){
        this.course = course;
    }
    
    // creating arraylist to store student data
    public static ArrayList<Student> getStudentList(){
        return studentlist;
    }
            
    //All methods containe try catch to ensure a better user experience
    
    public static void SaveStudent(int id, String name, int age, String email, String course) {
        System.out.println("\n-----------------------------------------------");
        System.out.println("SAVE STUDENT");
        System.out.println("-------------------------------------------------");

        //Code Attribution
        //This method was taken from
        //https://stackoverflow.com/questions/35107238/how-to-use-an-if-statement-to-check-if-user-input-is-a-certain-variable-type
        //Makoto
        //https://stackoverflow.com/users/1079354/makoto

        boolean validId = false;
        //this try catch ensures that user can re-input if he inputs incorrectly
        do {
            try{
                //input of student id
                System.out.println("Enter the student id: ");
                id = Integer.parseInt(sc.nextLine());
                validId = true;
            }catch(NumberFormatException e){
                System.out.println("Invalid number - Please re-input a number");
            }
        }while(!validId);
       
        //input of student name
        System.out.println("Enter the student name: ");
        name = sc.nextLine();

        boolean validAge = false;
        //checks if inputted age is greater than or equal to 16
        do{ 
            try{
                //input of student age
                System.out.println("Enter the student age: ");
                age = Byte.parseByte(sc.nextLine());
                
                if(age < 16){ //checks that the age is less than or equal to 16 years
                    System.out.println("You have entered an incorrect age!!! ");
                    System.out.println("Please re-enter the student age >>");                 
                }else{
                    validAge = true;
                }
            }catch(NumberFormatException e){ //asks for re-input if ag is less than 16 years
                System.out.println("You have entered an invalid character! - please try again ");
            }         
        } while (!validAge); 

        //input of student email
        System.out.println("Enter the student email: ");
        email = sc.nextLine();
        
        //input of student course
        System.out.println("Enter the student course: ");
        course = sc.nextLine();
        
        // creating object and then storing details in the arraylist
        Student student = new Student(id, name, age, email, course);
        studentlist.add(student);
        System.out.println("Student successfully added: "+ student.name); 
        
    }
    
    public static Student SearchStudent(int id) {
        System.out.println("\n-----------------------------------------------");
        System.out.println("SEARCH FOR STUDENT");
        System.out.println("-------------------------------------------------");

        boolean validId = false;
        //this try catch ensures that user can re-input if he inputs incorrectly
        do {
            try{
                //ask for input to search  
                System.out.println("Enter student ID to search: ");
                id = Integer.parseInt(sc.nextLine());
                validId = true;
            }catch(NumberFormatException e){
                System.out.println("Invalid number: Please re-input a number");

            }
        }while(!validId);
        
        boolean studentFound = false;
        //for loop to search through the array
        for (Student student : studentlist){
            //if statement checks that the id inputted equals one found in the array
            if(student.getId() == id){
                //outputs the given id Search
                System.out.println("-----------------------------------------");
                System.out.println("STUDENT ID: " + student.id);
                System.out.println("STUDENT NAME: " + student.name);
                System.out.println("STUDENT AGE: " + student.age);
                System.out.println("STUDENT EMAIL: " + student.email);
                System.out.println("STUDENT COURSE: " + student.course);
                System.out.println("-----------------------------------------");              
                studentFound = true;
                break;
            }
        }
        //if statement runs if no student is found with the id
        if(!studentFound){
            System.out.println("---------------------------------------------");
            System.out.println("Student with Student Id: " + id + " was not found!");
            System.out.println("---------------------------------------------");
        }
        
        return null;
    }
    
    public static void DeleteStudent(int id) {
        System.out.println("\n-----------------------------------------------");
        System.out.println("DELETE STUDENT"); 
        System.out.println("-------------------------------------------------");
        boolean valid = false;
        
        do{
            try{
                System.out.println("Enter the student id to delete: ");
                //asks for input to search an ID
                id = Integer.parseInt(sc.nextLine());
                
                //Code Attribution
                //This method was taken from 
                //https://stackoverflow.com/questions/10431981/remove-elements-from-collection-while-iterating
                //Edwin Dalorzo
                //https://stackoverflow.com/users/697630/edwin-dalorzo

                //The iterator safely removes elements 
                Iterator<Student> iterator = studentlist.iterator();
                boolean studentFound = false; //flag check if student is found

                while(iterator.hasNext()){
                    Student student = iterator.next();
                    if(student.getId() == id) { //checks if the search id matches one in the array
                        System.out.println("Are you sure you want to delete student " + id + " from the system? Yes (y) to delete");
                        String choice = sc.nextLine(); 
                        
                        //if satament for if user deletes
                        if(choice.equalsIgnoreCase("y")){
                            iterator.remove();
                            System.out.println("-----------------------------");
                            System.out.println("Student Deleted");
                            System.out.println("-----------------------------");
                        //else cancel
                        }else{
                            System.out.println("-----------------------------");
                            System.out.println("Deletion Canceled");
                            System.out.println("-----------------------------");
                        }
                        break; //exits the loop since opertation is complete
                    }
                }
                               
                if(!studentFound){
                    //displays if no student is found with id
                    System.out.println("No Student found with ID: " + id);
                }
                valid = true;
                
            }catch(NumberFormatException e) {
                //outputs if the user does not input a valid number
                System.out.println("Not a valid input - please enter a number");
            }     
        }while(!valid);
    }
     
    public static void StudentReport() {
        System.out.println("\n-----------------------------------------------");
        System.out.println("Report");
        System.out.println("-------------------------------------------------");
        
        if(studentlist.isEmpty()){
            System.out.println("No students to report.");           
        }else{
            //keeps track of the number of added students
            int studentNumber = 1; 
            System.out.println("");
            for(Student student : studentlist){
                System.out.println("STUDENT " + studentNumber);
                System.out.println("-----------------------------------------");
                System.out.println("STUDENT ID: " + student.id);
                System.out.println("STUDENT NAME: " + student.name);
                System.out.println("STUDENT AGE: " + student.age);
                System.out.println("STUDENT EMAIL: " + student.email);
                System.out.println("STUDENT COURSE: " + student.course);
                System.out.println("-----------------------------------------");
                studentNumber++;//increments on every student added          
            }
        }
    }
       
    public static void ExitStudentApplication() {
        System.out.println("GoodBye");
        System.exit(0);
    }
}
