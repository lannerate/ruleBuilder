package com.flagleader.builder.actions.i;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.a;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.ITreeNode;

public class b extends bl
{
  public b(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "CloseItem";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return ((paramITreeNode instanceof IRuleProject)) || ((paramITreeNode instanceof IRulePackage));
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (a(paramITreeNode))
      this.a.getRulesManager().c().a(paramITreeNode);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.b
 * JD-Core Version:    0.6.0
 */