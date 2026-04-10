import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TrainConsistManagementAppTest {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Integer> bogies = Arrays.asList(50, 60, 80, 100);
        int threshold = 70;

        List<Integer> result = bogies.stream()
                .filter(b -> b > threshold)
                .toList();

        assertEquals(Arrays.asList(80, 100), result);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Integer> bogies = Arrays.asList(70, 80, 90);
        int threshold = 70;

        List<Integer> result = bogies.stream()
                .filter(b -> b > threshold)
                .toList();

        assertFalse(result.contains(70));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Integer> bogies = Arrays.asList(40, 50, 60);
        int threshold = 70;

        List<Integer> result = bogies.stream()
                .filter(b -> b > threshold)
                .toList();

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Integer> bogies = Arrays.asList(30, 75, 85, 90);
        int threshold = 70;

        List<Integer> result = bogies.stream()
                .filter(b -> b > threshold)
                .toList();

        assertEquals(Arrays.asList(75, 85, 90), result);
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Integer> bogies = Arrays.asList(10, 20, 30);
        int threshold = 50;

        List<Integer> result = bogies.stream()
                .filter(b -> b > threshold)
                .toList();

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Integer> bogies = Arrays.asList(80, 90, 100);
        int threshold = 70;

        List<Integer> result = bogies.stream()
                .filter(b -> b > threshold)
                .toList();

        assertEquals(bogies, result);
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Integer> bogies = new ArrayList<>();
        int threshold = 70;

        List<Integer> result = bogies.stream()
                .filter(b -> b > threshold)
                .toList();

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Integer> bogies = new ArrayList<>(Arrays.asList(50, 80, 90));
        List<Integer> originalCopy = new ArrayList<>(bogies);
        int threshold = 70;

        bogies.stream()
                .filter(b -> b > threshold)
                .toList();

        assertEquals(originalCopy, bogies);
    }
}
