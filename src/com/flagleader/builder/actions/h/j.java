package com.flagleader.builder.actions.h;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.e.f;
import com.flagleader.manager.d.c;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class j extends bl
{
  public j(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IPackageElement;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!(paramITreeNode instanceof IPackageElement))
      return;
    FileDialog localFileDialog = new FileDialog(new Shell(), 8192);
    localFileDialog.setFilterExtensions(new String[] { "*.xls", "*.xlsx" });
    localFileDialog.setFileName(paramITreeNode.getDisplayName());
    if (localFileDialog.open() != null)
      try
      {
        Object localObject = null;
        if (localFileDialog.getFileName().endsWith(".xls"))
          localObject = new HSSFWorkbook();
        else
          localObject = new XSSFWorkbook();
        if (a((Workbook)localObject, paramITreeNode) != null)
        {
          File localFile = new File(localFileDialog.getFilterPath() + File.separator + localFileDialog.getFileName());
          if (!localFile.exists())
            localFile.createNewFile();
          FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
          ((Workbook)localObject).write(localFileOutputStream);
          localFileOutputStream.flush();
          localFileOutputStream.close();
          MessageDialog.openInformation(new Shell(), "", c.a("HasBeenExport", new String[] { localFileDialog.getFilterPath() + File.separator + localFileDialog.getFileName() }));
        }
      }
      catch (IOException localIOException)
      {
        MessageDialog.openError(new Shell(), "file error!", localIOException.getMessage());
      }
  }

  private Workbook a(Workbook paramWorkbook, ITreeNode paramITreeNode)
  {
    Sheet localSheet = null;
    f localf = new f(this.a, paramITreeNode);
    if (localf.open() == 0)
    {
      List localList = localf.a();
      for (int i = 0; i < localList.size(); i++)
      {
        if (!(localList.get(i) instanceof SheetTable))
          continue;
        try
        {
          localSheet = paramWorkbook.createSheet(((SheetTable)localList.get(i)).getDisplayName());
          ((SheetTable)localList.get(i)).exportExcelSheet(localSheet);
        }
        catch (Exception localException)
        {
          this.a.showError(c.a("error.checkin", new String[] { localException.getMessage() }));
        }
      }
    }
    else
    {
      return null;
    }
    return paramWorkbook;
  }

  public String a()
  {
    return "ExportRuleSheetExcel";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.h.j
 * JD-Core Version:    0.6.0
 */