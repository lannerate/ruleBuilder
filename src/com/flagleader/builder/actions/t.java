package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.a;
import com.flagleader.manager.builder.d;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRuleRepository;
import java.io.File;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class t extends h
{
  public t(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    String[] arrayOfString = { "*.rep;" };
    FileDialog localFileDialog = new FileDialog(ActionsManager.a(this.a).getShell());
    localFileDialog.setFilterExtensions(arrayOfString);
    String str = localFileDialog.open();
    if ((str != null) && (str.length() > 0))
    {
      if ((ActionsManager.a(this.a).getRulesManager().d() != null) && (ActionsManager.a(this.a).getRulesManager().d().isModified()))
      {
        MessageBox localMessageBox = new MessageBox(ActionsManager.a(this.a).getShell(), 65988);
        localMessageBox.setMessage(c.b("choosesaveproject"));
        int i = localMessageBox.open();
        if (i == 64)
        {
          try
          {
            ActionsManager.a(this.a).getRulesManager().c().h(ActionsManager.a(this.a).getRulesManager().d());
          }
          catch (Exception localException)
          {
            ActionsManager.a(this.a).getRulesManager().j().b(localException.getMessage());
          }
          ActionsManager.a(this.a).getRulesManager().d().dispose();
        }
        else if (i == 128)
        {
          ActionsManager.a(this.a).getRulesManager().d().clearAutoSave();
          ActionsManager.a(this.a).getRulesManager().d().dispose();
        }
        else
        {
          return;
        }
      }
      ActionsManager.a(this.a).getShell().setCursor(ActionsManager.a(this.a).getShell().getDisplay().getSystemCursor(1));
      ActionsManager.a(this.a).getRulesManager().a(new File(str));
      ActionsManager.a(this.a).getProjectTree().i();
      ActionsManager.a(this.a).getShell().setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.t
 * JD-Core Version:    0.6.0
 */