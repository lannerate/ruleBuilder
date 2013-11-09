package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.a.l;
import com.flagleader.manager.a;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;

public class b extends g
{
  public b(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "AddClass";
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
          this.a.getRulesManager().c().e().a(localEnvionment, "", this.a.loadNewClass(""));
        }
        catch (ClassNotFoundException localClassNotFoundException1)
        {
          this.a.showError(com.flagleader.manager.d.c.b("classLoadError"));
        }
      }
      else
      {
        l locall = new l(this.a, localEnvionment, "");
        if ((locall.open() == 0) && (locall.a().length() > 0))
          try
          {
            this.a.getRulesManager().c().e().a(localEnvionment, "", locall.a());
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
 * Qualified Name:     com.flagleader.builder.actions.d.b
 * JD-Core Version:    0.6.0
 */