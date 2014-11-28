package learning.tests.business;

import static learning.utils.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import learning.business.Fact;
import learning.business.SimpleDrawingFact;
import learning.business.SimpleTextFact;
import org.junit.Before;
import org.junit.Test;

public class WhenUsingFact
{
    private Fact simpleTextFact = null;
    private Fact graphic_drawing = null;

    @Before
    public void setUp()
    {
        simpleTextFact = new SimpleTextFact();
        graphic_drawing = new SimpleDrawingFact();
    }

    @Test
    public void shouldDisplayValidTypeName()
    {
        assertThat(simpleTextFact.typeName(), is(equalTo("SIMPLE_TEXT_FACT")));
        assertThat(graphic_drawing.typeName(), is(equalTo("SIMPLE_DRAWING_FACT")));
    }
    @Test
    public void shouldBeAbleToDisplayAndChangeItsName()
    {
        assertThat(simpleTextFact.getName(), is(equalTo(Fact.UNNAMED)));
        simpleTextFact.setName("polski");
        assertThat(simpleTextFact.getName(), is(equalTo("polski")));
    }
}
