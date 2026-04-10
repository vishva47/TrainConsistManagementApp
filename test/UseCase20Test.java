import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class UseCase20Test {

    static class TrainConsist {
        List<String> bogieIds = new ArrayList<>();

        void addBogie(String bogieId) {
            bogieIds.add(bogieId);
        }

        int searchBogie(String key) {
            if (bogieIds.isEmpty()) {
                throw new IllegalStateException("Cannot search. Train consist is empty.");
            }
            for (int i = 0; i < bogieIds.size(); i++) {
                if (bogieIds.get(i).equals(key)) return i;
            }
            return -1;
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testSearch_EmptyConsistThrowsException() {
        TrainConsist train = new TrainConsist();
        train.searchBogie("BG001");
    }

    @Test
    public void testSearch_ExceptionMessageIsMeaningful() {
        TrainConsist train = new TrainConsist();
        try {
            train.searchBogie("BG001");
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
            assertTrue(e.getMessage().contains("empty"));
        }
    }

    @Test
    public void testSearch_FoundAfterAddingBogies() {
        TrainConsist train = new TrainConsist();
        train.addBogie("BG001");
        train.addBogie("BG002");
        train.addBogie("BG003");
        assertEquals(1, train.searchBogie("BG002"));
    }

    @Test
    public void testSearch_NotFoundReturnsMinusOne() {
        TrainConsist train = new TrainConsist();
        train.addBogie("BG001");
        train.addBogie("BG002");
        assertEquals(-1, train.searchBogie("BG999"));
    }

    @Test
    public void testSearch_FirstElementFound() {
        TrainConsist train = new TrainConsist();
        train.addBogie("BG001");
        train.addBogie("BG002");
        train.addBogie("BG003");
        assertEquals(0, train.searchBogie("BG001"));
    }

    @Test
    public void testSearch_LastElementFound() {
        TrainConsist train = new TrainConsist();
        train.addBogie("BG001");
        train.addBogie("BG002");
        train.addBogie("BG003");
        assertEquals(2, train.searchBogie("BG003"));
    }

    @Test
    public void testSearch_ProgramContinuesAfterException() {
        TrainConsist train = new TrainConsist();
        try {
            train.searchBogie("BG001");
        } catch (IllegalStateException e) {
        }
        train.addBogie("BG001");
        assertEquals(0, train.searchBogie("BG001"));
    }

    @Test
    public void testSearch_SingleBogieFound() {
        TrainConsist train = new TrainConsist();
        train.addBogie("BG001");
        assertEquals(0, train.searchBogie("BG001"));
    }

    @Test
    public void testSearch_SingleBogieNotFound() {
        TrainConsist train = new TrainConsist();
        train.addBogie("BG001");
        assertEquals(-1, train.searchBogie("BG999"));
    }

    @Test
    public void testSearch_NoExceptionWhenConsistNonEmpty() {
        TrainConsist train = new TrainConsist();
        train.addBogie("BG001");
        try {
            train.searchBogie("BG001");
        } catch (IllegalStateException e) {
            fail("No exception expected");
        }
    }
}
