package com.flagleader.builder.actions.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.r;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.ExportModel;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class e extends b
{
  public e(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (paramITreeNode.isLocked()) || (!(paramITreeNode instanceof ExportModel)))
      return;
    ExportModel localExportModel = (ExportModel)paramITreeNode;
    FileDialog localFileDialog = new FileDialog(this.a.getShell(), 4096);
    File localFile;
    if (localExportModel.getImportFile().length() > 0)
    {
      localFile = new File(localExportModel.getImportFile());
      if (!localFile.exists())
        localFile = new File(this.a.getConfigManager().a + File.separator + "classes", localExportModel.getExportFile());
      if (localFile.exists())
      {
        localFileDialog.setFilterPath(localFile.getParent());
        localFileDialog.setFileName(localFile.getName());
      }
    }
    else
    {
      localFileDialog.setFilterPath(this.a.getConfigManager().a + File.separator + "templates");
    }
    localFileDialog.setFilterExtensions(new String[] { "*.rsp;", "*.mdl", "*.*" });
    if (localFileDialog.open() != null)
    {
      this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
      try
      {
        localFile = new File(localFileDialog.getFilterPath(), localFileDialog.getFileName());
        localExportModel.setModelStr(com.flagleader.repository.export.e.b(FileUtil.readFromFile(localFile)));
        localExportModel.setModifyTime(System.currentTimeMillis());
        if (localFile.getAbsolutePath().toLowerCase().startsWith(this.a.getConfigManager().a.toLowerCase()))
          localExportModel.setImportFile(localFile.getAbsolutePath().substring(this.a.getConfigManager().a.length() + File.separator.length()));
        else
          localExportModel.setImportFile(localFile.getAbsolutePath());
        localExportModel.setModified(true);
        this.a.getRuleEditor().a(localExportModel);
      }
      catch (Exception localException)
      {
        this.a.getRulesManager().j().b(localException.getMessage());
      }
      this.a.getShell().setCursor(null);
    }
  }

  public String a()
  {
    return "ImportRsp";
  }

  protected boolean d()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.f.e
 * JD-Core Version:    0.6.0
 */