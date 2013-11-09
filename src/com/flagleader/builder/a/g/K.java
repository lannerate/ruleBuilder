package com.flagleader.builder.a.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.TestCaseLib;

public class K extends a
{
  public K(B paramB)
  {
  }

  public void a()
  {
    try
    {
      if (B.b(this.a).refreshInit())
        this.a.update();
    }
    catch (Exception localException)
    {
      B.c(this.a).showError(localException.getLocalizedMessage());
    }
  }

  public boolean b()
  {
    return !B.d(this.a);
  }

  public String c()
  {
    return "refresh";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.K
 * JD-Core Version:    0.6.0
 */