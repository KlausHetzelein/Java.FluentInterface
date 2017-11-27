package fluentInterfaceSample;

import java.util.Date;

public interface IUnmarriedPerson extends IAlivePerson
{
    IMarriedPerson getsMarried(String toWhom, Date when);

    @Override
    IUnmarriedPerson stayInState();
}
