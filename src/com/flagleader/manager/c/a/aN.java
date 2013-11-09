package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.soap.SoapService;

public class aN
  implements f
{
  public aN(aL paramaL)
  {
  }

  public String a()
  {
    return this.a.f().getEncoding();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getEncoding().equals(paramString))
    {
      this.a.f().setEncoding(paramString.toString());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aN
 * JD-Core Version:    0.6.0
 */