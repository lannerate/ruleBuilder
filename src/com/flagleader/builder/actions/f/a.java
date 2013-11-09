package com.flagleader.builder.actions.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.ExportModel;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.filesystem.FileUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class a extends b
{
  public a(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode instanceof ExportModel))
    {
      ExportModel localExportModel = (ExportModel)paramITreeNode;
      FileDialog localFileDialog = new FileDialog(this.a.getShell(), 8192);
      String str = localFileDialog.open();
      if (str != null)
      {
        this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
        try
        {
          FileUtil.writeFile(str, localExportModel.getModelStr().getBytes());
          this.a.showSuccess(c.a("HasBeenExport", new String[] { str }));
        }
        catch (Exception localException)
        {
          this.a.getRulesManager().j().b(localException.getMessage());
        }
        this.a.getShell().setCursor(null);
      }
    }
  }

  public String a()
  {
    return "ExportJspModel";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.f.a
 * JD-Core Version:    0.6.0
 */