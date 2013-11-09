package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.a.b;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.InterfaceContainer;

public class d extends g
{
  public d(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "AddInterface";
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && ((paramITreeNode instanceof Envionment)) && (!paramITreeNode.isLocked()))
    {
      Envionment localEnvionment = (Envionment)paramITreeNode;
      b localb = new b(this.a.getShell(), localEnvionment);
      if ((localb.open() == 0) && (localb.a().length() > 0))
      {
        InterfaceContainer localInterfaceContainer = new InterfaceContainer(localb.b(), localb.a(), localb.c(), localb.d());
        localEnvionment.addChildElement(localInterfaceContainer);
        localInterfaceContainer.updateFunction();
        localEnvionment.setModified(true);
        localEnvionment.updateTree();
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d.d
 * JD-Core Version:    0.6.0
 */