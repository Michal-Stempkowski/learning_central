package learning.business;

public class Exercise
{
    public final int id;

    public Exercise(int identifier)
    {
        id = identifier;
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
}
