package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.soap.SoapService;

public class aM
  implements f
{
  public aM(aL paramaL)
  {
  }

  public String a()
  {
    return this.a.f().getActionUrl();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getActionUrl().equals(paramString))
    {
      this.a.f().setActionUrl(paramString.toString());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aM
 * JD-Core Version:    0.6.0
 */