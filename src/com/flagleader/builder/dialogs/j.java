package com.flagleader.builder.dialogs;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.manager.d.b;
import com.flagleader.manager.e.x;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRuleRepository;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.swt.widgets.Display;

public class j extends e
{
  private BuilderManager a;

  public j(BuilderManager paramBuilderManager)
  {
    super(Display.getCurrent().getActiveShell(), "be_sure_to_exit");
    this.a = paramBuilderManager;
  }

  protected void okPressed()
  {
    try
    {
      this.a.getRulesManager().i();
      if (this.a.isMainApplication())
        this.a.getConfigManager().b();
      if (this.a.getRulesManager().d() != null)
        this.a.getRulesManager().d().clearAutoSave();
    }
    catch (Exception localException)
    {
      Logger localLogger = Logger.getLogger("flagleader");
      localLogger.log(Level.SEVERE, localException.getMessage());
    }
    int i = x.a().d();
    if ((i > 0) && (!this.a.showConfirm(i + ResourceTools.getMessage("colseFtp.dialog"))))
    {
      super.cancelPressed();
      return;
    }
    x.a().c();
    System.exit(0);
  }

  protected void b()
  {
    if (this.a.isMainApplication())
      this.a.getConfigManager().b();
    if (this.a.getRulesManager().d() != null)
      this.a.getRulesManager().d().clearAutoSave();
    int i = x.a().d();
    if ((i > 0) && (!this.a.showConfirm(i + ResourceTools.getMessage("colseFtp.dialog"))))
    {
      super.cancelPressed();
      return;
    }
    x.a().c();
    System.exit(0);
  }

  protected void cancelPressed()
  {
    super.cancelPressed();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.j
 * JD-Core Version:    0.6.0
 */