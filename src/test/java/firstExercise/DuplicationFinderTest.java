package firstExercise;

import java.util.Arrays;
import java.util.List;
import org.cern.firstExercise.DuplicationFinder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(JUnit4.class)
public class DuplicationFinderTest {

    @Test
    public void givenListWithStringDuplicatesWhenFindDuplicatesThenReturnCorrectDuplicates() {
        DuplicationFinder<String> duplicationFinder = new DuplicationFinder<>();
        List<String> input = Arrays.asList("b", "a", "c", "c", "e", "a", "c", "d", "c", "d");
        List<String> expected = Arrays.asList("a", "c", "d");

        List<String> actual = duplicationFinder.findDuplicates(input);

        assertEquals(expected, actual);
    }

    @Test
    public void givenListWithIntegerDuplicatesWhenFindDuplicatesThenReturnCorrectDuplicates() {
        DuplicationFinder<Integer> duplicationFinder = new DuplicationFinder<>();
        List<Integer> input = Arrays.asList(1, 2, 3, 3, 10, 2, 3, 80, 3, 74);
        List<Integer> expected = Arrays.asList(2, 3);

        List<Integer> actual = duplicationFinder.findDuplicates(input);

        assertEquals(expected, actual);
    }

    @Test
    public void givenListWithoutDuplicatesWhenFindDuplicatesThenNoDuplicatesAndListIsEmpty() {
        DuplicationFinder<String> duplicationFinder = new DuplicationFinder<>();
        List<String> input = Arrays.asList("a", "b", "c", "d", "e");

        List<String> actual = duplicationFinder.findDuplicates(input);

        assertTrue(actual.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullAsInputListThenThrowIllegalArgumentException() {
        DuplicationFinder<String> duplicationFinder = new DuplicationFinder<>();

        duplicationFinder.findDuplicates(null);
    }
}
