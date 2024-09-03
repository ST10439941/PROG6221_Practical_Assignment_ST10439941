
import java.util.Arrays;
import java.util.Scanner;

class Application {
    
    private Scanner sc = new Scanner(System.in);
    
    public void displayPricingTable(CarWash[] carWashes) {     
        //text colours
        String RESET = "\u001B[0m";
        String CYAN = "\u001B[36m";
        
        //for loop adds horizontal lines for the amount of wash avaliable at a location
        String line = "+---------------+";
        for(CarWash wash : carWashes){
            line += "--------------------+";
        }
        System.out.println(line);
        
        //prints names of the washes
        System.out.printf("| %-13s |", "");
        for(CarWash wash : carWashes){
            System.out.printf(CYAN + " %-22s |", wash.getName() + RESET);
        }
        System.out.println();
        System.out.println(line);
        
        String[] vehicleTypes = CarWash.getVehicleTypes();
       
        //Code Attribution
        //This method was taken from
        //https://stackoverflow.com/questions/61613513/arrays-aslistarr-indexof-is-not-working
        //Sidak
        //https://stackoverflow.com/users/13238899/sidak
        //first for loop displays the vehicle type
        for(String vehicleType : vehicleTypes){
            System.out.printf("| %-13s |", vehicleType);
            //second for loop displays the pricing
            for(CarWash wash : carWashes){
                 int index = Arrays.asList(vehicleTypes).indexOf(vehicleType);
                 if(index < wash.getPrices().length){
                     System.out.printf(" R%-17.2f |", wash.getPrices()[index]);
                } else {
                    System.out.printf(" %-18s |", "N/A");
                }
            }
            System.out.println();//prints a new line after each vehicle type
            System.out.println(line);
        }
    }
    
    //method asks user for a region select
    public void selectRegion(CarWash[] carWashes, String[] locationNames, CarWash[][] washTypes){
        while(true){
            System.out.println("\nSelect your region to view pricing: ");
            System.out.println("-------------------------------------------------");
            //for loop displays the names of the regions
            for(int i = 0; i < locationNames.length; i++){
                System.out.println((i + 1) + ". " + locationNames[i]);
            }
            System.out.println("-------------------------------------------------");
            System.out.println("Enter your choice (1-" + locationNames.length + "): "); //the locationNames keeps track of how many there are
            //input choice 
            try{
                int regionChoice = sc.nextInt() - 1;
                sc.nextLine();
                
                if(regionChoice >= 0 && regionChoice < locationNames.length){
                    System.out.println("Pricing for " + locationNames[regionChoice] + ":");
                    displayPricingTable(washTypes[regionChoice]);    
                    return;
                }else{
                    System.out.println("Invalid selction. Please try again.");
                }
            }catch(NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid number");
            }
        }
    }
    
    
}
