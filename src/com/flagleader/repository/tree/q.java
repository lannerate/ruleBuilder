package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.c.a;
import com.flagleader.repository.rom.IBusinessObject;

public class q extends a
{
  private IElement b;

  public void a()
  {
    if ((this.b instanceof IBusinessObject))
    {
      this.a.setMemberElement((IBusinessObject)this.b);
      if (this.a.getRuleTree() != null)
        this.a.getRuleTree().setModified(true);
      this.a.g.update();
    }
  }

  public q(DecisionRule paramDecisionRule, IElement paramIElement)
  {
    this.b = paramIElement;
  }

  public String d()
  {
    if (this.b != null)
      return this.b.getDisplayName();
    return super.d();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.q
 * JD-Core Version:    0.6.0
 */