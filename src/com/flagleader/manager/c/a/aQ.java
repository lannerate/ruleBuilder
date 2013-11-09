package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.soap.SoapService;

public class aQ
  implements f
{
  public aQ(aL paramaL)
  {
  }

  public String a()
  {
    return this.a.f().getOperationName();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getOperationName().equals(paramString))
    {
      this.a.f().setOperationName(paramString.toString());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aQ
 * JD-Core Version:    0.6.0
 */