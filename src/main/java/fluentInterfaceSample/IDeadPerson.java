package fluentInterfaceSample;

import java.util.Date;

// add reborn-scenario
public interface IDeadPerson extends IPerson
{
    IUnmarriedPerson getsReborn(String asWho, Date when);

    @Override
    IDeadPerson stayInState();
}
