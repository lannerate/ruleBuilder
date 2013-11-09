package com.flagleader.builder.actions.i;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;

public class e extends bl
{
  public e(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "DeleteItem";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    if (((paramITreeNode instanceof IPackageElement)) && (!(paramITreeNode instanceof IRuleTree)) && (!((IPackageElement)paramITreeNode).isDevelopModel()))
      return false;
    if ((paramITreeNode.getParent() != null) && ((paramITreeNode.getParent() instanceof ITreeNode)))
      return !paramITreeNode.getParent().isLocked();
    return paramITreeNode.canDelete();
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()))
      this.a.getProjectTree().h();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.e
 * JD-Core Version:    0.6.0
 */