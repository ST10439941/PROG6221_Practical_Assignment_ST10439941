


public class Admin {
    private String[][] bookings;
    private int bookingCount;
    private String adminCellNumber;
    private String adminPassword;
    
    
    public Admin(int maxBookings, String adminCellNumber, String adminPassword){
        bookings = new String[maxBookings][7]; //4 columns: cell number, location, wash type, price
        bookingCount = 0;
        this.adminCellNumber = adminCellNumber;
        this.adminPassword = adminPassword;
    }
    
    //Code Attribution
    //This method was taken from
    //https://stackoverflow.com/questions/28095083/java-username-and-password-always-returns-true
    //Giulio Biagini
    //https://stackoverflow.com/users/4401823/giulio-biagini
    public boolean authenticate(String cellNumber, String password) {
        return this.adminCellNumber.equals(cellNumber) && this.adminPassword.equals(password);        
    }
    
    //method for adding bookings to array
    public void addBooking(String cellNumber, String name, String email, String reg,  String location, String washType, double price){
        if(bookingCount < bookings.length){
            bookings[bookingCount][0] = cellNumber;
            bookings[bookingCount][1] = name;
            bookings[bookingCount][2] = email;
            bookings[bookingCount][3] = reg;
            bookings[bookingCount][4] = location;
            bookings[bookingCount][5] = washType;
            bookings[bookingCount][6] = String.format("R%.2f", price);
            bookingCount++;
            System.out.println("Booking added successfully");
        }else{
            System.out.println("Bookings are full");
        }     
    }
    
    //method to view all current bookings
    public void viewAllBookings(){
        if(bookingCount == 0){
            System.out.println("No booking have been made.");
        }else{
            System.out.println("All Bookings: ");
            for(int i = 0; i < bookingCount; i++){
                System.out.println("BOOKING " + (i + 1));
                System.out.println("---------------------------");
                System.out.println("CUSTOMER DETAILS");
                System.out.println("---------------------------");
                System.out.println("Cell Number: " + bookings[i][0]);
                System.out.println("Name: " + bookings[i][1]);
                System.out.println("Email: " + bookings[i][2]);
                System.out.println("Reg Number: " + bookings[i][3]);
                System.out.println("---------------------------");
                System.out.println("WASH DETAILS");
                System.out.println("---------------------------");
                System.out.println("Wash Location: " + bookings[i][4]);
                System.out.println("Wash Type: " + bookings[i][5]);
                System.out.println("Price: " + bookings[i][6]);
                System.out.println("---------------------------");
            }
        }
    }
}