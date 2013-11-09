package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.ValueLibrary;

public class f extends g
{
  public f(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (paramITreeNode.isLocked()) || (!(paramITreeNode instanceof Envionment)))
      return;
    Envionment localEnvionment = (Envionment)paramITreeNode;
    ValueLibrary localValueLibrary = localEnvionment.getValueLibrary();
    localValueLibrary.clearAllChildren();
    localEnvionment.setModified(true);
    localValueLibrary.updateViewer();
  }

  public String a()
  {
    return "ClearVariables";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d.f
 * JD-Core Version:    0.6.0
 */