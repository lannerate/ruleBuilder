package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.soap.SoapService;

public class aO
  implements f
{
  public aO(aL paramaL)
  {
  }

  public String a()
  {
    return this.a.f().getEndpointURL();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getEndpointURL().equals(paramString))
    {
      this.a.f().setEndpointURL(paramString.toString());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aO
 * JD-Core Version:    0.6.0
 */