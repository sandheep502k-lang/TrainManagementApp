import java.util.*;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        LinkedHashSet<String> formation = new LinkedHashSet<>();

        // Add bogies
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Attempt duplicate
        formation.add("Sleeper");

        // Display formation (order preserved, no duplicates)
        System.out.println("Train Formation: " + formation);
    }
}