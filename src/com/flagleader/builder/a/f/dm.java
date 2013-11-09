package com.flagleader.builder.a.f;

import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.Rule;

public class dm extends a
{
  public dm(dj paramdj)
  {
  }

  public boolean b()
  {
    return !this.a.k().isLocked();
  }

  public boolean h()
  {
    return this.a.k().isSupportInit();
  }

  public boolean a(boolean paramBoolean)
  {
    if (this.a.k().isSupportInit() != paramBoolean)
    {
      this.a.k().setSupportInit(paramBoolean);
      this.a.k().setModified(true);
      this.a.k().updateViewer();
    }
    return true;
  }

  public String c()
  {
    return "InitSupport";
  }

  public int g()
  {
    return 1;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.dm
 * JD-Core Version:    0.6.0
 */