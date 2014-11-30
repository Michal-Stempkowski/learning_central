package learning.business.course;

import java.util.HashSet;
import java.util.Set;

public class Lesson
{
    public static final String INTERNAL_PATH_SEPARATOR = "\\";

    public final String lessonDir;

    private final Set<Exercise> exercises;

    public Lesson(String lessonDirPath)
    {
        exercises = new HashSet<>();
        lessonDir = lessonDirPath;
    }

    public Set<Exercise> getExercises()
    {
        return exercises;
    }

    public void addExercise(Exercise exercise)
    {
        exercises.add(exercise);
    }

    @Override
    public int hashCode()
    {
        return lessonDir.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        //noinspection UnclearBinaryExpression
        return
                lessonDir.hashCode() == obj.hashCode() &&
                obj instanceof Lesson &&
                ((Lesson) obj).getId().equals(getId());

    }

    public void removeExercise(Exercise toBeRemoved)
    {
        exercises.remove(toBeRemoved);
    }

    public String getId()
    {
        return lessonDir;
    }
}
