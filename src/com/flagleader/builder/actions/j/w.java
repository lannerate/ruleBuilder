package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.manager.a.a.c;
import com.flagleader.manager.r;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.jface.dialogs.MessageDialog;

public class w extends x
{
  public w(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (!(paramITreeNode instanceof IPage)))
      return;
    if (!e())
      return;
    IPage localIPage = (IPage)paramITreeNode;
    try
    {
      if (this.a.getRulesManager().p().a(localIPage))
        MessageDialog.openInformation(this.a.getShell(), "", ResourceTools.getMessage("success.ExportPageDialog"));
    }
    catch (Exception localException)
    {
      MessageDialog.openError(this.a.getShell(), "", localException.getMessage());
    }
  }

  public String a()
  {
    return "uploadjsp";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IPage;
  }

  protected boolean d()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.w
 * JD-Core Version:    0.6.0
 */