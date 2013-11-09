package com.flagleader.manager.c.d;

import com.flagleader.manager.r;
import com.flagleader.repository.tree.AbstractRuleSet;

public class d
  implements com.flagleader.manager.c.c.b
{
  public d(a parama)
  {
  }

  public boolean a()
  {
    return this.a.f().isFirst();
  }

  public boolean a(boolean paramBoolean)
  {
    this.a.f().setFirst(paramBoolean);
    this.a.f().setModified(true);
    a.a(this.a).b().gotoTreeNode(this.a.f());
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.d
 * JD-Core Version:    0.6.0
 */