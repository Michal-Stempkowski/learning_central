package learning.business.kata;

public class UserAnswerInvalidValidator implements UserAnswerValidator
{
    @Override
    public boolean isCorrect()
    {
        return false;
    }
}
