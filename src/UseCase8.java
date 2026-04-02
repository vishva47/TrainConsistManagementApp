import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase8 {
    public static void main(String[] args) {
        List<String> bogies = Arrays.asList("Sleeper", "AC Chair", "Goods");
        List<String> passenger = bogies.stream()
            .filter(b -> !b.equals("Goods"))
            .collect(Collectors.toList());
        System.out.println("Passenger: " + passenger);
    }
}
