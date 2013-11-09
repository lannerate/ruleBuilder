package com.flagleader.manager.c;

import com.flagleader.repository.tree.IPackageElement;

public class f
  implements com.flagleader.manager.c.c.e
{
  public f(e parame)
  {
  }

  public int a()
  {
    return this.a.c().getVml();
  }

  public String[] b()
  {
    return e.a;
  }

  public boolean a(int paramInt)
  {
    if (this.a.c().getVml() != paramInt)
    {
      this.a.c().setVml(paramInt);
      this.a.c().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.f
 * JD-Core Version:    0.6.0
 */