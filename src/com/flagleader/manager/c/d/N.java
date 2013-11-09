package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.tree.RulePackage;

public class N
  implements e
{
  public N(y paramy)
  {
  }

  public int a()
  {
    return y.a(this.a).getRuleEditLevel();
  }

  public String[] b()
  {
    return y.g;
  }

  public boolean a(int paramInt)
  {
    if (paramInt != y.a(this.a).getRuleEditLevel())
    {
      y.a(this.a).setRuleEditLevel(paramInt);
      y.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.N
 * JD-Core Version:    0.6.0
 */