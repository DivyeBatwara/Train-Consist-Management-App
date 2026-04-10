import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementTest {

    private List<Bogie> generateBogies(int size) {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            bogies.add(new Bogie(i));
        }
        return bogies;
    }

    private List<Bogie> loopFilter(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    private List<Bogie> streamFilter(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie(50),
                new Bogie(70),
                new Bogie(90)
        );

        List<Bogie> result = loopFilter(bogies);

        assertEquals(2, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie(50),
                new Bogie(70),
                new Bogie(90)
        );

        List<Bogie> result = streamFilter(bogies);

        assertEquals(2, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie(40),
                new Bogie(70),
                new Bogie(80),
                new Bogie(20)
        );

        List<Bogie> loopResult = loopFilter(bogies);
        List<Bogie> streamResult = streamFilter(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = generateBogies(1000);

        long start = System.nanoTime();
        streamFilter(bogies);
        long end = System.nanoTime();

        long duration = end - start;

        assertTrue(duration > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = generateBogies(100000);

        List<Bogie> result = streamFilter(bogies);

        long expectedCount = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .count();

        assertEquals(expectedCount, result.size());
    }
}