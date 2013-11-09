package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.tree.IRuleTree;

public class aq
  implements e
{
  public aq(ao paramao)
  {
  }

  public int a()
  {
    return this.a.h().getDataShap();
  }

  public boolean a(int paramInt)
  {
    if (this.a.h().getDataShap() != paramInt)
    {
      this.a.h().setDataShap(paramInt);
      this.a.h().setModified(true);
      return true;
    }
    return false;
  }

  public String[] b()
  {
    return ao.i;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.aq
 * JD-Core Version:    0.6.0
 */