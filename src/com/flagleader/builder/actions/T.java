package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.a;
import com.flagleader.manager.r;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class T extends h
{
  public T(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    ActionsManager.a(this.a).getShell().setCursor(ActionsManager.a(this.a).getShell().getDisplay().getSystemCursor(1));
    try
    {
      ActionsManager.a(this.a).getRulesManager().c().h(ActionsManager.a(this.a).getRulesManager().d());
      ActionsManager.a(this.a).getMenuAndToolBar().b();
    }
    catch (Exception localException)
    {
      ActionsManager.a(this.a).getRulesManager().j().a(localException.getMessage(), localException);
    }
    ActionsManager.a(this.a).getShell().setCursor(null);
  }

  public boolean isEnabled()
  {
    return ActionsManager.a(this.a).getMenuAndToolBar().c();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.T
 * JD-Core Version:    0.6.0
 */