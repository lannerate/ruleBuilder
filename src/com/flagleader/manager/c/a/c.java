package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.tree.ClassContainer;

public class c
  implements e
{
  public c(b paramb)
  {
  }

  public int a()
  {
    return this.a.f().getLoadType();
  }

  public String[] b()
  {
    return b.e;
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
 * Qualified Name:     com.flagleader.manager.c.a.c
 * JD-Core Version:    0.6.0
 */