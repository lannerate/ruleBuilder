package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.tree.RulePackage;

public class H
  implements e
{
  public H(y paramy)
  {
  }

  public int a()
  {
    return y.a(this.a).getLogTimes();
  }

  public String[] b()
  {
    return y.k;
  }

  public boolean a(int paramInt)
  {
    if (paramInt != y.a(this.a).getLogTimes())
    {
      y.a(this.a).setLogTimes(paramInt);
      y.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.H
 * JD-Core Version:    0.6.0
 */