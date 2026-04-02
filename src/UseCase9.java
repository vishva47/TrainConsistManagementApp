import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UseCase9 {
    public static void main(String[] args) {
        List<String> bogies = Arrays.asList("Sleeper", "Goods", "Sleeper");
        Map<String, List<String>> grouped = bogies.stream()
            .collect(Collectors.groupingBy(b -> b.equals("Goods") ? "Goods" : "Passenger"));
        System.out.println("Grouped: " + grouped);
    }
}
