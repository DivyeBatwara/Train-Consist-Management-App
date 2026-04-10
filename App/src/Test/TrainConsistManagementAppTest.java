import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private int totalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", "Passenger", 72),
                new Bogie("AC Chair", "Passenger", 50)
        );
        assertEquals(122, totalSeats(list));
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", "Passenger", 72),
                new Bogie("AC Chair", "Passenger", 50),
                new Bogie("First Class", "Passenger", 30)
        );
        assertEquals(152, totalSeats(list));
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> list = Collections.singletonList(
                new Bogie("Sleeper", "Passenger", 72)
        );
        assertEquals(72, totalSeats(list));
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();
        assertEquals(0, totalSeats(list));
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", "Passenger", 70),
                new Bogie("AC Chair", "Passenger", 40)
        );
        assertEquals(110, totalSeats(list));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", "Passenger", 60),
                new Bogie("AC Chair", "Passenger", 40),
                new Bogie("First Class", "Passenger", 20)
        );
        assertEquals(120, totalSeats(list));
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", "Passenger", 72));
        list.add(new Bogie("Rectangular", "Goods", 0));

        List<Bogie> original = new ArrayList<>(list);

        totalSeats(list);

        assertEquals(original.size(), list.size());
        assertEquals(original.get(0).getCapacity(), list.get(0).getCapacity());
        assertEquals(original.get(1).getCapacity(), list.get(1).getCapacity());
    }
}
