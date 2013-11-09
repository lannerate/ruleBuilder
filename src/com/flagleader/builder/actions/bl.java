package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.a;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.ITreeNode;

public abstract class bl
  implements ak
{
  protected BuilderManager a = null;

  public bl(BuilderManager paramBuilderManager)
  {
    this.a = paramBuilderManager;
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    if (paramITreeNode == null)
      return false;
    if ((c()) && (paramITreeNode.isLocked()))
      return false;
    if (!c(paramITreeNode))
      return false;
    return (!d()) || (!(paramITreeNode instanceof IPackageElement)) || (((IPackageElement)paramITreeNode).isDevelopModel());
  }

  protected a b()
  {
    return this.a.getRulesManager().c();
  }

  protected boolean c()
  {
    return true;
  }

  protected boolean d()
  {
    return false;
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.bl
 * JD-Core Version:    0.6.0
 */