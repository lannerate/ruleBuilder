package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.g.y;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;

public class c extends x
{
  public c(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!e())
      return;
    if ((paramITreeNode instanceof RulePackage))
    {
      a((RulePackage)paramITreeNode, true);
    }
    else if ((paramITreeNode instanceof IRuleGroup))
    {
      y localy = new y(this.a, (IRuleGroup)paramITreeNode, 0);
      if (localy.open() == 0)
        a(localy.b(), localy.a());
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return ((paramITreeNode instanceof RulePackage)) || ((paramITreeNode instanceof IRuleGroup));
  }

  protected boolean c()
  {
    return false;
  }

  protected boolean d()
  {
    return false;
  }

  public String a()
  {
    return "CheckOutItem";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.c
 * JD-Core Version:    0.6.0
 */