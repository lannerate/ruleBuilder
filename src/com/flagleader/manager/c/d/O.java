package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.tree.RulePackage;

public class O
  implements f
{
  public O(y paramy)
  {
  }

  public String a()
  {
    return String.valueOf(y.a(this.a).getRulesid());
  }

  public boolean a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      if (y.a(this.a).getRulesid() != i)
      {
        y.a(this.a).setRulesid(i);
        y.a(this.a).setModified(true);
        return true;
      }
    }
    catch (Exception localException)
    {
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.O
 * JD-Core Version:    0.6.0
 */