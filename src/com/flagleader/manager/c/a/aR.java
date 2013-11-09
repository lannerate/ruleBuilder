package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.soap.SoapService;

public class aR
  implements f
{
  public aR(aL paramaL)
  {
  }

  public String a()
  {
    return this.a.f().getParamNS();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getParamNS().equals(paramString))
    {
      this.a.f().setParamNS(paramString.toString());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aR
 * JD-Core Version:    0.6.0
 */