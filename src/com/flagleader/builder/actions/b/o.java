package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.widgets.FileDialog;

public class o extends bl
{
  public o(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof SheetTable)))
    {
      String[] arrayOfString = { "*.xls;*.xlsx;*.csv" };
      SheetTable localSheetTable = (SheetTable)paramITreeNode;
      FileDialog localFileDialog = new FileDialog(this.a.getShell());
      localFileDialog.setFilterExtensions(arrayOfString);
      String str = localFileDialog.open();
      if (str != null)
        try
        {
          localSheetTable.loadFieldFromExcel(str);
        }
        catch (Exception localException)
        {
          this.a.showError(localException.getLocalizedMessage());
        }
    }
  }

  public String a()
  {
    return "LoadSheetFieldFromExcel";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof SheetTable;
  }

  protected boolean d()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.o
 * JD-Core Version:    0.6.0
 */