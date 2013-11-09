package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.tree.IRuleTree;

public class at
  implements e
{
  public at(ao paramao)
  {
  }

  public int a()
  {
    return this.a.h().getMatchType();
  }

  public String[] b()
  {
    return ao.m;
  }

  public boolean a(int paramInt)
  {
    if (this.a.h().getMatchType() != paramInt)
    {
      this.a.h().setMatchType(paramInt);
      this.a.h().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.at
 * JD-Core Version:    0.6.0
 */