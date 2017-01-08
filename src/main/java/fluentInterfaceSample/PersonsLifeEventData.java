package fluentInterfaceSample;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonsLifeEventData
{
    private PersonsLifeEvent what;
    private Date when;
    private String additionalInfo;

    public PersonsLifeEventData(final PersonsLifeEvent what, final Date when, final String additionalInfo)
    {
        setWhat(what);
        setWhen(when);
        setAdditionalInfo(additionalInfo);
    }

    public PersonsLifeEvent getWhat()
    {
        return what;
    }

    private void setWhat(final PersonsLifeEvent what)
    {
        this.what = what;
    }

    public Date getWhen()
    {
        return when;
    }

    public String getWhenAsString()
    {
        final SimpleDateFormat formatter = new SimpleDateFormat("d.M.yyyy");
        return formatter.format(when);
    }

    private void setWhen(final Date when)
    {
        this.when = when;
    }

    public String getAdditionalInfo()
    {
        return additionalInfo;
    }

    private void setAdditionalInfo(final String additionalInfo)
    {
        this.additionalInfo = additionalInfo;
        if (this.additionalInfo == null)
        {
            this.additionalInfo = "";
        }
    }
}
