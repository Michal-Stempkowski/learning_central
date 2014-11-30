package learning.utils.patterns;

import java.util.Optional;

public final class VisitorHelper
{
    private VisitorHelper() { }

    public static <NodeT> void visitElements(Visitor<NodeT> visitor, NodeT startingNode)
    {
        Optional<NodeT> node = Optional.of(startingNode);

        while (node.isPresent())
        {
            node = visitor.visit(node.get());
        }
    }
}
