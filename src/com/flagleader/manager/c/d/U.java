package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.tree.RulePackage;

public class U
  implements e
{
  public U(y paramy)
  {
  }

  public int a()
  {
    return y.a(this.a).getWebrole();
  }

  public String[] b()
  {
    return y.h;
  }

  public boolean a(int paramInt)
  {
    if (paramInt != y.a(this.a).getWebrole())
    {
      y.a(this.a).setWebrole(paramInt);
      y.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.U
 * JD-Core Version:    0.6.0
 */