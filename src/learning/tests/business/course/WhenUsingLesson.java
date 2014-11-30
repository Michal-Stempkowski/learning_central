package learning.tests.business.course;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import learning.business.course.Exercise;
import learning.business.course.Lesson;
import org.junit.Before;
import org.junit.Test;

public class WhenUsingLesson
{
    private static final String exampleLessonDir = "C:\\lesson0";
    private Lesson lesson = null;

    @Before
    public void setUp()
    {
        lesson = new Lesson(exampleLessonDir);
    }

    @Test
    public void itsExerciseListShouldBeEmptyOnCreation()
    {
        assertThat(lesson.getExercises().size(), equalTo(0));
    }

    @Test
    public void lessonsShouldBeIdentifiedByUniquePathIdentifier()
    {
        Lesson sameLesson = new Lesson(exampleLessonDir);

        String someOtherLessonDir = "C:\\lesson1";

        Lesson someOtherLesson = new Lesson(someOtherLessonDir);

        assertThat(lesson, equalTo(sameLesson));
        assertThat(lesson, not(equalTo(someOtherLesson)));
        assertThat(lesson.getId(), is(equalTo(exampleLessonDir)));
    }

    @Test
    public void shouldBeAbleToAddNewExercise()
    {
        Exercise toBeAdded = mock(Exercise.class);
        assertThat(lesson.getExercises().size(), equalTo(0));
        lesson.addExercise(toBeAdded);

        assertThat(lesson.getExercises().size(), equalTo(1));
        assertThat(lesson.getExercises(), hasItem(toBeAdded));
    }

    @Test
    public void shouldBeAbleToRemoveExercise()
    {
        Exercise toBeRemoved = mock(Exercise.class);
        lesson.addExercise(toBeRemoved);
        assertThat(lesson.getExercises(), hasItem(toBeRemoved));

        lesson.removeExercise(toBeRemoved);

        assertThat(lesson.getExercises(), not(hasItem(toBeRemoved)));
    }
}
