package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;

public class i extends g
{
  public i(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "ImportEnvionment";
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof Envionment)))
    {
      String[] arrayOfString = { "*.env" };
      FileDialog localFileDialog = new FileDialog(this.a.getShell());
      localFileDialog.setFilterExtensions(arrayOfString);
      String str = localFileDialog.open();
      if (str == null)
        return;
      Envionment localEnvionment1 = (Envionment)paramITreeNode;
      File localFile = new File(str);
      try
      {
        Envionment localEnvionment2 = (Envionment)new com.flagleader.repository.d.c().load(localFile);
        if (this.a.showConfirm(com.flagleader.manager.d.c.b("warning_replace_envionment")))
        {
          localEnvionment1.replaceNewEnvionment(localEnvionment2);
          localEnvionment1.updateTree();
        }
      }
      catch (Exception localException)
      {
        this.a.showError(com.flagleader.manager.d.c.b("error_envionment_file"));
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d.i
 * JD-Core Version:    0.6.0
 */