package com.flagleader.builder.actions.i;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.a;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;

public class c extends bl
{
  public c(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "CopyItem";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    if (((paramITreeNode instanceof IPackageElement)) && (!(paramITreeNode instanceof IRuleTree)) && (!((IPackageElement)paramITreeNode).isDevelopModel()))
      return false;
    return paramITreeNode.canCopy();
  }

  protected boolean c()
  {
    return false;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (paramITreeNode != null)
      b().c(paramITreeNode);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.c
 * JD-Core Version:    0.6.0
 */