import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase8Test {

    // Helper method - same logic as UseCase8
    List<String> filterPassengerBogies(List<String> bogies) {
        return bogies.stream()
            .filter(b -> b.equals("Sleeper") || b.equals("AC Chair") || b.equals("First Class"))
            .collect(Collectors.toList());
    }

    // Test 1: Normal input - mixed bogies
    @Test
    public void testFilterReturnsOnlyPassengerBogies() {
        List<String> input = Arrays.asList(
            "Sleeper", "AC Chair", "First Class",
            "Rectangular Goods", "Cylindrical Goods", "Pantry Car"
        );
        List<String> result = filterPassengerBogies(input);
        assertEquals(3, result.size());
        assertTrue(result.contains("Sleeper"));
        assertTrue(result.contains("AC Chair"));
        assertTrue(result.contains("First Class"));
    }

    // Test 2: No passenger bogies in input
    @Test
    public void testFilterWithNoPassengerBogies() {
        List<String> input = Arrays.asList(
            "Rectangular Goods", "Cylindrical Goods", "Pantry Car"
        );
        List<String> result = filterPassengerBogies(input);
        assertEquals(0, result.size());
        assertTrue(result.isEmpty());
    }

    // Test 3: All passenger bogies
    @Test
    public void testFilterWithAllPassengerBogies() {
        List<String> input = Arrays.asList(
            "Sleeper", "AC Chair", "First Class"
        );
        List<String> result = filterPassengerBogies(input);
        assertEquals(3, result.size());
    }

    // Test 4: Empty list input
    @Test
    public void testFilterWithEmptyList() {
        List<String> input = Arrays.asList();
        List<String> result = filterPassengerBogies(input);
        assertEquals(0, result.size());
        assertTrue(result.isEmpty());
    }

    // Test 5: Duplicate passenger bogies
    @Test
    public void testFilterWithDuplicatePassengerBogies() {
        List<String> input = Arrays.asList(
            "Sleeper", "Sleeper", "AC Chair", "Cylindrical Goods"
        );
        List<String> result = filterPassengerBogies(input);
        assertEquals(3, result.size()); // duplicates kept (stream does not deduplicate)
    }

    // Test 6: Goods bogies are excluded
    @Test
    public void testGoodsBogiesAreExcluded() {
        List<String> input = Arrays.asList(
            "Sleeper", "Rectangular Goods", "Cylindrical Goods"
        );
        List<String> result = filterPassengerBogies(input);
        assertFalse(result.contains("Rectangular Goods"));
        assertFalse(result.contains("Cylindrical Goods"));
    }

    // Test 7: Pantry Car is excluded
    @Test
    public void testPantryCarIsExcluded() {
        List<String> input = Arrays.asList(
            "Sleeper", "Pantry Car", "First Class"
        );
        List<String> result = filterPassengerBogies(input);
        assertFalse(result.contains("Pantry Car"));
        assertEquals(2, result.size());
    }

    // Test 8: Case sensitivity check
    @Test
    public void testCaseSensitivity() {
        List<String> input = Arrays.asList(
            "sleeper", "ac chair", "SLEEPER", "Sleeper"
        );
        List<String> result = filterPassengerBogies(input);
        // Only exact match "Sleeper" passes
        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0));
    }
}
