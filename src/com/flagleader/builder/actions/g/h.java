package com.flagleader.builder.actions.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class h extends bl
{
  public h(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    try
    {
      if ((paramITreeNode instanceof IRuleGroup))
      {
        FileDialog localFileDialog = new FileDialog(new Shell(), 8192);
        localFileDialog.setFilterExtensions(new String[] { "*.xls", "*.xlsx" });
        localFileDialog.setFileName(paramITreeNode.getDisplayName());
        String str = localFileDialog.open();
        if (str != null)
          this.a.getRulesManager().l().b((IRuleGroup)paramITreeNode, str, true);
      }
      else
      {
        (paramITreeNode instanceof IRulePackage);
      }
    }
    catch (Exception localException)
    {
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return ((paramITreeNode instanceof IRulePackage)) || ((paramITreeNode instanceof IRuleProject)) || ((paramITreeNode instanceof IRuleGroup));
  }

  public String a()
  {
    return "ExportProjectTest";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.h
 * JD-Core Version:    0.6.0
 */