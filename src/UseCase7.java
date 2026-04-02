import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UseCase7 {
    static class Bogie {
        String name;
        int capacity;
        Bogie(String name, int capacity) { this.name = name; this.capacity = capacity; }
        public String toString() { return name + " (" + capacity + ")"; }
    }
    public static void main(String[] args) {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 18));
        bogies.sort(Comparator.comparingInt(b -> b.capacity));
        System.out.println("Sorted: " + bogies);
    }
}
