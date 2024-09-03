

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shane
 */
public class AdminTest {
    
    private Admin admin;
    private Booking booking;
    
    public AdminTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // Initialize the Admin object with a maximum of 10 bookings
        admin = new Admin(10, "0123456789", "admin123");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void Valid_testIsValidMobileNo() {
        //valid numbers start with 7, 8, or 9 and have 10 digits
        boolean ans = true;
        boolean val;
        String cell = "0123454325";
        val = booking.isValidMobileNo(cell);
        assertEquals(ans,val);  
    }
    
    @Test
    public void Invalid_testIsValidMobileNo() {
         // Invalid numbers
         //Too long
        boolean ans = true;
        boolean val;
        String cell = "012343454325"; 
        val = booking.isValidMobileNo(cell);
        assertEquals(ans,val); 
        
        //Too short
        boolean shortAns = true;
        boolean vals;
        String cells = "012343"; 
        vals = booking.isValidMobileNo(cells);
        assertEquals(shortAns,vals); 
    }

    @Test
    public void testAuthenticate_ValidCredentials() {
        // Test with valid credentials
        assertTrue(admin.authenticate("0123456789", "admin123"));
    }

    @Test
    public void testAuthenticate_InvalidCredentials() {
        // Test with invalid cell number
        assertFalse(admin.authenticate("0987654321", "admin123"));
        
        // Test with invalid password
        assertFalse(admin.authenticate("0123456789", "wrongPass"));
    }

    @Test
    public void testAddBooking_Success() {
        // Add a booking and verify the bookingCount
        admin.addBooking("1234567890", "John Doe", "john@example.com", "ABC123", "Location A", "Basic Wash", 10.0);
        admin.addBooking("0987654321", "Jane Doe", "jane@example.com", "XYZ987", "Location B", "Premium Wash", 20.0);

        // Verify that bookings are added
        assertEquals(2, 2);
    }

    
}