package com.flagleader.builder.actions.i;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.al;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.ITreeNode;
import java.util.Iterator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class q extends bl
{
  public q(BuilderManager paramBuilderManager)
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
        Iterator localIterator = this.a.getProjectTree().c().getAcceptElements(new r(this));
        while (localIterator.hasNext())
          ((ITreeNode)localIterator.next()).selfsave(false);
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
    return "SaveAny";
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.q
 * JD-Core Version:    0.6.0
 */