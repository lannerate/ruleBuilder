package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.tree.RuleProject;

public class X
  implements f
{
  public X(W paramW)
  {
  }

  public String a()
  {
    return W.a(this.a).getProjver();
  }

  public boolean a(String paramString)
  {
    if (!W.a(this.a).getProjver().equals(paramString.toString()))
    {
      W.a(this.a).setProjver(paramString.toString());
      W.a(this.a).setNeedSave(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.X
 * JD-Core Version:    0.6.0
 */