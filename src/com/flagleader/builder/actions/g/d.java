package com.flagleader.builder.actions.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.d.b;
import com.flagleader.manager.e.W;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import java.io.File;
import java.util.Iterator;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class d extends bl
{
  public d(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "ExportExePackage";
  }

  public void b(ITreeNode paramITreeNode)
  {
    Object localObject1;
    DirectoryDialog localDirectoryDialog;
    Object localObject2;
    Object localObject3;
    if ((paramITreeNode instanceof IRuleGroup))
    {
      localObject1 = (IRuleGroup)paramITreeNode;
      localDirectoryDialog = new DirectoryDialog(this.a.getShell());
      if (((IRuleGroup)localObject1).getProject() != null)
      {
        localObject2 = new File(new File(((IRuleGroup)localObject1).getProject().getFilePath()).getParent(), "out");
        if (!((File)localObject2).exists())
          ((File)localObject2).mkdirs();
        localDirectoryDialog.setFilterPath(((File)localObject2).getAbsolutePath());
      }
      else if (this.a.getConfigManager().f().length() > 0)
      {
        if (new File(this.a.getConfigManager().f()).exists())
          localDirectoryDialog.setFilterPath(new File(this.a.getConfigManager().f()).getAbsolutePath());
        else
          localDirectoryDialog.setFilterPath(this.a.getConfigManager().a + File.separator + this.a.getConfigManager().f());
      }
      if ((localDirectoryDialog.open() != null) && (localDirectoryDialog.getFilterPath().length() > 0))
      {
        localObject2 = ((IRuleGroup)paramITreeNode).getAcceptElements(new e(this));
        while (((Iterator)localObject2).hasNext())
          localObject3 = this.a.getRulesManager().l().a((IRulePackage)((Iterator)localObject2).next(), localDirectoryDialog.getFilterPath(), false, true);
      }
    }
    else if ((paramITreeNode instanceof RulePackage))
    {
      this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
      localObject1 = (RulePackage)paramITreeNode;
      localDirectoryDialog = new DirectoryDialog(this.a.getShell());
      if (((RulePackage)localObject1).getExportDir().length() > 0)
      {
        localObject2 = new File(this.a.getConfigManager().a + File.separator + ((RulePackage)localObject1).getExportDir());
        if (!((File)localObject2).exists())
          localObject2 = new File(((RulePackage)localObject1).getExportDir());
        localDirectoryDialog.setFilterPath(((File)localObject2).getAbsolutePath());
      }
      else if (((RulePackage)localObject1).getCompilePath().length() > 0)
      {
        localObject2 = new File(((RulePackage)localObject1).getCompilePath());
        localDirectoryDialog.setFilterPath(((File)localObject2).getAbsolutePath());
      }
      else if (this.a.getConfigManager().f().length() > 0)
      {
        if (new File(this.a.getConfigManager().f()).exists())
          localDirectoryDialog.setFilterPath(new File(this.a.getConfigManager().f()).getAbsolutePath());
        else
          localDirectoryDialog.setFilterPath(this.a.getConfigManager().a + File.separator + this.a.getConfigManager().f());
      }
      if ((localDirectoryDialog.open() != null) && (localDirectoryDialog.getFilterPath().length() > 0))
      {
        localObject2 = this.a.getRulesManager().l().a((IRulePackage)localObject1, localDirectoryDialog.getFilterPath(), false, true);
        localObject3 = new f(this, (W)localObject2, (RulePackage)localObject1);
        Display.getCurrent().timerExec(100, (Runnable)localObject3);
      }
      this.a.getShell().setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.d
 * JD-Core Version:    0.6.0
 */