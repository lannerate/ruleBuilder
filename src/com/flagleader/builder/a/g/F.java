package com.flagleader.builder.a.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.c.a;
import com.flagleader.manager.d.c;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.TestCaseLib;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;

public class F extends a
{
  public F(B paramB)
  {
  }

  public void a()
  {
    String[] arrayOfString = { "*.xls", "*.xlsx" };
    FileDialog localFileDialog = new FileDialog(B.e(this.a).getShell(), 8192);
    localFileDialog.setFilterExtensions(arrayOfString);
    localFileDialog.setFileName(B.f(this.a).getParent().getDisplayName() + B.f(this.a).getDisplayName());
    String str = localFileDialog.open();
    if (str != null)
      try
      {
        B.b(this.a).exportXsl(new File(str));
        B.c(this.a).showSuccess(c.a("savefilesuccess.text", new String[] { str }));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        B.c(this.a).showError(localException.getLocalizedMessage());
      }
  }

  public boolean b()
  {
    return !B.d(this.a);
  }

  public String c()
  {
    return "export";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.F
 * JD-Core Version:    0.6.0
 */