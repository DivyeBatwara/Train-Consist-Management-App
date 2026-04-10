import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String name;
    String type;

    public Bogie(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", "Passenger"),
                new Bogie("AC Chair", "Passenger"),
                new Bogie("First Class", "Passenger"),
                new Bogie("Rectangular", "Goods"),
                new Bogie("Cylindrical", "Goods")
        );

        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        System.out.println("Grouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
