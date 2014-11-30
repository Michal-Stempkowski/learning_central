package learning.tests.business.kata;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import learning.business.course.Course;
import learning.business.course.Exercise;
import learning.business.course.Lesson;
import learning.business.kata.Flashcard;
import org.junit.Before;
import org.junit.Test;

public class WhenTestingFlashCard
{

    private Course mockCourse = null;
    private Lesson mockLesson = null;
    private Exercise mockExercise = null;
    private Flashcard flashcard = null;

    @Before
    public void setUp()
    {
        mockCourse = mock(Course.class);
        mockLesson = mock(Lesson.class);
        mockExercise = mock(Exercise.class);
        flashcard = new Flashcard(mockCourse, mockLesson, mockExercise);
    }

    @Test
    public void itShouldContainUniqueId()
    {
        when(mockExercise.getId()).thenReturn("Path0\\Path1");

        assertThat(flashcard.getId(), is(equalTo("Path0\\Path1\\flashcard")));
    }

    @Test
    public void atStartNumberOfOccurrencesShouldBeValid()
    {
        givenFlashcard();

        assertThat(flashcard.getOccurrences(), is(equalTo(15)));
    }

    private void givenFlashcard()
    {
        when(mockCourse.getAddedByError()).thenReturn(4);
        when(mockCourse.getStartingOccurrences()).thenReturn(10);
        when(mockExercise.getOccurrenceMultiplier()).thenReturn(1.5);
        flashcard = new Flashcard(mockCourse, mockLesson, mockExercise);
    }

    @Test
    public void onErrorNewOccurrencesShouldBeAdded()
    {
        givenFlashcard();

        flashcard.registerBadAnswer();

        assertThat(flashcard.getOccurrences(), is(equalTo(21)));
    }

    @Test
    public void onValidAnswerOccurrencesShouldDecrease()
    {
        givenFlashcard();

        flashcard.registerCorrectAnswer();

        assertThat(flashcard.getOccurrences(), is(equalTo(14)));
    }


}
