package com.flagleader.builder.a.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.d.c;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.CheckRuleInfo;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;

public class e extends com.flagleader.builder.a.c.a
{
  public e(a parama)
  {
  }

  public void a()
  {
    String[] arrayOfString = { "*.xls", "*.xlsx" };
    FileDialog localFileDialog = new FileDialog(a.e(this.a).getShell(), 8192);
    localFileDialog.setFilterExtensions(arrayOfString);
    localFileDialog.setFileName(a.g(this.a).getParent().getDisplayName() + a.g(this.a).getDisplayName());
    String str = localFileDialog.open();
    if (str != null)
      try
      {
        a.b(this.a).exportXsl(new File(str));
        a.c(this.a).showSuccess(c.a("savefilesuccess.text", new String[] { str }));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        a.c(this.a).showError(localException.getLocalizedMessage());
      }
  }

  public boolean b()
  {
    return !a.d(this.a);
  }

  public String c()
  {
    return "export";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.e
 * JD-Core Version:    0.6.0
 */