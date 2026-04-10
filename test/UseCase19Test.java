import org.junit.Test;
import static org.junit.Assert.*;

public class UseCase19Test {

    String[] bogieIds = {
        "BG001", "BG002", "BG003", "BG004",
        "BG005", "BG006", "BG007", "BG008"
    };

    int binarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].compareTo(key);
            if (cmp == 0)       return mid;
            else if (cmp < 0)   low = mid + 1;
            else                high = mid - 1;
        }
        return -1;
    }

    @Test
    public void testSearch_FirstElementFound() {
        assertEquals(0, binarySearch(bogieIds, "BG001"));
    }

    @Test
    public void testSearch_LastElementFound() {
        assertEquals(7, binarySearch(bogieIds, "BG008"));
    }

    @Test
    public void testSearch_MiddleElementFound() {
        int result = binarySearch(bogieIds, "BG004");
        assertNotEquals(-1, result);
        assertEquals("BG004", bogieIds[result]);
    }

    @Test
    public void testSearch_KeyNotFound() {
        assertEquals(-1, binarySearch(bogieIds, "BG010"));
    }

    @Test
    public void testSearch_KeyBeforeRange() {
        assertEquals(-1, binarySearch(bogieIds, "BG000"));
    }

    @Test
    public void testSearch_KeyAfterRange() {
        assertEquals(-1, binarySearch(bogieIds, "BG099"));
    }

    @Test
    public void testSearch_SingleElementFound() {
        String[] single = {"BG001"};
        assertEquals(0, binarySearch(single, "BG001"));
    }

    @Test
    public void testSearch_SingleElementNotFound() {
        String[] single = {"BG001"};
        assertEquals(-1, binarySearch(single, "BG002"));
    }

    @Test
    public void testSearch_EmptyArray() {
        String[] empty = {};
        assertEquals(-1, binarySearch(empty, "BG001"));
    }

    @Test
    public void testSearch_CorrectIndexReturned() {
        int index = binarySearch(bogieIds, "BG003");
        assertEquals(2, index);
        assertEquals("BG003", bogieIds[index]);
    }
}
