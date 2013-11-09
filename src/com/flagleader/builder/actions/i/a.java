package com.flagleader.builder.actions.i;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.tree.IEnvionment;
import com.flagleader.repository.tree.IOpenNode;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class a extends bl
{
  public a(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "CheckItem";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return true;
  }

  public void b(ITreeNode paramITreeNode)
  {
    this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
    ITreeNode localITreeNode = paramITreeNode;
    if ((localITreeNode instanceof RulePackage))
    {
      ((RulePackage)localITreeNode).setCheckedtime(0L);
      this.a.getRulesManager().l().a((IRulePackage)localITreeNode);
    }
    else if ((localITreeNode instanceof IRuleTree))
    {
      if (((IRuleTree)localITreeNode).getMainPackage() != null)
        this.a.getRulesManager().l().a(((IRuleTree)localITreeNode).getMainPackage());
      else
        this.a.getRulesManager().l().a((IPackageElement)localITreeNode, true);
    }
    else if ((localITreeNode instanceof IEnvionment))
    {
      if (((IEnvionment)localITreeNode).getMainPackage() != null)
        this.a.getRulesManager().l().a(((IEnvionment)localITreeNode).getMainPackage());
      else
        this.a.getRulesManager().l().a((IPackageElement)localITreeNode, true);
    }
    else if ((localITreeNode instanceof IOpenNode))
    {
      this.a.getRulesManager().l().a((IOpenNode)localITreeNode);
    }
    this.a.getShell().setCursor(null);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.a
 * JD-Core Version:    0.6.0
 */