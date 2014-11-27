package learning.tests.business;

import learning.business.Course;
import learning.business.Lesson;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

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
        assertThat(course.getLessons().size(), equalTo(0));
    }

    @Test
    public void shouldBeAbleToGetAndSetStartingOccurrences()
    {
        assertThat(course.getStartingOccurrences(), equalTo(0));
        course.setStartingOccurrences(5);
        assertThat(course.getStartingOccurrences(), equalTo(5));
    }

    @Test
    public void shouldBeAbleToGetAndSetAddedByError()
    {
        assertThat(course.getAddedByError(), equalTo(0));
        course.setAddedByError(3);
        assertThat(course.getAddedByError(), equalTo(3));
    }

    @Test
    public void shouldBeAbleToGetAndSetMinimumPoolSize()
    {
        assertThat(course.getMinimumPoolSize(), equalTo(0));
        course.setMinimumPoolSize(3);
        assertThat(course.getMinimumPoolSize(), equalTo(3));
    }

    @Test
    public void shouldBeAbleToGetAndSetMaximumPoolSize()
    {
        assertThat(course.getMaximumPoolSize(), equalTo(0));
        course.setMaximumPoolSize(3);
        assertThat(course.getMaximumPoolSize(), equalTo(3));
    }

    @Test
    public void shouldBeAbleToAddNewLesson()
    {
        Lesson toBeAdded = new Lesson(exampleLessonDir);
        assertThat(course.getLessons().size(), equalTo(0));
        course.addLesson(toBeAdded);

        assertThat(course.getLessons().size(), equalTo(1));
        assertThat(course.getLessons(), hasItem(toBeAdded));
    }

    @Test
    public void shouldBeAbleToRemoveLesson()
    {
        Lesson toBeRemoved = new Lesson(exampleLessonDir);
        course.addLesson(toBeRemoved);
        assertThat(course.getLessons(), hasItem(toBeRemoved));

        course.removeLesson(toBeRemoved);

        assertThat(course.getLessons(), not(hasItem(toBeRemoved)));
    }
}
