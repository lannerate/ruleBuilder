package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.xml.XmlNode;

public class bl
  implements e
{
  public bl(bj parambj)
  {
  }

  public int a()
  {
    return this.a.f().getLoadType();
  }

  public String[] b()
  {
    return bj.f;
  }

  public boolean a(int paramInt)
  {
    if (paramInt != this.a.f().getLoadType())
    {
      this.a.f().setLoadType(paramInt);
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.bl
 * JD-Core Version:    0.6.0
 */