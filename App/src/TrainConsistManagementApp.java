class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class Bogie {
    String name;
    String type;
    int capacity;

    public Bogie(String name, String type, int capacity) throws InvalidCapacityException {
        if (type.equals("Passenger") && capacity <= 0) {
            throw new InvalidCapacityException("Invalid capacity for passenger bogie");
        }
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + ")";
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        try {
            Bogie b1 = new Bogie("Sleeper", "Passenger", 72);
            Bogie b2 = new Bogie("AC Chair", "Passenger", 50);
            Bogie b3 = new Bogie("Invalid", "Passenger", 0);

            System.out.println(b1);
            System.out.println(b2);
            System.out.println(b3);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
