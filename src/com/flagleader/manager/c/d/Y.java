package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.tree.RuleProject;

public class Y
  implements e
{
  public Y(W paramW)
  {
  }

  public int a()
  {
    return W.a(this.a).getSaveType();
  }

  public String[] b()
  {
    return W.a;
  }

  public boolean a(int paramInt)
  {
    if (W.a(this.a).getSaveType() != paramInt)
    {
      W.a(this.a).setSaveType(paramInt);
      W.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.Y
 * JD-Core Version:    0.6.0
 */