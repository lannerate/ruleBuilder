package com.flagleader.builder.actions.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.a;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;

public class v extends bl
{
  public v(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    try
    {
      this.a.getRulesManager().c().g(paramITreeNode);
    }
    catch (Exception localException)
    {
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return ((paramITreeNode instanceof IRulePackage)) || ((paramITreeNode instanceof IRuleGroup));
  }

  public String a()
  {
    return "ReExportJsp";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.v
 * JD-Core Version:    0.6.0
 */