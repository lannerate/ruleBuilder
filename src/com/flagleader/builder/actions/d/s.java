package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.c.d;
import com.flagleader.manager.a;
import com.flagleader.manager.a.c;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;

public class s extends g
{
  public s(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof Envionment)))
    {
      d locald = new d(this.a.getShell());
      if (locald.open() == 0)
        b().e().a((Envionment)paramITreeNode, locald.a(), locald.c(), locald.b());
    }
  }

  public String a()
  {
    return "NewExcelBook";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d.s
 * JD-Core Version:    0.6.0
 */