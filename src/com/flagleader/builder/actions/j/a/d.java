package com.flagleader.builder.actions.j.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;

public class d extends b
{
  public d(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    b((RulePackage)paramITreeNode, true);
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    if (!(paramITreeNode instanceof RulePackage))
      return false;
    return ((RulePackage)paramITreeNode).isDbRules();
  }

  public String a()
  {
    return "UpdateDBRulesItem";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.a.d
 * JD-Core Version:    0.6.0
 */