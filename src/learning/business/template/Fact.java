package learning.business.template;

@SuppressWarnings("ClassNamingConvention")
public abstract class Fact
{
    public static final String UNNAMED = "<UNNAMED>";

    private String name;

    public Fact()
    {
        name = UNNAMED;
    }

    public abstract String typeName();

    public String getName()
    {
        return name;
    }

    public void setName(String newName)
    {
        name = newName;
    }
}
