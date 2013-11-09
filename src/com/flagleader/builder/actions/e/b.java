package com.flagleader.builder.actions.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.excel.IExcelBook;
import com.flagleader.manager.d.c;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.widgets.FileDialog;

public class b extends bl
{
  public b(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof ExcelBookModel)))
    {
      String[] arrayOfString = { "*.xls" };
      ExcelBookModel localExcelBookModel = (ExcelBookModel)paramITreeNode;
      FileDialog localFileDialog = new FileDialog(this.a.getShell(), 8192);
      localFileDialog.setFilterExtensions(arrayOfString);
      String str = localFileDialog.open();
      if (str != null)
        try
        {
          if (localExcelBookModel.getExcelData() != null)
          {
            localExcelBookModel.getExcelData().saveToFile(str);
            this.a.showSuccess(c.a("savefilesuccess.text", new String[] { str }));
          }
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
    return "ExportExcelBook";
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
 * Qualified Name:     com.flagleader.builder.actions.e.b
 * JD-Core Version:    0.6.0
 */