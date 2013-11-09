package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.a;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;

public class j extends g
{
  public j(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "LoadClass";
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && ((paramITreeNode instanceof Envionment)) && (!paramITreeNode.isLocked()))
    {
      Envionment localEnvionment = (Envionment)paramITreeNode;
      String[] arrayOfString = { "*.class" };
      FileDialog localFileDialog = new FileDialog(this.a.getShell());
      localFileDialog.setFilterExtensions(arrayOfString);
      String str = localFileDialog.open();
      if (str == null)
        return;
      try
      {
        this.a.getRulesManager().c().e().a(localEnvionment, new File(str));
      }
      catch (Exception localException)
      {
        this.a.showError(com.flagleader.manager.d.c.b("classLoadError") + str);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d.j
 * JD-Core Version:    0.6.0
 */