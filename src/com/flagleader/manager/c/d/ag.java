package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.b;
import com.flagleader.repository.tree.Rule;

public class ag
  implements b
{
  public ag(Z paramZ)
  {
  }

  public boolean a()
  {
    return this.a.f().isSupportInit();
  }

  public boolean a(boolean paramBoolean)
  {
    if (this.a.f().isSupportInit() != paramBoolean)
    {
      this.a.f().setSupportInit(paramBoolean);
      this.a.f().setModified(true);
      this.a.f().updateViewer();
    }
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.ag
 * JD-Core Version:    0.6.0
 */