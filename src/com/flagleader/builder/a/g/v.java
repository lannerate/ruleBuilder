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

public class v extends a
{
  public v(r paramr)
  {
  }

  public void a()
  {
    String[] arrayOfString = { "*.xls", "*.xlsx" };
    FileDialog localFileDialog = new FileDialog(r.e(this.a).getShell(), 8192);
    localFileDialog.setFilterExtensions(arrayOfString);
    localFileDialog.setFileName(r.f(this.a).getParent().getDisplayName() + r.f(this.a).getDisplayName());
    String str = localFileDialog.open();
    if (str != null)
      try
      {
        r.b(this.a).exportXsl(new File(str));
        r.c(this.a).showSuccess(c.a("savefilesuccess.text", new String[] { str }));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        r.c(this.a).showError(localException.getLocalizedMessage());
      }
  }

  public boolean b()
  {
    return !r.d(this.a);
  }

  public String c()
  {
    return "export";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.v
 * JD-Core Version:    0.6.0
 */