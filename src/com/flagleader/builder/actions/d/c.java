package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.a;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.jface.dialogs.InputDialog;

public class c extends g
{
  public c(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "AddFunction";
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && ((paramITreeNode instanceof Envionment)) && (!paramITreeNode.isLocked()))
    {
      Envionment localEnvionment = (Envionment)paramITreeNode;
      if (this.a.isPlugInApp())
      {
        try
        {
          this.a.getRulesManager().c().e().a(localEnvionment, this.a.loadNewClass(""));
        }
        catch (ClassNotFoundException localClassNotFoundException1)
        {
          this.a.showError(com.flagleader.manager.d.c.b("classLoadError"));
        }
      }
      else
      {
        InputDialog localInputDialog = new InputDialog(this.a.getShell(), "导入方法", "请输入需要导入的静态方法所属的Java类的名称：", "", null);
        if (localInputDialog.open() == 0)
          try
          {
            this.a.getRulesManager().c().e().a(localEnvionment, localInputDialog.getValue());
          }
          catch (ClassNotFoundException localClassNotFoundException2)
          {
            this.a.showError(com.flagleader.manager.d.c.b("classLoadError"));
          }
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d.c
 * JD-Core Version:    0.6.0
 */