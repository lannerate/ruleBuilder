package com.flagleader.manager.c.d;

import com.flagleader.manager.builder.b;
import com.flagleader.manager.c.c.e;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.AbstractRuleSet;

public class f
  implements e
{
  public f(a parama)
  {
  }

  public int a()
  {
    return this.a.f().getEditType();
  }

  public String[] b()
  {
    return a.f;
  }

  public boolean a(int paramInt)
  {
    if (this.a.f().getEditType() != paramInt)
    {
      this.a.f().setEditType(paramInt);
      this.a.f().setModified(true);
      a.a(this.a).b().gotoTreeNode(this.a.f());
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.f
 * JD-Core Version:    0.6.0
 */