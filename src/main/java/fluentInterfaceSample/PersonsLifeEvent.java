package fluentInterfaceSample;

public enum PersonsLifeEvent
{
    Birth, Marriage, Divorce, Widowhood, Death;

    public String asVerb()
    {
        switch (this)
        {
        case Birth:
            return "born";

        case Marriage:
            return "married";

        case Divorce:
            return "divorced";

        case Widowhood:
            return "widowed";

        case Death:
            return "died";
        }

        return "<unkown>";
    }

    public String asState()
    {
        switch (this)
        {
        case Birth:
            return "single";

        case Marriage:
            return "married";

        case Divorce:
            return "divorced";

        case Widowhood:
            return "widowed";

        case Death:
            return "dead";
        }

        return "<unkown>";
    }
}
