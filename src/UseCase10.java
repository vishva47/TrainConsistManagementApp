import java.util.Arrays;
import java.util.List;

public class UseCase10 {
    static class Bogie {
        String name;
        int capacity;
        Bogie(String name, int capacity) { this.name = name; this.capacity = capacity; }
    }
    public static void main(String[] args) {
        List<Bogie> bogies = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("AC", 64));
        int total = bogies.stream().mapToInt(b -> b.capacity).reduce(0, Integer::sum);
        System.out.println("Total Seats: " + total);
    }
}
