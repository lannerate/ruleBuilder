package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRuleRepository;
import java.io.File;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class s extends h
{
  public s(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    String[] arrayOfString = { "*.prj" };
    FileDialog localFileDialog = new FileDialog(ActionsManager.a(this.a).getShell());
    localFileDialog.setFilterExtensions(arrayOfString);
    if (localFileDialog.open() != null)
    {
      ActionsManager.a(this.a).getShell().setCursor(ActionsManager.a(this.a).getShell().getDisplay().getSystemCursor(1));
      ActionsManager.a(this.a).getRulesManager().a(new File(localFileDialog.getFilterPath() + File.separator + localFileDialog.getFileName()));
      if (ActionsManager.a(this.a).getRulesManager().d() != null)
        ActionsManager.a(this.a).getRulesManager().d().updateTree();
      ActionsManager.a(this.a).getShell().setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.s
 * JD-Core Version:    0.6.0
 */