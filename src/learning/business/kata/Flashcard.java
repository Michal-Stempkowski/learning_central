package learning.business.kata;

import learning.business.course.Course;
import learning.business.course.Exercise;
import learning.business.course.Lesson;

public class Flashcard
{
    public static final String PATH_SUFFIX = "flashcard";

    private final Course course;
    private final Lesson lesson;
    private final Exercise exercise;

    private int occurrences;

    public Flashcard(Course c, Lesson l, Exercise e)
    {
        course = c;
        lesson = l;
        exercise = e;

        occurrences = (int)Math.floor(course.getStartingOccurrences() * exercise.getOccurrenceMultiplier());
    }

    public String getId()
    {
        return exercise.getId() + Lesson.INTERNAL_PATH_SEPARATOR + PATH_SUFFIX;
    }

    public int getOccurrences()
    {
        return occurrences;
    }

    public void registerBadAnswer()
    {
        occurrences += course.getAddedByError() * exercise.getOccurrenceMultiplier();
    }

    public void registerCorrectAnswer()
    {
        --occurrences;
    }
}
