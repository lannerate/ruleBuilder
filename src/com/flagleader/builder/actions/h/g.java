package com.flagleader.builder.actions.h;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.a;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.IElement;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class g extends o
{
  public g(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "ExportJavaCode";
  }

  public void b(ITreeNode paramITreeNode)
  {
    String[] arrayOfString = { "*.java" };
    if ((paramITreeNode == null) || (!(paramITreeNode instanceof RulePackage)))
    {
      this.a.showError(c.b("choose_a_rulepackage"));
    }
    else if ((paramITreeNode instanceof RulePackage))
    {
      FileDialog localFileDialog = new FileDialog(this.a.getShell(), 8192);
      localFileDialog.setFileName(((RulePackage)paramITreeNode).getClassName());
      localFileDialog.setFilterExtensions(arrayOfString);
      if (localFileDialog.open() != null)
      {
        this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
        try
        {
          b().a((IRulePackage)paramITreeNode, new PrintWriter(new FileWriter(new File(localFileDialog.getFilterPath() + File.separator + localFileDialog.getFileName()))));
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

  protected boolean d()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.h.g
 * JD-Core Version:    0.6.0
 */