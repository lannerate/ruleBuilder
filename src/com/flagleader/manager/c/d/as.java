package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.tree.IRule;
import com.flagleader.repository.tree.IRuleTree;

public class as
  implements e
{
  public as(ao paramao)
  {
  }

  public int a()
  {
    return this.b.h().getLogtype();
  }

  public String[] b()
  {
    if ((this.b.h() instanceof IRule))
      return ao.k;
    return ao.j;
  }

  public boolean a(int paramInt)
  {
    if (this.b.h().getLogtype() != paramInt)
    {
      this.b.h().setLogtype(paramInt);
      this.b.h().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.as
 * JD-Core Version:    0.6.0
 */