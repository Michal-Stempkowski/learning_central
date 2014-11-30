package learning.business;

import learning.business.course.Lesson;
import learning.business.exceptions.NotSupportedMethodException;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class StochasticTree
{
    public interface Node
    {
        boolean isRoot();
        Optional<Node> father();
        List<Node> children();

        boolean isLazy();
        boolean isLeaf();
        void setValue(Lesson lesson);
        Optional<Lesson> getValue();
    }

    public class StochasticNode implements Node
    {
        protected Optional<Node> father;
        protected List<Node> children;
        protected boolean expanded;

        public StochasticNode()
        {
            this(null);
        }

        public StochasticNode(Node fatherNode)
        {
            father = Optional.of(fatherNode);
            children = new LinkedList<>();
            expanded = false;
        }

        @Override
        public boolean isRoot()
        {
            return father().isPresent();
        }

        @Override
        public Optional<Node> father()
        {
            return father;
        }

        @Override
        public List<Node> children()
        {
            return children;
        }

        @Override
        public boolean isLazy()
        {
            return expanded;
        }

        @Override
        public boolean isLeaf()
        {
            return false;
        }

        @Override
        public void setValue(Lesson lesson)
        {
            throw new NotSupportedMethodException();
        }

        @Override
        public Optional<Lesson> getValue()
        {
            throw new NotSupportedMethodException();
        }
    }

    public int size()
    {
        return 0;
    }
}
