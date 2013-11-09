package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.tree.ExpressionRule;

public class s
  implements e
{
  public s(r paramr)
  {
  }

  public int a()
  {
    return this.a.f().getExceptionType();
  }

  public String[] b()
  {
    return r.e;
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
 * Qualified Name:     com.flagleader.manager.c.d.s
 * JD-Core Version:    0.6.0
 */