package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.soap.SoapService;

public class aS
  implements f
{
  public aS(aL paramaL)
  {
  }

  public String a()
  {
    return this.a.f().getPortName();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getPortName().equals(paramString))
    {
      this.a.f().setPortName(paramString.toString());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aS
 * JD-Core Version:    0.6.0
 */