import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class trainConsistAppTest2 {

    @Test
    public void testGrouping_BogiesGroupedByType() {

        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70)
        );

        Map<String, List<Bogie>> result =
                TrainConsistApp.group(list);

        assertTrue(result.containsKey("Sleeper"));
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {

        List<Bogie> list = Arrays.asList(
                new Bogie("AC Chair", 60),
                new Bogie("AC Chair", 65)
        );

        Map<String, List<Bogie>> result =
                TrainConsistApp.group(list);

        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    public void testGrouping_DifferentBogieTypes() {

        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40)
        );

        Map<String, List<Bogie>> result =
                TrainConsistApp.group(list);

        assertEquals(3, result.size());
    }

    @Test
    public void testGrouping_EmptyBogieList() {

        Map<String, List<Bogie>> result =
                TrainConsistApp.group(new ArrayList<>());

        assertTrue(result.isEmpty());
    }

    @Test
    public void testGrouping_SingleBogieCategory() {

        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70)
        );

        Map<String, List<Bogie>> result =
                TrainConsistApp.group(list);

        assertEquals(1, result.size());
    }

    @Test
    public void testGrouping_MapContainsCorrectKeys() {

        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40)
        );

        Map<String, List<Bogie>> result =
                TrainConsistApp.group(list);

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    public void testGrouping_GroupSizeValidation() {

        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );

        Map<String, List<Bogie>> result =
                TrainConsistApp.group(list);

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    @Test
    public void testGrouping_OriginalListUnchanged() {

        List<Bogie> list = new ArrayList<>(Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60)
        ));

        TrainConsistApp.group(list);

        assertEquals(2, list.size());
    }
}