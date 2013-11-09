package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.b;
import com.flagleader.repository.tree.Rule;

public class ac
  implements b
{
  public ac(Z paramZ)
  {
  }

  public boolean a()
  {
    return this.a.f().isSupportElse();
  }

  public boolean a(boolean paramBoolean)
  {
    if (this.a.f().isSupportElse() != paramBoolean)
    {
      this.a.f().setSupportElse(paramBoolean);
      this.a.f().setModified(true);
      this.a.f().updateViewer();
    }
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.ac
 * JD-Core Version:    0.6.0
 */