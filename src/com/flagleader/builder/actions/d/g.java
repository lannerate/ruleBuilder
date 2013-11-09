package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.repository.tree.IEnvionment;
import com.flagleader.repository.tree.ITreeNode;

public abstract class g extends bl
{
  public g(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    return (paramITreeNode != null) && ((paramITreeNode instanceof IEnvionment)) && (!paramITreeNode.isLocked()) && (((IEnvionment)paramITreeNode).isDevelopModel());
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IEnvionment;
  }

  protected boolean d()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d.g
 * JD-Core Version:    0.6.0
 */