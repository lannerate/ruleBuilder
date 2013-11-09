package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;

public class c extends h
{
  public c(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    ActionsManager.a(this.a).getRuleEditor().d();
  }

  public boolean isEnabled()
  {
    if (ActionsManager.a(this.a).getRuleEditor() != null)
      return ActionsManager.a(this.a).getRuleEditor().a();
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.c
 * JD-Core Version:    0.6.0
 */