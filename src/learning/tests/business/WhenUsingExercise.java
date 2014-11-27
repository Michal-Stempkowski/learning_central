package learning.tests.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import learning.business.Exercise;
import learning.business.ExerciseTemplate;
import learning.business.Fact;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class WhenUsingExercise
{
    private final int exerciseId = 0;
    private Exercise exercise = null;
    private ExerciseTemplate exerciseTemplateMock = null;

    @Before
    public void setUp()
    {
        exerciseTemplateMock = mock(ExerciseTemplate.class);
        exercise = new Exercise(exerciseId, exerciseTemplateMock);
    }

    @Test
    public void theyShouldBeIdentifiedByUniqueId()
    {
        Exercise sameExercise = new Exercise(exerciseId, exerciseTemplateMock);
        Exercise otherExercise = new Exercise(exerciseId + 1, exerciseTemplateMock);

        assertEquals(exercise, sameExercise);
        assertNotEquals(exercise, otherExercise);
    }

    @Test
    public void shouldBeAbleToListAllFactsFromExerciseTemplate()
    {
        Set<Fact> facts = new HashSet<>();

        when(exerciseTemplateMock.getFacts()).thenReturn(facts);

        assertEquals(exercise.getAllFacts(), facts);
    }
}
