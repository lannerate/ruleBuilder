package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.tree.RulePackage;

public class S
  implements f
{
  public S(y paramy)
  {
  }

  public String a()
  {
    return y.a(this.a).getVersion();
  }

  public boolean a(String paramString)
  {
    if (!y.a(this.a).getVersion().equals(paramString))
    {
      y.a(this.a).setVersion(paramString.toString());
      y.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.S
 * JD-Core Version:    0.6.0
 */