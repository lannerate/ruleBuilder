package com.flagleader.builder.actions.h;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.d.b;
import com.flagleader.manager.e.W;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import java.io.File;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class k extends o
{
  public k(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "ExportRunPackage";
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode instanceof RulePackage))
    {
      this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
      RulePackage localRulePackage = (RulePackage)paramITreeNode;
      DirectoryDialog localDirectoryDialog = new DirectoryDialog(this.a.getShell());
      Object localObject;
      if (localRulePackage.getExportDir().length() > 0)
      {
        localObject = new File(this.a.getConfigManager().a + File.separator + localRulePackage.getExportDir());
        if (!((File)localObject).exists())
          localObject = new File(localRulePackage.getExportDir());
        localDirectoryDialog.setFilterPath(((File)localObject).getAbsolutePath());
      }
      else if (localRulePackage.getCompilePath().length() > 0)
      {
        localObject = new File(localRulePackage.getCompilePath());
        localDirectoryDialog.setFilterPath(((File)localObject).getAbsolutePath());
      }
      else if (this.a.getConfigManager().f().length() > 0)
      {
        if (new File(this.a.getConfigManager().f()).exists())
          localDirectoryDialog.setFilterPath(new File(this.a.getConfigManager().f()).getAbsolutePath());
        else
          localDirectoryDialog.setFilterPath(this.a.getConfigManager().a + File.separator + this.a.getConfigManager().f());
      }
      if ((localDirectoryDialog.open() != null) && (localDirectoryDialog.getFilterPath().length() > 0))
      {
        localObject = this.a.getRulesManager().l().a(localRulePackage, localDirectoryDialog.getFilterPath(), false, true);
        l locall = new l(this, (W)localObject, localRulePackage);
        Display.getCurrent().timerExec(100, locall);
      }
      this.a.getShell().setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.h.k
 * JD-Core Version:    0.6.0
 */