import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class UseCase17Test {

    @Test
    public void testSort_BasicAlphabeticalSorting() {
        String[] bogieTypes = {"Sleeper", "First Class", "AC Chair"};
        Arrays.sort(bogieTypes);
        assertArrayEquals(
            new String[]{"AC Chair", "First Class", "Sleeper"},
            bogieTypes
        );
    }

    @Test
    public void testSort_AlreadySortedArray() {
        String[] bogieTypes = {"AC Chair", "First Class", "Sleeper"};
        Arrays.sort(bogieTypes);
        assertArrayEquals(
            new String[]{"AC Chair", "First Class", "Sleeper"},
            bogieTypes
        );
    }

    @Test
    public void testSort_DuplicateValues() {
        String[] bogieTypes = {"Sleeper", "AC Chair", "Sleeper", "First Class"};
        Arrays.sort(bogieTypes);
        assertArrayEquals(
            new String[]{"AC Chair", "First Class", "Sleeper", "Sleeper"},
            bogieTypes
        );
    }

    @Test
    public void testSort_SingleElementArray() {
        String[] bogieTypes = {"Sleeper"};
        Arrays.sort(bogieTypes);
        assertArrayEquals(new String[]{"Sleeper"}, bogieTypes);
    }

    @Test
    public void testSort_AllEqualValues() {
        String[] bogieTypes = {"Sleeper", "Sleeper", "Sleeper"};
        Arrays.sort(bogieTypes);
        assertArrayEquals(
            new String[]{"Sleeper", "Sleeper", "Sleeper"},
            bogieTypes
        );
    }

    @Test
    public void testSort_ReverseSortedArray() {
        String[] bogieTypes = {"Sleeper", "Rectangular Goods",
                               "First Class", "Cylindrical Goods", "AC Chair"};
        Arrays.sort(bogieTypes);
        assertArrayEquals(
            new String[]{"AC Chair", "Cylindrical Goods", "First Class",
                         "Rectangular Goods", "Sleeper"},
            bogieTypes
        );
    }

    @Test
    public void testSort_FirstElementIsSmallest() {
        String[] bogieTypes = {"Sleeper", "First Class",
                               "AC Chair", "Pantry Car"};
        Arrays.sort(bogieTypes);
        assertEquals("AC Chair", bogieTypes[0]);
    }

    @Test
    public void testSort_LastElementIsLargest() {
        String[] bogieTypes = {"Sleeper", "First Class",
                               "AC Chair", "Pantry Car"};
        Arrays.sort(bogieTypes);
        assertEquals("Sleeper", bogieTypes[bogieTypes.length - 1]);
    }
}
