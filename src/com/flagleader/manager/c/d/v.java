package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.tree.RuleDBProject;

public class v
  implements f
{
  public v(u paramu)
  {
  }

  public String a()
  {
    return u.a(this.a).getProjver();
  }

  public boolean a(String paramString)
  {
    if (!u.a(this.a).getProjver().equals(paramString.toString()))
    {
      u.a(this.a).setProjver(paramString.toString());
      u.a(this.a).setNeedSave(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.v
 * JD-Core Version:    0.6.0
 */