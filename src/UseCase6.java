import java.util.HashMap;
import java.util.Map;

public class UseCase6 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        Map<String, Integer> bogieCapacity = new HashMap<>();
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 64);
        System.out.println("Bogie Capacity Map: " + bogieCapacity);
    }
}
