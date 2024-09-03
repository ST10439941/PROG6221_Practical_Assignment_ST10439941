
//sub class

class ValetWash extends CarWash {
    public ValetWash() {
        super(
            "Valet Wash", //name of the wash
            new double[]{650.00, 700.00, 750.00}, //prices for Sedan, SUV, Bakkie
            "\nInside and Out"
            + "\nPolish Tyres"
            + "\nFree Scent"
            + "\nEngine Clean"
            + "\nFull Car Polish"
            + "\nFree Coffee" //information
        );
    }
    
    public void freeCoffee(){
        //method for free coffee code
    }
}
