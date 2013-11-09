package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.soap.SoapParameter;
import com.flagleader.repository.soap.SoapService;

public class aT
  implements e
{
  public aT(aL paramaL)
  {
  }

  public int a()
  {
    for (int i = 0; i < SoapParameter.DATETYPES.length; i++)
      if (this.a.f().getResultType().equals(SoapParameter.DATETYPES[i]))
        return i;
    return 0;
  }

  public String[] b()
  {
    return SoapParameter.DATETYPES;
  }

  public boolean a(int paramInt)
  {
    if (!SoapParameter.DATETYPES[paramInt].equals(this.a.f().getResultType()))
    {
      this.a.f().changeValueType(SoapParameter.DATETYPES[paramInt]);
      this.a.f().setModified(true);
      this.a.f().updateViewer();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aT
 * JD-Core Version:    0.6.0
 */