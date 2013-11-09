package com.flagleader.builder.actions.i;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.a;
import com.flagleader.manager.r;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.a.c;

public class l extends bl
{
  public l(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()))
    {
      IElement localIElement = b().a();
      if ((localIElement instanceof ITreeNode))
        this.a.getRulesManager().c().a(new c(paramITreeNode, (ITreeNode)localIElement));
      if ((localIElement != null) && (paramITreeNode.paste(localIElement.deepClone())))
        paramITreeNode.setModified(true);
    }
  }

  public String a()
  {
    return "PasteItem";
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    if (paramITreeNode == null)
      return false;
    if (((paramITreeNode instanceof IPackageElement)) && (!(paramITreeNode instanceof IRuleTree)) && (!((IPackageElement)paramITreeNode).isDevelopModel()))
      return false;
    return !paramITreeNode.isLocked();
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return (!(paramITreeNode instanceof IPackageElement)) || ((paramITreeNode instanceof IRuleTree)) || (((IPackageElement)paramITreeNode).isDevelopModel());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.l
 * JD-Core Version:    0.6.0
 */