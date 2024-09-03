

import java.util.Scanner;


public class StartMenu {
    
    private static String[] cellNumbers = new String[10];
    private static int cellNumberCount = 0;
    
    
    public void menu(){
        Scanner sc = new Scanner(System.in);
        
        //text colours
        String RESET = "\u001B[0m";
        String CYAN = "\u001B[36m";
        String YELLOW  = "\u001B[33m";
        
        //types of car washes
        CarWash[] carWashes = {
            new BasicWash(),
            new DeluxeWash(),
            new ValetWash(),
            new QuickWash()
        };
        
        //What is offered at each location
        CarWash[][] washTypes = {
            { new QuickWash(), new BasicWash(), new DeluxeWash(), new ValetWash() }, // Cape Town
            { new QuickWash(), new BasicWash(), new DeluxeWash() }, // Joburg
            { new BasicWash(), new DeluxeWash(), new ValetWash() } // Durban
        };
        
        //location where cars can get washed
        String[] locationNames = {"Cape Town", "Joburg", "Durban"};
        
        //admin login credendials
        String adminCellNumber = "0123456789"; // Example admin cell number
        String adminPassword = "admin123"; // Example admin password
        
        Admin admin = new Admin(100, adminCellNumber, adminPassword); //maximum 100 bookings
        Application app = new Application();
        Booking booking = new Booking(admin);
        boolean running = true;
        
        while(running){
            //display menu
            System.out.println("**************************");
            System.out.println(CYAN + "CAR WASH BOOKING" + RESET);
            System.out.println("**************************");
            System.out.println("1. Book a Wash");
            System.out.println("2. View Pricing");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            System.out.println("Please select an option (1-4): ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice){//switch case for menu select
                case 1:
                    //make a booking
                    booking.makeBooking(washTypes, locationNames);
                    break;
                case 2:
                    //view pricing
                    app.selectRegion(carWashes, locationNames, washTypes);
                    break;
                case 3:
                    //enter as admin 
                    System.out.println("\nEnter Admin Cell Number: ");
                    String inputCell = sc.nextLine();
                    System.out.println("Enter Admin Password");
                    String inputPassword = sc.nextLine();
                    
                    if(admin.authenticate(inputCell, inputPassword)) {
                        System.out.println("---------------------------------");
                        System.out.println(YELLOW + "Welcome Admin" + RESET);
                        System.out.println("---------------------------------");
                        admin.viewAllBookings();
                    }else{
                        System.out.println("Invalid Credentials access denied");
                    }
                    break;
                case 4:
                    //exit
                    running = false;
                    System.out.println("Have a good day! Bye Bye");
                    break;
                default:
                    System.out.println("Invalid choice, please select a valid number");
            }
        }
        sc.close();
    }
}
