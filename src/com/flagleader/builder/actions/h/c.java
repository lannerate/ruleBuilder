package com.flagleader.builder.actions.h;

import com.flagleader.builder.BuilderManager;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.PackageHistory;
import com.flagleader.repository.tree.RulePackage;

public class c extends o
{
  public c(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof RulePackage)))
    {
      RulePackage localRulePackage = (RulePackage)paramITreeNode;
      localRulePackage.getHistory().disposeAndUpdate();
      localRulePackage.updateTree();
    }
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    if ((super.a(paramITreeNode)) && ((paramITreeNode instanceof RulePackage)))
      return ((RulePackage)paramITreeNode).getHistory() != null;
    return false;
  }

  public String a()
  {
    return "ClearHistory";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.h.c
 * JD-Core Version:    0.6.0
 */