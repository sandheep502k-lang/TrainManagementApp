import java.util.*;
import java.util.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;
class TrainConsistApp6Test {
    @Test
    public void testLoopFilteringLogic() {

        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 80)
        );
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : list) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        assertEquals(2, result.size());
    }
    @Test
    public void testStreamFilteringLogic() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 80)
        );
        List<Bogie> result = list.stream()
                .filter(b -> b.capacity > 60)
                .toList();
        assertEquals(2, result.size());
    }
    @Test
    public void testLoopAndStreamResultsMatch() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 80)
        );
        // Loop result
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : list) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }
        // Stream result
        List<Bogie> streamResult = list.stream()
                .filter(b -> b.capacity > 60)
                .toList();
        assertEquals(loopResult.size(), streamResult.size());
    }
    @Test
    public void testExecutionTimeMeasurement() {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Bogie("Sleeper", i));
        }
        // Loop timing
        long start1 = System.nanoTime();
        for (Bogie b : list) {
            if (b.capacity > 60) {}
        }
        long end1 = System.nanoTime();
        // Stream timing
        long start2 = System.nanoTime();
        list.stream().filter(b -> b.capacity > 60).count();
        long end2 = System.nanoTime();
        long loopTime = end1 - start1;
        long streamTime = end2 - start2;
        assertTrue(loopTime > 0);
        assertTrue(streamTime > 0);
    }
    @Test
    public void testLargeDatasetProcessing() {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            list.add(new Bogie("Sleeper", i));
        }
        List<Bogie> result = list.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertNotNull(result);
    }
}