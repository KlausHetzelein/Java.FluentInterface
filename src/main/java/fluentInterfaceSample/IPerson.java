package fluentInterfaceSample;

import java.util.Date;

public interface IPerson
{
    String getCurrentState();
    String getWholeLife();
    String getName();
    Date getBirthdate();

    IPerson stayInState();
}
