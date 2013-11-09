package com.flagleader.manager.c.d;

import com.flagleader.manager.r;
import com.flagleader.repository.tree.Rule;

public class aa
  implements com.flagleader.manager.c.c.b
{
  public aa(Z paramZ)
  {
  }

  public boolean a()
  {
    return this.a.f().isEditTable();
  }

  public boolean a(boolean paramBoolean)
  {
    if (this.a.f().isEditTable() != paramBoolean)
    {
      this.a.f().setEditTable(paramBoolean);
      this.a.f().setModified(true);
      Z.a(this.a).b().gotoTreeNode(this.a.f());
    }
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.aa
 * JD-Core Version:    0.6.0
 */