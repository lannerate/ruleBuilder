package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.b.n;
import com.flagleader.manager.a;
import com.flagleader.manager.a.c;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;

public class r extends g
{
  public r(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof Envionment)))
    {
      n localn = new n(this.a.getShell());
      if (localn.open() == 0)
        b().e().a((Envionment)paramITreeNode, localn.b(), localn.d(), localn.e(), localn.c(), localn.a(), localn.f(), localn.g(), localn.i());
    }
  }

  public String a()
  {
    return "NewDB";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d.r
 * JD-Core Version:    0.6.0
 */