package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;

public class n extends bl
{
  public n(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof SheetTable)))
    {
      SheetTable localSheetTable = (SheetTable)paramITreeNode;
      FileDialog localFileDialog = new FileDialog(this.a.getShell(), 4096);
      localFileDialog.setFilterExtensions(new String[] { "*.xml;" });
      String str1 = localSheetTable.getExcelFile();
      String str2 = new File(str1).getParent();
      String str3 = new File(str1).getName();
      localFileDialog.setFilterPath(str2);
      localFileDialog.setFileName(str3);
      str3 = localFileDialog.open();
      if (str3 != null)
        try
        {
          localSheetTable.saveValues(localSheetTable.loadDataFromXml(new File(str3)));
          localSheetTable.setModified(true);
          localSheetTable.updateViewer();
          localSheetTable.updateTree();
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
    return "ImportSheetFromXml";
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
 * Qualified Name:     com.flagleader.builder.actions.b.n
 * JD-Core Version:    0.6.0
 */