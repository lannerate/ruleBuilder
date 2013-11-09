package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.b;
import com.flagleader.repository.tree.Rule;

public class ae
  implements b
{
  public ae(Z paramZ)
  {
  }

  public boolean a()
  {
    return this.a.f().isSupportCatch();
  }

  public boolean a(boolean paramBoolean)
  {
    if (this.a.f().isSupportCatch() != paramBoolean)
    {
      this.a.f().setSupportCatch(paramBoolean);
      this.a.f().setModified(true);
      this.a.f().updateViewer();
    }
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.ae
 * JD-Core Version:    0.6.0
 */