package com.flagleader.builder.a.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.repository.tree.CheckRuleInfo;

public class j extends com.flagleader.builder.a.c.a
{
  public j(a parama)
  {
  }

  public void a()
  {
    try
    {
      if (a.b(this.a).refreshInit())
        this.a.update();
    }
    catch (Exception localException)
    {
      a.c(this.a).showError(localException.getLocalizedMessage());
    }
  }

  public boolean b()
  {
    return !a.d(this.a);
  }

  public String c()
  {
    return "refresh";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.j
 * JD-Core Version:    0.6.0
 */