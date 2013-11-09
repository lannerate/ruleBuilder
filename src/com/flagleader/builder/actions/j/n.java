package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.g.p;
import com.flagleader.manager.a.a.h;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import java.util.Collections;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;

public class n extends x
{
  public n(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IPackageElement;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!e())
      return;
    if (!(paramITreeNode instanceof IPackageElement))
      return;
    p localp = new p(this.a, a((IPackageElement)paramITreeNode), paramITreeNode);
    if (localp.open() == 0)
    {
      List localList = localp.a();
      for (int i = 0; i < localList.size(); i++)
      {
        if (!(localList.get(i) instanceof ITreeNode))
          continue;
        try
        {
          this.a.getRulesManager().s().a((IPackageElement)localList.get(i), localp.b());
          ((IPackageElement)localList.get(i)).selfsave(true);
          ((IPackageElement)localList.get(i)).setModified(false);
          ((IPackageElement)localList.get(i)).updateTree();
        }
        catch (Exception localException)
        {
          this.a.showError(c.a("error.checkin", new String[] { localException.getMessage() }));
        }
      }
    }
  }

  private List a(IPackageElement paramIPackageElement)
  {
    try
    {
      String str1 = "";
      String str2 = "";
      if (!(paramIPackageElement instanceof IRulePackage))
        str1 = paramIPackageElement.getSrcPath();
      if (paramIPackageElement.getMainPackage() != null)
        str2 = paramIPackageElement.getMainPackage().getExeRulePackageName();
      else if (paramIPackageElement.getEnvionment() != null)
        str2 = paramIPackageElement.getEnvionment().getDisplayName();
      h localh = this.a.getRulesManager().s();
      List localList = localh.a(str2, h.a(paramIPackageElement.getParent()));
      if (localList == null)
      {
        MessageDialog.openError(this.a.getShell(), "", localh.i());
        return Collections.EMPTY_LIST;
      }
      return localList;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public String a()
  {
    return "NodeRuleSave";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.n
 * JD-Core Version:    0.6.0
 */