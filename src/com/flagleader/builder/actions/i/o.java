package com.flagleader.builder.actions.i;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;

public class o extends bl
{
  public o(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    this.a.getProjectTree().d();
  }

  public String a()
  {
    return "RenameItem";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    if (((paramITreeNode instanceof IPackageElement)) && (!(paramITreeNode instanceof IRuleTree)) && (!((IPackageElement)paramITreeNode).isDevelopModel()))
      return false;
    return paramITreeNode.canRename();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.o
 * JD-Core Version:    0.6.0
 */