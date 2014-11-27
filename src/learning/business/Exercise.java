package learning.business;

import java.util.Set;

public class Exercise
{
    public final int id;
    protected ExerciseTemplate template;

    public Exercise(int identifier, ExerciseTemplate exerciseTemplate)
    {
        id = identifier;
        template = exerciseTemplate;
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

    public Set<Fact> getAllFacts()
    {
        return template.getFacts();
    }
}
