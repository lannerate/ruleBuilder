package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.RulePackage;

public class K
  implements f
{
  public K(y paramy)
  {
  }

  public String a()
  {
    return y.a(this.a).getMainVersion();
  }

  public boolean a(String paramString)
  {
    if (!y.a(this.a).getMainVersion().equals(paramString.toString()))
    {
      y.a(this.a).setMainVersion(paramString.toString());
      y.a(this.a).getEnvionment().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.K
 * JD-Core Version:    0.6.0
 */