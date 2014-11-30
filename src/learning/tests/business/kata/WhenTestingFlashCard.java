package learning.tests.business.kata;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

import learning.business.course.Course;
import learning.business.course.Exercise;
import learning.business.course.Lesson;
import learning.business.kata.*;
import org.junit.Before;
import org.junit.Test;

public class WhenTestingFlashCard
{

    private Course mockCourse = null;
    private Lesson mockLesson = null;
    private Exercise mockExercise = null;
    private UserAnswerValidator mockAnswerValidator = null;
    private Flashcard flashcard = null;

    @Before
    public void setUp()
    {
        mockCourse = mock(Course.class);
        mockLesson = mock(Lesson.class);
        mockExercise = mock(Exercise.class);
        mockAnswerValidator = mock(UserAnswerValidator.class);

        when(mockCourse.getAddedByError()).thenReturn(4);
        when(mockCourse.getStartingOccurrences()).thenReturn(10);
        when(mockExercise.getOccurrenceMultiplier()).thenReturn(1.5);
        when(mockExercise.validateUserAnswer(isA(UserAnswer.class))).thenReturn(mockAnswerValidator);
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
       assertThat(flashcard.getOccurrences(), is(equalTo(15)));
    }

    @Test
    public void onErrorNewOccurrencesShouldBeAdded()
    {
        flashcard.registerBadAnswer();

        assertThat(flashcard.getOccurrences(), is(equalTo(21)));
    }

    @Test
    public void onValidAnswerOccurrencesShouldDecrease()
    {
        flashcard.registerCorrectAnswer();

        assertThat(flashcard.getOccurrences(), is(equalTo(14)));
    }

    @Test
    public void shouldTellIfFlashcardShouldBeStillUsed()
    {
        assertThat(flashcard.isMemorized(), is(equalTo(false)));

        flashcard.setOccurrences(0);

        assertThat(flashcard.isMemorized(), is(equalTo(true)));
    }

    @Test
    public void givenIncorrectAnswerValidationShouldNoticeBadAnswer()
    {
        assertThat(flashcard.getOccurrences(), is(equalTo(15)));
        when(mockAnswerValidator.isCorrect()).thenReturn(false);

        flashcard.registerUserAnswer(new UserAnswerInvalidValidator());

        assertThat(flashcard.getOccurrences(), is(equalTo(21)));
    }

    @Test
    public void givenCorrectAnswerValidationShouldNoticeGoodAnswer()
    {
        assertThat(flashcard.getOccurrences(), is(equalTo(15)));
        when(mockAnswerValidator.isCorrect()).thenReturn(true);

        flashcard.registerUserAnswer(new UserAnswerValidValidator());

        assertThat(flashcard.getOccurrences(), is(equalTo(14)));
    }
}
