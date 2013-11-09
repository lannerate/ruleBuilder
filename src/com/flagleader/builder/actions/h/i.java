package com.flagleader.builder.actions.h;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.e.e;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import java.io.File;
import java.io.IOException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class i extends o
{
  public i(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "ExportRulePackage";
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode instanceof RulePackage))
    {
      this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
      a((RulePackage)paramITreeNode);
      this.a.getShell().setCursor(null);
    }
  }

  public void a(RulePackage paramRulePackage)
  {
    FileDialog localFileDialog = new FileDialog(this.a.getShell(), 8192);
    localFileDialog.setFilterExtensions(new String[] { "*.rpk" });
    String str = localFileDialog.open();
    if (str != null)
      try
      {
        e locale = new e(new File(str));
        locale.a(paramRulePackage);
        locale.close();
        this.a.showSuccess(c.a("HasBeenExport", new String[] { str }));
      }
      catch (IOException localIOException)
      {
        this.a.getRulesManager().j().b(localIOException.getMessage());
        this.a.showError(localIOException.getMessage() + localIOException.getCause().getMessage());
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.h.i
 * JD-Core Version:    0.6.0
 */