package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.b;
import com.flagleader.repository.tree.Rule;

public class ad
  implements b
{
  public ad(Z paramZ)
  {
  }

  public boolean a()
  {
    return this.a.f().isSupportEnter();
  }

  public boolean a(boolean paramBoolean)
  {
    if (this.a.f().isSupportEnter() != paramBoolean)
    {
      this.a.f().setSupportEnter(paramBoolean);
      this.a.f().setModified(true);
      this.a.f().updateViewer();
    }
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.ad
 * JD-Core Version:    0.6.0
 */