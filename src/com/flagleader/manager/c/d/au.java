package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.tree.IRuleTree;

public class au
  implements e
{
  public au(ao paramao)
  {
  }

  public int a()
  {
    return this.a.h().getRestartType();
  }

  public String[] b()
  {
    return ao.l;
  }

  public boolean a(int paramInt)
  {
    if (this.a.h().getRestartType() != paramInt)
    {
      this.a.h().setRestartType(paramInt);
      this.a.h().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.au
 * JD-Core Version:    0.6.0
 */