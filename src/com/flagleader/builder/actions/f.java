package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.r;
import com.flagleader.manager.t;

public class f extends h
{
  public f(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
    setEnabled(true);
  }

  public void run()
  {
    if (ActionsManager.a(this.a).getRulesManager().d() != null)
      try
      {
        ActionsManager.a(this.a).getRulesManager().l().a(ActionsManager.a(this.a).getRulesManager().d());
      }
      catch (Exception localException)
      {
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.f
 * JD-Core Version:    0.6.0
 */