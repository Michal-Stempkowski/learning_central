package learning.tests.business;

import learning.business.ExerciseTemplate;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WhenUsingExerciseTemplate
{
    private ExerciseTemplate exerciseTemplate = null;

    @Before
    public void setUp()
    {
        exerciseTemplate = new ExerciseTemplate();
    }

    @Test
    public void shouldBeAbleToListAllFacts()
    {
        assertThat(exerciseTemplate.getFacts().size(), equalTo(0));
    }
}
