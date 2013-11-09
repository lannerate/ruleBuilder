package com.flagleader.builder.actions.i;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.a;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;

public class d extends bl
{
  public d(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "CutItem";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    if (((paramITreeNode instanceof IPackageElement)) && (!(paramITreeNode instanceof IRuleTree)) && (!((IPackageElement)paramITreeNode).isDevelopModel()))
      return false;
    return paramITreeNode.canCut();
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (paramITreeNode != null)
      b().b(paramITreeNode);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.d
 * JD-Core Version:    0.6.0
 */