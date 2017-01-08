package fluentInterfaceSample;

import java.util.Date;

public interface IAlivePerson extends IPerson
{
    IDeadPerson dies(Date when);
}
