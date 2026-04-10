import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class UseCase14Test {

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) { super(message); }
    }

    static class PassengerBogie {
        String bogieId;
        String bogieType;
        int capacity;

        PassengerBogie(String bogieId, String bogieType, int capacity)
                throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException(
                    "Invalid capacity: " + capacity + " for bogie " + bogieId
                );
            }
            this.bogieId = bogieId;
            this.bogieType = bogieType;
            this.capacity = capacity;
        }
    }

    @Test
    public void testValidCapacityCreatesBogie() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("BG001", "Sleeper", 72);
        assertEquals("BG001", bogie.bogieId);
        assertEquals(72, bogie.capacity);
    }

    @Test(expected = InvalidCapacityException.class)
    public void testZeroCapacityThrowsException() throws InvalidCapacityException {
        new PassengerBogie("BG002", "Sleeper", 0);
    }

    @Test(expected = InvalidCapacityException.class)
    public void testNegativeCapacityThrowsException() throws InvalidCapacityException {
        new PassengerBogie("BG003", "AC Chair", -5);
    }

    @Test
    public void testInvalidBogieNotAddedToConsist() {
        List<PassengerBogie> consist = new ArrayList<>();
        try {
            consist.add(new PassengerBogie("BG004", "Sleeper", -10));
        } catch (InvalidCapacityException e) {
        }
        assertEquals(0, consist.size());
    }

    @Test
    public void testValidBogieAddedToConsist() throws InvalidCapacityException {
        List<PassengerBogie> consist = new ArrayList<>();
        consist.add(new PassengerBogie("BG001", "Sleeper", 72));
        assertEquals(1, consist.size());
    }

    @Test
    public void testProgramContinuesAfterException() {
        List<PassengerBogie> consist = new ArrayList<>();
        String[][] data = {
            {"BG001", "Sleeper",     "72"},
            {"BG002", "AC Chair",    "-5"},
            {"BG003", "First Class", "18"},
            {"BG004", "Sleeper",     "0"},
            {"BG005", "AC Chair",    "64"}
        };
        for (String[] d : data) {
            try {
                consist.add(new PassengerBogie(d[0], d[1], Integer.parseInt(d[2])));
            } catch (InvalidCapacityException e) {
            }
        }
        assertEquals(3, consist.size());
    }
}
