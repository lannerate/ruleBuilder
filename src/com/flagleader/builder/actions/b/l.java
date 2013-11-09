package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.d.c;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;

public class l extends bl
{
  public l(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof ISelectObject)))
    {
      String[] arrayOfString = { "*.xls", "*.xlsx" };
      ISelectObject localISelectObject = (ISelectObject)paramITreeNode;
      FileDialog localFileDialog = new FileDialog(this.a.getShell(), 8192);
      localFileDialog.setFilterExtensions(arrayOfString);
      localFileDialog.setFileName(paramITreeNode.getDisplayName());
      String str = localFileDialog.open();
      if (str != null)
        try
        {
          localISelectObject.exportTitleXsl(new File(str));
          this.a.showSuccess(c.a("savefilesuccess.text", new String[] { str }));
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
    return "ExportTableTitle";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof ISelectObject;
  }

  protected boolean d()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.l
 * JD-Core Version:    0.6.0
 */