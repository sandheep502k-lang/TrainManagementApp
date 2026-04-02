import java.util.*;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<String> bogies = new ArrayList<>();

        // Add bogies
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");

        System.out.println("After Adding Bogies: " + bogies);

        // Remove a bogie
        bogies.remove("AC Chair");
        System.out.println("After Removing AC Chair: " + bogies);

        // Check existence
        System.out.println("Contains Sleeper? " + bogies.contains("Sleeper"));

        // Final state
        System.out.println("Final Bogie List: " + bogies);
    }
}