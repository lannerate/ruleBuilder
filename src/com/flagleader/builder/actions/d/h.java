package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.IElement;
import com.flagleader.repository.e.e;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import java.io.IOException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class h extends g
{
  public h(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "ExportEnvionment";
  }

  public void b(ITreeNode paramITreeNode)
  {
    String[] arrayOfString = { "*.env" };
    if ((paramITreeNode == null) || (!(paramITreeNode instanceof Envionment)))
    {
      this.a.showError(c.b("choose_a_envionment"));
    }
    else if ((paramITreeNode instanceof Envionment))
    {
      FileDialog localFileDialog = new FileDialog(this.a.getShell(), 8192);
      localFileDialog.setFilterExtensions(arrayOfString);
      if (localFileDialog.open() != null)
      {
        this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
        try
        {
          File localFile = new File(localFileDialog.getFilterPath() + File.separator + localFileDialog.getFileName());
          e locale = new e(localFile);
          locale.a((Envionment)paramITreeNode);
          locale.close();
          this.a.showSuccess(c.a("HasBeenExport", new String[] { paramITreeNode.getDisplayName() }));
        }
        catch (IOException localIOException)
        {
          this.a.getRulesManager().j().b(localIOException.getMessage());
          this.a.showError(localIOException.getMessage() + localIOException.getCause().getMessage());
        }
        this.a.getShell().setCursor(null);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d.h
 * JD-Core Version:    0.6.0
 */