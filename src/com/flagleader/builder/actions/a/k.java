package com.flagleader.builder.actions.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.ITreeNode;

public class k extends u
{
  public k(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  protected String e()
  {
    return "RuleGroup";
  }

  public String a()
  {
    return "NewRuleGroup";
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (a(paramITreeNode))
      this.a.getProjectTree().a("RuleGroup");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.a.k
 * JD-Core Version:    0.6.0
 */