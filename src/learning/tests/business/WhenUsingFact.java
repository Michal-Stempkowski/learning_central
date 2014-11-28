package learning.tests.business;

import static learning.utils.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import learning.business.Fact;
import learning.business.SimpleDrawingFact;
import learning.business.SimpleTextFact;
import org.junit.Test;

public class WhenUsingFact
{
    @Test
    public void shouldDisplayValidTypeName()
    {
        Fact simpleTextFact = new SimpleTextFact();
        Fact graphic_drawing = new SimpleDrawingFact();

        assertThat(simpleTextFact.typeName(), equalTo("SIMPLE_TEXT_FACT"));
        assertThat(graphic_drawing.typeName(), equalTo("SIMPLE_DRAWING_FACT"));
    }
}
