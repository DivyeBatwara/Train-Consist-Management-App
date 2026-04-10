import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String type;
    int capacity;

    Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    void display() {
        System.out.println("Type: " + type + ", Capacity: " + capacity);
    }
}

public class TrainConsistManagementApp{

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 50));
        bogies.add(new Bogie("AC Chair", 70));
        bogies.add(new Bogie("First Class", 80));
        bogies.add(new Bogie("Sleeper", 60));

        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("Filtered Bogies (Capacity > 60):");
        filteredBogies.forEach(Bogie::display);
    }
}
