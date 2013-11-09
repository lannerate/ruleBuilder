package com.flagleader.builder.actions.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.ITreeNode;

public abstract class u extends bl
{
  public u(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (paramITreeNode != null)
      this.a.getProjectTree().a(e());
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode.acceptNode(e());
  }

  protected abstract String e();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.a.u
 * JD-Core Version:    0.6.0
 */