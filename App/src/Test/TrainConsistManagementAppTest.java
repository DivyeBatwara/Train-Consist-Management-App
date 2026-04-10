import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    @Test
    void testException_ValidCapacityCreation() throws InvalidCapacityException {
        Bogie b = new Bogie("Sleeper", "Passenger", 72);
        assertNotNull(b);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Sleeper", "Passenger", -10);
        });
        assertEquals("Invalid capacity for passenger bogie", ex.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Sleeper", "Passenger", 0);
        });
        assertEquals("Invalid capacity for passenger bogie", ex.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("AC Chair", "Passenger", 0);
        });
        assertEquals("Invalid capacity for passenger bogie", ex.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        Bogie b = new Bogie("First Class", "Passenger", 30);
        assertEquals("First Class", b.name);
        assertEquals("Passenger", b.type);
        assertEquals(30, b.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() {
        assertDoesNotThrow(() -> {
            new Bogie("Sleeper", "Passenger", 72);
            new Bogie("AC Chair", "Passenger", 50);
            new Bogie("First Class", "Passenger", 30);
        });
    }
}