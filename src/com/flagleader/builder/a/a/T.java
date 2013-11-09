package com.flagleader.builder.a.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.c.a;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.widgets.FileDialog;

public class T extends a
{
  public T(M paramM)
  {
  }

  public void a()
  {
    String[] arrayOfString = { "*.xls", "*.xlsx" };
    SheetTable localSheetTable = (SheetTable)M.c(this.a);
    FileDialog localFileDialog = new FileDialog(M.a(this.a).getShell(), 8192);
    localFileDialog.setFilterExtensions(arrayOfString);
    localFileDialog.setFileName(M.c(this.a).getDisplayName());
    String str = localFileDialog.open();
    if (str != null)
      M.a(this.a).getRulesManager().l().a(localSheetTable, str, true);
  }

  public boolean b()
  {
    if (M.b(this.a))
      return false;
    return M.d(this.a) != null;
  }

  public String c()
  {
    return "export";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.T
 * JD-Core Version:    0.6.0
 */