package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.b.C;
import com.flagleader.manager.d.c;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;

public class j extends bl
{
  public j(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof SheetTable)))
    {
      SheetTable localSheetTable = (SheetTable)paramITreeNode;
      C localC = new C(this.a.getShell(), localSheetTable);
      if (localC.open() == 0)
      {
        localSheetTable.setMatchFields(localC.b());
        localSheetTable.setExcelFile(localC.c());
        try
        {
          localSheetTable.exportXsl(new File(localC.d()), true);
          this.a.showSuccess(c.a("savefilesuccess.text", new String[] { localC.d() }));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          this.a.showError(localException.getMessage());
        }
      }
    }
  }

  public String a()
  {
    return "ExportMatchExcel";
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
 * Qualified Name:     com.flagleader.builder.actions.b.j
 * JD-Core Version:    0.6.0
 */