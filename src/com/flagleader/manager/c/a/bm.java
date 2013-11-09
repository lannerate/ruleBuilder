package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.xml.XmlNode;

public class bm
  implements e
{
  public bm(bj parambj)
  {
  }

  public int a()
  {
    return this.a.f().getMultiType();
  }

  public String[] b()
  {
    return bj.e;
  }

  public boolean a(int paramInt)
  {
    if (paramInt != this.a.f().getMultiType())
    {
      this.a.f().setMultiType(paramInt);
      this.a.f().setModified(true);
      this.a.f().updateText();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.bm
 * JD-Core Version:    0.6.0
 */