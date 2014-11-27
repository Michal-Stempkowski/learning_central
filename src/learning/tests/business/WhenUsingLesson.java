package learning.tests.business;

import static org.junit.Assert.*;

import learning.business.Exercise;
import learning.business.Lesson;
import org.junit.Before;
import org.junit.Test;

public class WhenUsingLesson
{
    private static final int exampleExerciseId = 0;
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
        assertEquals(0, lesson.getExercises().size());
    }

    @Test
    public void lessonsShouldBeIdentifiedByUniquePathIdentifier()
    {
        Lesson sameLesson = new Lesson(exampleLessonDir);

        String someOtherLessonDir = "C:\\lesson1";

        Lesson someOtherLesson = new Lesson(someOtherLessonDir);

        assertEquals(lesson, sameLesson);
        assertNotEquals(lesson, someOtherLesson);
    }

    @Test
    public void shouldBeAbleToAddNewExercise()
    {
        Exercise toBeAdded = new Exercise(exampleExerciseId);
        assertEquals(0, lesson.getExercises().size());
        lesson.addExercise(toBeAdded);

        assertEquals(1, lesson.getExercises().size());
        assertTrue(lesson.getExercises().contains(toBeAdded));
    }

    @Test
    public void shouldBeAbleToRemoveExercise()
    {
        Exercise toBeRemoved = new Exercise(exampleExerciseId);
        lesson.addExercise(toBeRemoved);
        assertTrue(lesson.getExercises().contains(toBeRemoved));

        lesson.removeExercise(toBeRemoved);

        assertFalse(lesson.getExercises().contains(toBeRemoved));
    }
}
