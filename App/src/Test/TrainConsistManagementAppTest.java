import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private Map<String, List<Bogie>> group(List<Bogie> bogies) {
        return bogies.stream().collect(Collectors.groupingBy(Bogie::getType));
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", "Passenger"),
                new Bogie("AC Chair", "Passenger")
        );
        Map<String, List<Bogie>> result = group(list);
        assertTrue(result.containsKey("Passenger"));
        assertEquals(2, result.get("Passenger").size());
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", "Passenger"),
                new Bogie("First Class", "Passenger"),
                new Bogie("AC Chair", "Passenger")
        );
        Map<String, List<Bogie>> result = group(list);
        assertEquals(3, result.get("Passenger").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", "Passenger"),
                new Bogie("Cylindrical", "Goods")
        );
        Map<String, List<Bogie>> result = group(list);
        assertTrue(result.containsKey("Passenger"));
        assertTrue(result.containsKey("Goods"));
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();
        Map<String, List<Bogie>> result = group(list);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", "Passenger"),
                new Bogie("AC Chair", "Passenger")
        );
        Map<String, List<Bogie>> result = group(list);
        assertEquals(1, result.size());
        assertTrue(result.containsKey("Passenger"));
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", "Passenger"),
                new Bogie("Rectangular", "Goods")
        );
        Map<String, List<Bogie>> result = group(list);
        assertTrue(result.containsKey("Passenger"));
        assertTrue(result.containsKey("Goods"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", "Passenger"),
                new Bogie("Sleeper", "Passenger")
        );
        Map<String, List<Bogie>> result = group(list);
        assertEquals(2, result.get("Passenger").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", "Passenger"));
        list.add(new Bogie("Rectangular", "Goods"));

        List<Bogie> original = new ArrayList<>(list);

        group(list);

        assertEquals(original.size(), list.size());
        assertEquals(original.get(0).getName(), list.get(0).getName());
        assertEquals(original.get(1).getName(), list.get(1).getName());
    }
}
