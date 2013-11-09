package com.flagleader.builder.actions.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.a.k;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RuleProject;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class a extends bl
{
  public a(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "ExportProject";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof RuleProject;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode instanceof IRuleProject))
    {
      DirectoryDialog localDirectoryDialog = new DirectoryDialog(this.a.getShell());
      if (localDirectoryDialog.open() != null)
      {
        this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
        try
        {
          b().c().a((IRuleProject)paramITreeNode, localDirectoryDialog.getFilterPath());
        }
        catch (Exception localException)
        {
          this.a.getUserLogger().a(localException.getMessage(), localException);
        }
        this.a.getShell().setCursor(null);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.a
 * JD-Core Version:    0.6.0
 */