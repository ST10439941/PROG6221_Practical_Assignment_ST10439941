
//sub class

public class BasicWash extends CarWash{
    
    public BasicWash(){
        super(
            "Basic Wash", //name of the wash
            new double[]{200.00, 250.00, 300.00}, //prices for Sedan, SUV, Bakkie
            "\nInside and Out"
            + "\nPolish Tyres"
            + "\nFree Scent" //information
        );   
    }
}
