package com.flagleader.builder.actions.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;

public class c extends bl
{
  public c(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof ExcelBookModel)))
    {
      ExcelBookModel localExcelBookModel = (ExcelBookModel)paramITreeNode;
      FileDialog localFileDialog = new FileDialog(this.a.getShell(), 4096);
      localFileDialog.setFilterExtensions(new String[] { "*.xls;*.csv" });
      String str1 = localExcelBookModel.getXlsFile();
      String str2 = new File(str1).getParent();
      String str3 = new File(str1).getName();
      localFileDialog.setFilterPath(str2);
      localFileDialog.setFileName(str3);
      str3 = localFileDialog.open();
      if (str3 != null)
        try
        {
          localExcelBookModel.setXlsFile(str3);
          localExcelBookModel.getExcelData();
          localExcelBookModel.setModified(true);
          localExcelBookModel.updateViewer();
          localExcelBookModel.updateTree();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          this.a.showError(localException.getLocalizedMessage());
        }
    }
  }

  public String a()
  {
    return "ImportExcelBook";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof ExcelBookModel;
  }

  protected boolean d()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.e.c
 * JD-Core Version:    0.6.0
 */