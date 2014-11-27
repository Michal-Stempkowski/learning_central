package learning.tests.business;

import static learning.utils.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import learning.business.Exercise;
import learning.business.ExerciseTemplate;
import learning.business.Fact;
import learning.business.exceptions.FactNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
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
        exercise = new Exercise(exerciseId);
    }

    @Test
    public void theyShouldBeIdentifiedByUniqueId()
    {
        Exercise sameExercise = new Exercise(exerciseId);
        Exercise otherExercise = new Exercise(exerciseId + 1);

        assertThat(exercise, equalTo(sameExercise));
        assertThat(exercise, not(equalTo(otherExercise)));
    }

    @Test
    public void questionAnswersAndUnusedShouldBeEmptyOnStart()
    {
        assertThat(exercise.getQuestions().size(), equalTo(0));
        assertThat(exercise.getAnswers().size(), equalTo(0));
        assertThat(exercise.getUnused().size(), equalTo(0));
    }

    private void resetFacts(Fact... availableFacts)
    {
        Set<Fact> facts = new HashSet<>();
        facts.addAll(Arrays.asList(availableFacts));
        when(exerciseTemplateMock.getFacts()).thenReturn(facts);

        exercise.resetWithTemplate(exerciseTemplateMock);
    }

    @Test
    public void resetCopiesFactsFromTemplate()
    {
        Fact fact = mock(Fact.class);
        assertThat(exercise.getUnused().size(), equalTo(0));

        resetFacts(fact);

        assertThat(exercise.getUnused(), is(equalTo(exerciseTemplateMock.getFacts())));
    }

    @Test
    public void resetRemovesOldFacts()
    {
        Fact fact = mock(Fact.class);
        resetFacts(fact);
        assertThat(exercise.getUnused(), hasItem(fact));

        resetFacts();

        assertThat(exercise.getUnused(), not(hasItem(fact)));
    }

    @Test
    public void resetRemovesOldQuestions()
    {
        Fact question = mock(Fact.class);
        resetFacts(question);
        exercise.addQuestion(question);

        assertThat(exercise.getQuestions(), hasItem(question));

        resetFacts();

        assertThat(exercise.getQuestions(), not(hasItem(question)));
    }

    @Test
    public void resetRemovesOldAnswers()
    {
        Fact answer = mock(Fact.class);
        resetFacts(answer);
        exercise.addAnswer(answer);

        assertThat(exercise.getAnswers(), hasItem(answer));

        resetFacts();

        assertThat(exercise.getAnswers(), not(hasItem(answer)));
    }

    @Test
    public void ifUnknownFactAddShouldThrowAnException()
    {
        Fact fact = mock(Fact.class);
        FactNotFoundException exception = new FactNotFoundException(fact);

        assertThrown(() -> exercise.addAnswer(fact), exception);
        assertThrown(() -> exercise.addQuestion(fact), exception);
    }

    @Test
    public void ifFactIsAnAnswerItShouldNotBeAccessibleInQuestionContext()
    {
        Fact fact = mock(Fact.class);
        FactNotFoundException exception = new FactNotFoundException(fact);
        resetFacts(fact);
        exercise.addAnswer(fact);

        assertThrown(() -> exercise.addQuestion(fact), exception);
        assertThrown(() -> exercise.removeQuestion(fact), exception);
    }

    @Test
    public void ifFactIsAQuestionItShouldNotBeAccessibleInAnswerContext()
    {
        Fact fact = mock(Fact.class);
        FactNotFoundException exception = new FactNotFoundException(fact);
        resetFacts(fact);
        exercise.addQuestion(fact);

        assertThrown(() -> exercise.addAnswer(fact), exception);
        assertThrown(() -> exercise.removeAnswer(fact), exception);
    }

    @Test
    public void addQuestionUpdatesQuestionsAndUnused()
    {
        Fact questionToBe = mock(Fact.class);
        resetFacts(questionToBe);
        assertThat(exercise.getQuestions(), not(hasItem(questionToBe)));
        assertThat(exercise.getUnused(), hasItem(questionToBe));

        exercise.addQuestion(questionToBe);

        assertThat(exercise.getQuestions(), hasItem(questionToBe));
        assertThat(exercise.getUnused(), not(hasItem(questionToBe)));
    }

    @Test
    public void addAnswerUpdatesAnswersAndUnused()
    {
        Fact answerToBe = mock(Fact.class);
        resetFacts(answerToBe);
        assertThat(exercise.getAnswers(), not(hasItem(answerToBe)));
        assertThat(exercise.getUnused(), hasItem(answerToBe));

        exercise.addAnswer(answerToBe);

        assertThat(exercise.getAnswers(), hasItem(answerToBe));
        assertThat(exercise.getUnused(), not(hasItem(answerToBe)));
    }

    @Test
    public void removeQuestionUpdatesQuestionsAndUnused()
    {
        Fact removedQuestion = mock(Fact.class);
        resetFacts(removedQuestion);
        exercise.addQuestion(removedQuestion);
        assertThat(exercise.getQuestions(), hasItem(removedQuestion));
        assertThat(exercise.getUnused(), not(hasItem(removedQuestion)));

        exercise.removeQuestion(removedQuestion);

        assertThat(exercise.getQuestions(), not(hasItem(removedQuestion)));
        assertThat(exercise.getUnused(), hasItem(removedQuestion));
    }

    @Test
    public void removeAnswerUpdatesAnswersAndUnused()
    {
        Fact removedAnswer = mock(Fact.class);
        resetFacts(removedAnswer);
        exercise.addAnswer(removedAnswer);
        assertThat(exercise.getAnswers(), hasItem(removedAnswer));
        assertThat(exercise.getUnused(), not(hasItem(removedAnswer)));

        exercise.removeAnswer(removedAnswer);

        assertThat(exercise.getAnswers(), not(hasItem(removedAnswer)));
        assertThat(exercise.getUnused(), hasItem(removedAnswer));
    }
}
