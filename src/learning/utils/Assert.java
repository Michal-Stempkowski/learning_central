package learning.utils;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class Assert
{
    public static void assertThrown(Runnable action, Exception exc)
    {
        try
        {
            action.run();
        }
        catch (RuntimeException ex)
        {
            if (ex.getClass().equals(exc.getClass()))
            {
                assertThat(null, anything());
                return;
            }
        }

        assertThat(null, not(anything(exc.getClass().getSimpleName() + " NOT thrown")));
    }
}
