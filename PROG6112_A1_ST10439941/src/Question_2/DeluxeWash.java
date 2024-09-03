
//sub class

public class DeluxeWash extends CarWash {

    public DeluxeWash() {
       
        super(
            "Deluxe Wash", //name of the wash
            new double[]{400.00, 450.00, 500.00}, //prices for Sedan, SUV, Bakkie
            "\nInside and Out"
            + "\nPolish Tyres"
            + "\nFree Scent"
            + "\nEngine Clean"
            + "\n20% discount for a coffee" //information
        );
    }
    
    public void discount(){
        //method to give a discount code to user
    }
}
 