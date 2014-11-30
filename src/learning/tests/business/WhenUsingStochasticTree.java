package learning.tests.business;

import static learning.utils.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import learning.business.StochasticTree;
import learning.utils.patterns.Visitor;
import org.junit.Before;
import org.junit.Test;

public class WhenUsingStochasticTree
{

    private StochasticTree tree = null;

    @Before
    public void setUp()
    {
        tree = new StochasticTree();
    }

    @Test
    public void onCreationShouldBeEmpty()
    {
        assertThat(tree.size(), is(equalTo(0)));
    }

    @Test
    public void shouldAcceptVisitors()
    {
        Visitor<StochasticTree.Node> visitor = null;

    }
}
