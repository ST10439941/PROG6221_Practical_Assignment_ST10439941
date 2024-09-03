
//sub class

class QuickWash extends CarWash{
    public QuickWash() {
        super(
            "Quick Wash", //name of the wash
            new double[]{150.00, 175.00, 200.00}, //prices for Sedan, SUV, Bakkie
            "\nOutside Only"
            + "\nFree Scent"//information
        );
    }
}
