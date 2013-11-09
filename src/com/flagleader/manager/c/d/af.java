package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.tree.Rule;

public class af
  implements e
{
  public af(Z paramZ)
  {
  }

  public int a()
  {
    return this.a.f().getExceptionType();
  }

  public String[] b()
  {
    return Z.e;
  }

  public boolean a(int paramInt)
  {
    if (paramInt != this.a.f().getExceptionType())
    {
      this.a.f().setExceptionType(paramInt);
      this.a.f().setModified(true);
      this.a.f().updateViewer();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.af
 * JD-Core Version:    0.6.0
 */