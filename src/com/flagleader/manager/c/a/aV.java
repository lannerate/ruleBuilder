package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.soap.SoapService;

public class aV
  implements f
{
  public aV(aL paramaL)
  {
  }

  public String a()
  {
    return this.a.f().getServiceName();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getServiceName().equals(paramString))
    {
      this.a.f().setServiceName(paramString.toString());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aV
 * JD-Core Version:    0.6.0
 */