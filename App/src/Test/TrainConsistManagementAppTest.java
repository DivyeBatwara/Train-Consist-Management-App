import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private boolean isSafe(List<Bogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical") ||
                                b.getCargo().equalsIgnoreCase("Petroleum")
                );
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Cylindrical", "Petroleum"),
                new Bogie("Rectangular", "Coal"),
                new Bogie("Cylindrical", "Petroleum")
        );

        assertTrue(isSafe(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Cylindrical", "Coal")
        );

        assertFalse(isSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Open", "Coal"),
                new Bogie("Box", "Grain")
        );

        assertTrue(isSafe(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Cylindrical", "Petroleum"),
                new Bogie("Open", "Coal"),
                new Bogie("Cylindrical", "Coal")
        );

        assertFalse(isSafe(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        assertTrue(isSafe(bogies));
    }
}