package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.tree.IRuleTree;

public class av
  implements e
{
  public av(ao paramao)
  {
  }

  public int a()
  {
    return this.a.h().getSheetOther();
  }

  public boolean a(int paramInt)
  {
    if (this.a.h().getSheetOther() != paramInt)
    {
      this.a.h().setSheetOther(paramInt);
      this.a.h().setModified(true);
      return true;
    }
    return false;
  }

  public String[] b()
  {
    return ao.h;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.av
 * JD-Core Version:    0.6.0
 */