package learning.business;

import learning.business.exceptions.FactNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class Exercise
{
    public final int id;

    protected Set<Fact> questions;
    protected Set<Fact> answers;
    protected Set<Fact> unused;

    public Exercise(int identifier)
    {
        id = identifier;
        questions = new HashSet<>();
        answers = new HashSet<>();
        unused = new HashSet<>();
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
}
