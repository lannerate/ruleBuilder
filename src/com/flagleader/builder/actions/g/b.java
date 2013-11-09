package com.flagleader.builder.actions.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RuleGroup;

public class b extends bl
{
  public b(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (((paramITreeNode instanceof RuleGroup)) && (((RuleGroup)paramITreeNode).changePackageGroupName()))
      ((RuleGroup)paramITreeNode).setModified(true);
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof RuleGroup;
  }

  public String a()
  {
    return "changePackageGroupName";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.b
 * JD-Core Version:    0.6.0
 */