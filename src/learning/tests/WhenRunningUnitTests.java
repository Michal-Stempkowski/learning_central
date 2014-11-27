package learning.tests;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class WhenRunningUnitTests {
    @Test
    public void sanityCheckShouldAlwaysPass() {
        assertThat(true, equalTo(true));
    }
}
