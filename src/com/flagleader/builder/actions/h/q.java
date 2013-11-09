package com.flagleader.builder.actions.h;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.repository.e.e;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;

public class q extends bl
{
  public q(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IRuleTree;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!(paramITreeNode instanceof IRuleTree))
      return;
    String[] arrayOfString = { "*.rmk" };
    FileDialog localFileDialog = new FileDialog(this.a.getShell(), 8192);
    localFileDialog.setFilterExtensions(arrayOfString);
    localFileDialog.setFileName(paramITreeNode.getDisplayName());
    String str = localFileDialog.open();
    if (str != null)
      try
      {
        e.a((IRuleTree)paramITreeNode, new File(str));
      }
      catch (Exception localException)
      {
        this.a.showError(localException.getLocalizedMessage());
      }
  }

  public String a()
  {
    return "SaveTemplateLocal";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.h.q
 * JD-Core Version:    0.6.0
 */