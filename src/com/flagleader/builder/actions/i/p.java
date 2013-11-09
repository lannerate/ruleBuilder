package com.flagleader.builder.actions.i;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.al;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.a;
import com.flagleader.manager.builder.d;
import com.flagleader.manager.r;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class p extends bl
{
  public p(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (paramITreeNode != null)
    {
      this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
      try
      {
        this.a.getRulesManager().c().h(this.a.getProjectTree().c());
        this.a.getMenuAndToolBar().b();
      }
      catch (Exception localException)
      {
        this.a.showError(localException.getMessage());
        this.a.getRulesManager().j().a(localException.getMessage(), localException);
      }
      this.a.getShell().setCursor(null);
    }
  }

  public String a()
  {
    return "SaveItem";
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    if (paramITreeNode == null)
      return false;
    if (paramITreeNode.isLocked())
      return false;
    return paramITreeNode.isNeedSave();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.p
 * JD-Core Version:    0.6.0
 */