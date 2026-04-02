import java.util.*;
import java.util.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistAppTest {


    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40)
        );

        List<Bogie> result = TrainConsistApp.filter(list, 60);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    @Test
    public void testFilter_CapacityEqualToThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72)
        );

        List<Bogie> result = TrainConsistApp.filter(list, 72);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_CapacityLessThanThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60)
        );

        List<Bogie> result = TrainConsistApp.filter(list, 70);

        assertEquals(1, result.size());
    }

    @Test
    public void testFilter_MultipleBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC", 75),
                new Bogie("Chair", 50)
        );

        List<Bogie> result = TrainConsistApp.filter(list, 70);

        assertEquals(2, result.size());
    }

    @Test
    public void testFilter_NoBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("AC", 40)
        );

        List<Bogie> result = TrainConsistApp.filter(list, 100);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_AllBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40)
        );

        List<Bogie> result = TrainConsistApp.filter(list, 10);

        assertEquals(3, result.size());
    }

    @Test
    public void testFilter_EmptyBogieList() {
        List<Bogie> result = TrainConsistApp.filter(new ArrayList<>(), 50);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>(Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60)
        ));

        TrainConsistApp.filter(list, 60);

        assertEquals(2, list.size());
    }
}