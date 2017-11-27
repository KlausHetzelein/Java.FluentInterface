package fluentInterfaceSample;

import java.util.Date;

public interface IMarriedPerson extends IAlivePerson
{
    IUnmarriedPerson getsDivorced(Date when);

    IUnmarriedPerson getsWidowed(Date when);

    @Override
    IMarriedPerson stayInState();
}
