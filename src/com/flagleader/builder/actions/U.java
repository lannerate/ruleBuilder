package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.a;
import com.flagleader.manager.a.k;
import com.flagleader.manager.builder.d;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.RuleProject;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class U extends h
{
  public U(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
    setEnabled(false);
  }

  public void run()
  {
    if ((ActionsManager.a(this.a).getProjectTree().c() != null) && (ActionsManager.a(this.a).getProjectTree().c() != null) && ((ActionsManager.a(this.a).getProjectTree().c() instanceof RuleProject)))
    {
      DirectoryDialog localDirectoryDialog = new DirectoryDialog(ActionsManager.a(this.a).getShell());
      if (localDirectoryDialog.open() != null)
      {
        ActionsManager.a(this.a).getShell().setCursor(ActionsManager.a(this.a).getShell().getDisplay().getSystemCursor(1));
        try
        {
          ActionsManager.a(this.a).getRulesManager().c().c().b((IRuleProject)ActionsManager.a(this.a).getProjectTree().c(), localDirectoryDialog.getFilterPath());
        }
        catch (Exception localException)
        {
          ActionsManager.a(this.a).getUserLogger().a(localException.getMessage(), localException);
        }
        ActionsManager.a(this.a).getShell().setCursor(null);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.U
 * JD-Core Version:    0.6.0
 */