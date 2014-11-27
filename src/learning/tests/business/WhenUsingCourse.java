package learning.tests.business;

import learning.business.Course;
import learning.business.Lesson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WhenUsingCourse
{
    private static final String exampleLessonDir = "C:\\lesson0";
    private Course course = null;

    @Before
    public void setUp()
    {
        course = new Course();
    }

    @Test
    public void itsLessonListShouldBeEmptyOnCreation()
    {
        assertEquals(0, course.getLessons().size());
    }

    @Test
    public void shouldBeAbleToGetAndSetStartingOccurrences()
    {
        assertEquals(0, course.getStartingOccurrences());
        course.setStartingOccurrences(5);
        assertEquals(5, course.getStartingOccurrences());
    }

    @Test
    public void shouldBeAbleToGetAndSetAddedByError()
    {
        assertEquals(0, course.getAddedByError());
        course.setAddedByError(3);
        assertEquals(3, course.getAddedByError());
    }

    @Test
    public void shouldBeAbleToGetAndSetMinimumPoolSize()
    {
        assertEquals(0, course.getMinimumPoolSize());
        course.setMinimumPoolSize(3);
        assertEquals(3, course.getMinimumPoolSize());
    }

    @Test
    public void shouldBeAbleToGetAndSetMaximumPoolSize()
    {
        assertEquals(0, course.getMaximumPoolSize());
        course.setMaximumPoolSize(3);
        assertEquals(3, course.getMaximumPoolSize());
    }

    @Test
    public void shouldBeAbleToAddNewLesson()
    {
        Lesson toBeAdded = new Lesson(exampleLessonDir);
        assertEquals(0, course.getLessons().size());
        course.addLesson(toBeAdded);

        assertEquals(1, course.getLessons().size());
        assertTrue(course.getLessons().contains(toBeAdded));
    }

    @Test
    public void shouldBeAbleToRemoveLesson()
    {
        Lesson toBeRemoved = new Lesson(exampleLessonDir);
        course.addLesson(toBeRemoved);
        assertTrue(course.getLessons().contains(toBeRemoved));

        course.removeLesson(toBeRemoved);

        assertFalse(course.getLessons().contains(toBeRemoved));
    }
}
