package com.flagleader.builder.actions.j.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;

public class c extends b
{
  public c(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof RulePackage;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (!(paramITreeNode instanceof RulePackage)))
      return;
    b((RulePackage)paramITreeNode, true);
  }

  public String a()
  {
    return "SaveDBVersion";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.a.c
 * JD-Core Version:    0.6.0
 */