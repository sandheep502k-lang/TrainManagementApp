import java.util.*;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        LinkedList<String> train = new LinkedList<>();

        // Add bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        // Insert Pantry Car at position 2
        train.add(2, "Pantry Car");

        // Remove first and last
        train.removeFirst();
        train.removeLast();

        // Display final consist
        System.out.println("Final Train Consist: " + train);
    }
}