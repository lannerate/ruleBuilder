package com.flagleader.builder.actions.h;

import com.flagleader.builder.BuilderManager;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;

public class b extends o
{
  public b(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof RulePackage)))
    {
      RulePackage localRulePackage = (RulePackage)paramITreeNode;
      if (localRulePackage.getComparePackage() != null)
        localRulePackage.getComparePackage().disposeAndUpdate();
      localRulePackage.setComparePackage(null);
      localRulePackage.updateTree();
      localRulePackage.updateViewer();
    }
  }

  public String a()
  {
    return "ClearCompare";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.h.b
 * JD-Core Version:    0.6.0
 */