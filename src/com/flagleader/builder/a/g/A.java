package com.flagleader.builder.a.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.TestCaseLib;

public class A extends a
{
  public A(r paramr)
  {
  }

  public void a()
  {
    try
    {
      if (r.b(this.a).refreshInit())
        this.a.update();
    }
    catch (Exception localException)
    {
      r.c(this.a).showError(localException.getLocalizedMessage());
    }
  }

  public boolean b()
  {
    return !r.d(this.a);
  }

  public String c()
  {
    return "refresh";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.A
 * JD-Core Version:    0.6.0
 */