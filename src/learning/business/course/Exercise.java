package learning.business.course;

import learning.business.template.ExerciseTemplate;
import learning.business.template.Fact;
import learning.business.exceptions.FactNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class Exercise
{
    public final int id;

    private final Lesson lesson;

    private final Set<Fact> questions;
    private final Set<Fact> answers;
    private final Set<Fact> unused;

    private double occurrenceMultiplier;

    public Exercise(int identifier, Lesson connectedlesson)
    {
        id = identifier;
        lesson = connectedlesson;
        questions = new HashSet<>();
        answers = new HashSet<>();
        unused = new HashSet<>();
        occurrenceMultiplier = 1.0;
    }

    @Override
    public int hashCode()
    {
        return id;
    }

    @Override
    public boolean equals(Object obj)
    {
        //noinspection UnclearBinaryExpression
        return obj instanceof Exercise && ((Exercise) obj).id == id;
    }

    public Set<Fact> getQuestions()
    {
        return questions;
    }

    public Set<Fact> getAnswers()
    {
        return answers;
    }

    public Set<Fact> getUnused()
    {
        return unused;
    }

    public void resetWithTemplate(ExerciseTemplate exerciseTemplateMock)
    {
        questions.clear();
        answers.clear();
        unused.clear();
        unused.addAll(exerciseTemplateMock.getFacts());
    }

    private void throwIfNotUnused(Fact fact)
    {
        if (!unused.contains(fact))
        {
            throw new FactNotFoundException(fact);
        }
    }

    public void addQuestion(Fact questionToBe)
    {
        throwIfNotUnused(questionToBe);

        questions.add(questionToBe);
        unused.remove(questionToBe);
    }

    public void removeQuestion(Fact questionToRemove)
    {
        if (!questions.contains(questionToRemove))
        {
            throw new FactNotFoundException(questionToRemove);
        }

        questions.remove(questionToRemove);
        unused.add(questionToRemove);
    }

    public void addAnswer(Fact answerToBe)
    {
        throwIfNotUnused(answerToBe);

        answers.add(answerToBe);
        unused.remove(answerToBe);
    }

    public void removeAnswer(Fact answerToRemove)
    {
        if (!answers.contains(answerToRemove))
        {
            throw new FactNotFoundException(answerToRemove);
        }

        answers.remove(answerToRemove);
        unused.add(answerToRemove);
    }

    public double getOccurrenceMultiplier()
    {
        return occurrenceMultiplier;
    }

    public void setOccurrenceMultiplier(double newOccurrenceMultiplier)
    {
        occurrenceMultiplier = newOccurrenceMultiplier;
    }

    public String getId()
    {
        return lesson.getId() + Lesson.INTERNAL_PATH_SEPARATOR + id;
    }
}
