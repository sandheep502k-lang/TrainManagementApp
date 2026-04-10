import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistAppTest3 {

    @Test
    public void testReduce_TotalSeatCalculation() {

        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40)
        );

        int result = TrainConsistApp.totalCapacity(list);

        assertEquals(172, result);
    }

    @Test
    public void testReduce_MultipleBogiesAggregation() {

        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("AC", 50),
                new Bogie("Chair", 30)
        );

        int result = TrainConsistApp.totalCapacity(list);

        assertEquals(150, result);
    }

    @Test
    public void testReduce_SingleBogieCapacity() {

        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72)
        );

        int result = TrainConsistApp.totalCapacity(list);

        assertEquals(72, result);
    }

    @Test
    public void testReduce_EmptyBogieList() {

        int result = TrainConsistApp.totalCapacity(new ArrayList<>());

        assertEquals(0, result);
    }

    @Test
    public void testReduce_CorrectCapacityExtraction() {

        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 10),
                new Bogie("AC", 20)
        );

        int result = TrainConsistApp.totalCapacity(list);

        assertEquals(30, result);
    }

    @Test
    public void testReduce_AllBogiesIncluded() {

        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 10),
                new Bogie("AC", 20),
                new Bogie("First Class", 30)
        );

        int result = TrainConsistApp.totalCapacity(list);

        assertEquals(60, result);
    }

    @Test
    public void testReduce_OriginalListUnchanged() {

        List<Bogie> list = new ArrayList<>(Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC", 60)
        ));

        TrainConsistApp.totalCapacity(list);

        assertEquals(2, list.size());
    }
}