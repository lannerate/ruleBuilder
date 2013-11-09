package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.a;
import com.flagleader.manager.r;

public class L extends h
{
  public L(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
    setEnabled(true);
  }

  public void run()
  {
    if (ActionsManager.a(this.a).getRulesManager().d() != null)
      try
      {
        ActionsManager.a(this.a).getRulesManager().c().f(ActionsManager.a(this.a).getRulesManager().d());
      }
      catch (Exception localException)
      {
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.L
 * JD-Core Version:    0.6.0
 */