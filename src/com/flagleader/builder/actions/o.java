package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.j;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRuleRepository;

public class o extends h
{
  public o(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    if ((ActionsManager.a(this.a).getRulesManager().d() != null) && (ActionsManager.a(this.a).getRulesManager().d().isModified()))
    {
      j localj = new j(ActionsManager.a(this.a));
      localj.open();
    }
    else
    {
      if (ActionsManager.a(this.a).getRulesManager().d() != null)
        ActionsManager.a(this.a).getRulesManager().d().clearAutoSave();
      System.exit(0);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.o
 * JD-Core Version:    0.6.0
 */