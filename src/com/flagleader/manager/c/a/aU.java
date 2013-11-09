package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.soap.SoapService;

public class aU
  implements f
{
  public aU(aL paramaL)
  {
  }

  public String a()
  {
    return this.a.f().getServiceNS();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getServiceNS().equals(paramString))
    {
      this.a.f().setServiceNS(paramString.toString());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aU
 * JD-Core Version:    0.6.0
 */