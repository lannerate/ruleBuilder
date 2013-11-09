package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.xml.XmlNode;

public class bk
  implements f
{
  public bk(bj parambj)
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
 * Qualified Name:     com.flagleader.manager.c.a.bk
 * JD-Core Version:    0.6.0
 */