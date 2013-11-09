package com.flagleader.manager.c.d;

import com.flagleader.repository.tree.AbstractRuleSet;

public class b
  implements com.flagleader.manager.c.c.b
{
  public b(a parama)
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
 * Qualified Name:     com.flagleader.manager.c.d.b
 * JD-Core Version:    0.6.0
 */