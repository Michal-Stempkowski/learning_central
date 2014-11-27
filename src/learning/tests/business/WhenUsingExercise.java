package learning.tests.business;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import learning.business.Exercise;
import learning.business.ExerciseTemplate;
import org.junit.Before;
import org.junit.Test;


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

        assertThat(exercise, equalTo(sameExercise));
        assertThat(exercise, not(equalTo(otherExercise)));
    }

//    @Test
//    public void questionAndAnswersShouldBeEmptyOnStart()
//    {
//        assertThat(exercise.getQuestions().size(), equals
//    }

//    @Test
//    public void shouldBeAbleToListAllFactsFromExerciseTemplate()
//    {
//        Set<Fact> facts = new HashSet<>();
//
//        when(exerciseTemplateMock.getFacts()).thenReturn(facts);
//
//        assertEquals(exercise.getAllFacts(), facts);
//    }

//    @Test
//    public void onFactBaseResetFreeShouldBeAllFromTemplate()
//    {
//
//    }
}
