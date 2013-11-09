package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.xml.XmlNode;

public class bo
  implements f
{
  public bo(bj parambj)
  {
  }

  public String a()
  {
    return this.a.f().getResourceName();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getResourceName().equals(paramString))
    {
      this.a.f().setResourceName(paramString.toString());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.bo
 * JD-Core Version:    0.6.0
 */