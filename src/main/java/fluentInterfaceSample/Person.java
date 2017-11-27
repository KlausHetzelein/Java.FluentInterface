package fluentInterfaceSample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person implements IPerson, IAlivePerson, IUnmarriedPerson, IMarriedPerson, IDeadPerson
{
    private String _name;
    private final List<PersonsLifeEventData> _wholeLife = new ArrayList<PersonsLifeEventData>();

    private Person(final String name, final Date dateOfBirth)
    {
        _name = name;
        _wholeLife.add(new PersonsLifeEventData(PersonsLifeEvent.Birth, dateOfBirth, getName()));
    }

    public static IUnmarriedPerson getsBorn(final String name, final Date birthdate)
    {
        return new Person(name, birthdate);
    }

    @Override
    public String getName()
    {
        return _name;
    }

    private void setName(final String name)
    {
        _name = name;
    }

    @Override
    public Date getBirthdate()
    {
        if (_wholeLife.size() <= 0)
            return null;

        return _wholeLife.get(0).getWhen();
    }

    @Override
    public String getWholeLife()
    {
        if (_wholeLife.size() <= 0)
            return "error: never born person";

        final StringBuilder sWholeLife = new StringBuilder();
        sWholeLife.append(getCurrentState());
        for (int i = 0; i < _wholeLife.size(); i++)
        {
            final PersonsLifeEventData event = _wholeLife.get(i);
            final PersonsLifeEvent what = event.getWhat();

            if (what == PersonsLifeEvent.Marriage)
            {
                sWholeLife.append(String.format("%s %s %s \n", what.asVerb(), event.getAdditionalInfo(),
                        event.getWhenAsString()));
            }
            else
            {
                sWholeLife.append(
                        String.format("%s %s %s\n", what.asVerb(), event.getWhenAsString(), event.getAdditionalInfo()));
            }
        }

        return sWholeLife.toString();
    }

    @Override
    public IDeadPerson dies(final Date when)
    {
        _wholeLife.add(new PersonsLifeEventData(PersonsLifeEvent.Death, when, null));
        return this;
    }

    @Override
    public IUnmarriedPerson getsDivorced(final Date when)
    {
        _wholeLife.add(new PersonsLifeEventData(PersonsLifeEvent.Divorce, when, null));
        return this;
    }

    @Override
    public IUnmarriedPerson getsWidowed(final Date when)
    {
        _wholeLife.add(new PersonsLifeEventData(PersonsLifeEvent.Widowhood, when, null));
        return this;
    }

    @Override
    public IMarriedPerson getsMarried(final String toWhom, final Date when)
    {
        _wholeLife.add(new PersonsLifeEventData(PersonsLifeEvent.Marriage, when, toWhom));
        return this;
    }

    @Override
    public String getCurrentState()
    {
        if (_wholeLife.size() <= 0)
            return "error: never born person";

        return String.format("%s is %s\n", getName(), _wholeLife.get(_wholeLife.size() - 1).getWhat().asState());
    }

    @Override
    public IUnmarriedPerson getsReborn(final String asWho, final Date when)
    {
        // old name gets into additionalinfo, new name is new name
        _wholeLife.add(new PersonsLifeEventData(PersonsLifeEvent.Birth, when, asWho));
        setName(asWho);
        return this;
    }

    @Override
    public Person stayInState()
    {
        System.out.println("In Person::stayInState()");
        System.out.println(this.getCurrentState());

        return this;
    }
}
