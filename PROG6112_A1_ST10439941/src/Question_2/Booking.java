

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Booking {
    private Scanner sc = new Scanner(System.in);
    private Admin admin;

    public Booking(Admin admin) {
        this.admin = admin;
    }

    public void makeBooking(CarWash[][] washTypes, String[] locationNames){
        //select region
        System.out.println("Select your region: ");
        for(int i = 0; i < locationNames.length; i++){
            System.out.println((i + 1) + ". " + locationNames[i]);
        }
        System.out.println("Enter your choice (1-" + locationNames.length + ") ");
        int regionChoice = sc.nextInt() - 1;
        sc.nextLine();
        
        //based on region it will dispaly available packages
        if (regionChoice >= 0 && regionChoice < locationNames.length) {
            // Select wash package
            System.out.println("Select a wash package:");
            CarWash[] selectedWashTypes = washTypes[regionChoice];
            for (int i = 0; i < selectedWashTypes.length; i++) {
                System.out.println((i + 1) + ". " + selectedWashTypes[i].getName());
            }
            System.out.print("Enter your choice (1-" + selectedWashTypes.length + "): ");
            int washChoice = sc.nextInt() - 1;
            sc.nextLine(); 

            if (washChoice >= 0 && washChoice < selectedWashTypes.length) {
                CarWash selectedWash = selectedWashTypes[washChoice];

                // Select vehicle type
                double price = selectedWash.vehicleTypes(sc);
                
                System.out.println("You have selected:");
                System.out.println(selectedWash.getDetails(price));
                
                //call method for user to input their details
                String[] userDetails = collectDetails();
                admin.addBooking(userDetails[0], userDetails[1], userDetails[2], userDetails[3], locationNames[regionChoice], selectedWash.getName(), price);
                 
            } else {
                System.out.println("Invalid wash package selection. Please try again.");
            }
        } else {
            System.out.println("Invalid region selection. Please try again.");
        }
    }
    
    String[] collectDetails(){
        System.out.println("Please enter your details to complete booking");
        sc.nextLine();
        //cell number
        System.out.println("Cellphone Number: ");
        String cell = sc.nextLine();
        if(isValidMobileNo(cell)){
            System.out.println("Number valid");
        }else{
            System.out.println("Invalid mobile number, please retry number should be 10 digits ");
            cell = sc.nextLine();
        }
        
        //name
        System.out.println("Name: ");
        String name = sc.nextLine();
        
        //email
        System.out.println("Email: ");
        String email = sc.nextLine();
        
        //Car registra
        System.out.println("Car Registration: ");
        String reg = sc.nextLine();
        
        return new String[] { cell, name, email, reg };
    }
    
    //Code Attribution
    //This method was taken from
    //https://www.javatpoint.com/mobile-number-validation-in-java
    //javatpoint
    //https://www.javatpoint.com/
    
    //method ensures that the cell number is 10 digits
    boolean isValidMobileNo(String cell){
        Pattern ptrn = Pattern.compile("^[7-9][0-9]{9}$"); 
        
        Matcher match = ptrn.matcher(cell); 
        
        return (match.find() && match.group().equals(cell)); 
    }
}
