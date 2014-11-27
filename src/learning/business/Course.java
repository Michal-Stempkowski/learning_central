package learning.business;

import java.util.HashSet;
import java.util.Set;

public class Course
{
    private Set<Lesson> lessons;
    private int addedByError;
    private int startingOccurrences;
    private int minimumPoolSize;
    private int maximumPoolSize;

    public Course()
    {
        lessons = new HashSet<Lesson>();
        startingOccurrences = 0;
        addedByError = 0;
        minimumPoolSize = 0;
        maximumPoolSize = 0;
    }

    public Set<Lesson> getLessons()
    {
        return lessons;
    }

    public int getStartingOccurrences()
    {
        return startingOccurrences;
    }

    public void setStartingOccurrences(int new_occurrences)
    {
        startingOccurrences = new_occurrences;
    }

    public int getAddedByError()
    {
        return addedByError;
    }

    public void setAddedByError(int added)
    {
        addedByError = added;
    }

    public int getMinimumPoolSize()
    {
        return minimumPoolSize;
    }

    public void setMinimumPoolSize(int minimum)
    {
        minimumPoolSize = minimum;
    }

    public int getMaximumPoolSize()
    {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximum)
    {
        maximumPoolSize = maximum;
    }

    public void addLesson(Lesson lesson)
    {
        lessons.add(lesson);
    }

    public void removeLesson(Lesson to_be_removed)
    {
        lessons.remove(to_be_removed);
    }
}
