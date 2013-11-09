package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.tree.RulePackage;

public class M
  implements f
{
  public M(y paramy)
  {
  }

  public String a()
  {
    return y.a(this.a).getProjver();
  }

  public boolean a(String paramString)
  {
    if (!y.a(this.a).getProjver().equals(paramString.toString()))
    {
      y.a(this.a).setProjver(paramString.toString());
      y.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.M
 * JD-Core Version:    0.6.0
 */