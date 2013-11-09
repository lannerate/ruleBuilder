package com.flagleader.builder.actions.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.tree.ITreeNode;

public abstract class b extends bl
{
  public b(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IPage;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.f.b
 * JD-Core Version:    0.6.0
 */