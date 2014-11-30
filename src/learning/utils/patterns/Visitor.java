package learning.utils.patterns;

import java.util.Optional;

public interface Visitor<NodeT>
{
    Optional<NodeT> visit(NodeT node);
}
