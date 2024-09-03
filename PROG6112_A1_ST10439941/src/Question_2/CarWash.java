
import java.util.Scanner;

//super class
class CarWash {
    Scanner sc = new Scanner(System.in);

    public String name;
    public double[] prices;
    public String description;
    
    //constructor
    public CarWash(String name, double[] prices, String description) {
        this.name = name;
        this.prices = prices;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }
    
    public double[] getPrices() {
        return prices;
    }

    public String getdescription() {
        return description;
    }
    
    public static String[] getVehicleTypes() {
        return new String[]{"Sedan", "SUV", "Bakkie"};
    }
    
    //method for vehicle type
    public double vehicleTypes(Scanner sc){
        String[] vehicleTypes = getVehicleTypes();
        System.out.println("Select a vehicle type:");
        for (int i = 0; i < vehicleTypes.length; i++) {
            System.out.println((i + 1) + ". " + vehicleTypes[i]);
        }
        System.out.print("Enter your choice (1-" + vehicleTypes.length + "): ");
        int Choice = sc.nextInt() - 1;
        
        return prices[Choice];
    }

    //method gets the details from the subclass
    public String getDetails(double price) {
        return String.format("------------------"
                + "\nName: %s"
                + "\n------------------"
                + "\nPrice: R%.2f"
                + "\n------------------"
                + "\nInformation: %s"
                + "\n------------------", name, price, description);
    }

}
