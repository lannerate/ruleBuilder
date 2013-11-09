package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.manager.r;
import java.io.File;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class y extends h
{
  public y(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    String[] arrayOfString1 = { "*.prj;*.rpk;*.rep;", "*.*;" };
    FileDialog localFileDialog = new FileDialog(ActionsManager.a(this.a).getShell(), 4098);
    localFileDialog.setFilterExtensions(arrayOfString1);
    if (localFileDialog.open() != null)
      try
      {
        String[] arrayOfString2 = localFileDialog.getFileNames();
        ActionsManager.a(this.a).getShell().setCursor(ActionsManager.a(this.a).getShell().getDisplay().getSystemCursor(1));
        for (int i = 0; i < arrayOfString2.length; i++)
        {
          File localFile = new File(localFileDialog.getFilterPath() + File.separator + arrayOfString2[i]);
          ActionsManager.a(this.a).getRulesManager().a(localFile);
        }
        ActionsManager.a(this.a).getProjectTree().i();
      }
      catch (Exception localException)
      {
        ActionsManager.a(this.a).getRulesManager().j().a(localException.getMessage(), localException);
      }
      finally
      {
        ActionsManager.a(this.a).getShell().setCursor(null);
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.y
 * JD-Core Version:    0.6.0
 */