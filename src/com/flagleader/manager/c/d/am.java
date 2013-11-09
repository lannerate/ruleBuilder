package com.flagleader.manager.c.d;

import com.flagleader.manager.r;
import com.flagleader.repository.tree.RuleSet;

public class am
  implements com.flagleader.manager.c.c.b
{
  public am(ak paramak)
  {
  }

  public boolean a()
  {
    return this.a.g().isEditTable();
  }

  public boolean a(boolean paramBoolean)
  {
    if (this.a.g().isEditTable() != paramBoolean)
    {
      this.a.g().setEditTable(paramBoolean);
      this.a.g().setModified(true);
      ak.a(this.a).b().gotoTreeNode(this.a.g());
    }
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.am
 * JD-Core Version:    0.6.0
 */