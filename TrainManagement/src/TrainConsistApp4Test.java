import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistApp4Test {

    @Test
    public void testRegex_ValidTrainID() {
        assertTrue(TrainConsistApp.isValidTrainId("TRN-1234"));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainConsistApp.isValidTrainId("TRAIN12"));
        assertFalse(TrainConsistApp.isValidTrainId("TRN12A"));
        assertFalse(TrainConsistApp.isValidTrainId("1234-TRN"));
    }

    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue(TrainConsistApp.isValidCargoCode("PET-AB"));
    }

    @Test
    public void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainConsistApp.isValidCargoCode("PET-ab"));
        assertFalse(TrainConsistApp.isValidCargoCode("PET123"));
        assertFalse(TrainConsistApp.isValidCargoCode("AB-PET"));
    }

    @Test
    public void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainConsistApp.isValidTrainId("TRN-123"));
        assertFalse(TrainConsistApp.isValidTrainId("TRN-12345"));
    }

    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainConsistApp.isValidCargoCode("PET-ab"));
    }

    @Test
    public void testRegex_EmptyInputHandling() {
        assertFalse(TrainConsistApp.isValidTrainId(""));
        assertFalse(TrainConsistApp.isValidCargoCode(""));
    }

    @Test
    public void testRegex_ExactPatternMatch() {
        assertFalse(TrainConsistApp.isValidTrainId("TRN-1234X"));
        assertFalse(TrainConsistApp.isValidCargoCode("PET-ABC"));
    }
}