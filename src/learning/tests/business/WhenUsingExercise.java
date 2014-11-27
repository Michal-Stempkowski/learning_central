package learning.tests.business;

import static org.junit.Assert.*;

import learning.business.Exercise;
import org.junit.Before;
import org.junit.Test;

public class WhenUsingExercise
{
    private final int exerciseId = 0;
    private Exercise exercise = null;

    @Before
    public void setUp()
    {
        exercise = new Exercise(exerciseId);
    }

    @Test
    public void theyShouldBeIdentifiedByUniqueId()
    {
        Exercise sameExercise = new Exercise(exerciseId);
        Exercise otherExercise = new Exercise(exerciseId + 1);

        assertEquals(exercise, sameExercise);
        assertNotEquals(exercise, otherExercise);
    }
}
