import java.util.LinkedHashSet;
import java.util.Set;

public class UseCase5 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        Set<String> bogies = new LinkedHashSet<>();
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");
        System.out.println("Bogies (Insertion Order): " + bogies);
    }
}
