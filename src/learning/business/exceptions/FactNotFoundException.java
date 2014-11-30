package learning.business.exceptions;

import learning.business.template.Fact;

public class FactNotFoundException extends RuntimeException
{
    public final Fact fact;

    public FactNotFoundException(Fact factNotFound)
    {
        fact = factNotFound;
    }
}
