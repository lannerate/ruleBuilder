package com.flagleader.builder.actions.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.IDebugNode;
import com.flagleader.repository.tree.ITreeNode;

public class d extends r
{
  public d(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    IDebugNode localIDebugNode = (IDebugNode)paramITreeNode;
    if (localIDebugNode.clearDebug())
    {
      localIDebugNode.setModified(true);
      IElementViewer localIElementViewer = this.a.getRuleEditor().e();
      if (localIElementViewer != null)
        localIElementViewer.update();
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IDebugNode;
  }

  public String a()
  {
    return "ClearDebug";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.c.d
 * JD-Core Version:    0.6.0
 */