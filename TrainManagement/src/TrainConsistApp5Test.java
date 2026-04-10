import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistApp5Test {
        @Test
        public void testSafety_AllBogiesValid() {

            List<TrainConsistApp.GoodsBogie> list = Arrays.asList(
                    new TrainConsistApp.GoodsBogie("Cylindrical", "Petroleum"),
                    new TrainConsistApp.GoodsBogie("Box", "Coal")
            );

            assertTrue(TrainConsistApp.isSafe(list));
        }

        @Test
        public void testSafety_CylindricalWithInvalidCargo() {

            List<TrainConsistApp.GoodsBogie> list = List.of(
                    new TrainConsistApp.GoodsBogie("Cylindrical", "Coal")
            );

            assertFalse(TrainConsistApp.isSafe(list));
        }

        @Test
        public void testSafety_NonCylindricalBogiesAllowed() {

            List<TrainConsistApp.GoodsBogie> list = Arrays.asList(
                    new TrainConsistApp.GoodsBogie("Box", "Coal"),
                    new TrainConsistApp.GoodsBogie("Open", "Grain")
            );

            assertTrue(TrainConsistApp.isSafe(list));
        }

        @Test
        public void testSafety_MixedBogiesWithViolation() {

            List<TrainConsistApp.GoodsBogie> list = Arrays.asList(
                    new TrainConsistApp.GoodsBogie("Cylindrical", "Petroleum"),
                    new TrainConsistApp.GoodsBogie("Cylindrical", "Coal")
            );

            assertFalse(TrainConsistApp.isSafe(list));
        }

        @Test
        public void testSafety_EmptyBogieList() {

            assertTrue(TrainConsistApp.isSafe(new ArrayList<>()));
        }
    }