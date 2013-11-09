package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.shell.fE;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.tree.ITreeNode;

public class w extends i
{
  public w(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof DBModel)))
    {
      DBModel localDBModel = (DBModel)paramITreeNode;
      fE.a(localDBModel);
    }
  }

  public String a()
  {
    return "runsql";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.w
 * JD-Core Version:    0.6.0
 */