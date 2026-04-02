import java.util.LinkedList;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        LinkedList<String> trainConsist = new LinkedList<>();
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");
        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);
        trainConsist.add(2, "Pantry Car");
        System.out.println("\nAfter adding Pantry Car at position 2:");
        System.out.println(trainConsist);
        trainConsist.removeFirst();
        trainConsist.removeLast();
        System.out.println("\nAfter removing first and last bogie:");
        System.out.println(trainConsist);
        System.out.println("\nFinal Train Consist:");
        System.out.println(trainConsist);
    }
}