package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.repository.tree.AbstractRuleSet;

public class cj extends com.flagleader.builder.a.c.a
{
  public cj(cg paramcg)
  {
  }

  public boolean b()
  {
    return !this.a.k().isLocked();
  }

  public String c()
  {
    return "RuleSetType";
  }

  public int g()
  {
    return 2;
  }

  public String j()
  {
    return com.flagleader.manager.c.d.a.f[this.a.k().getEditType()];
  }

  public String[] i()
  {
    return com.flagleader.manager.c.d.a.f;
  }

  public boolean a(int paramInt)
  {
    if (this.a.k().getEditType() != paramInt)
    {
      this.a.k().setEditType(paramInt);
      this.a.k().setModified(true);
      cg.a(this.a).gotoTreeNode(this.a.k());
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cj
 * JD-Core Version:    0.6.0
 */