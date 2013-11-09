package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;

public class x extends h
{
  public x(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    ActionsManager.a(this.a).getRuleEditor().c();
  }

  public boolean isEnabled()
  {
    if (ActionsManager.a(this.a).getRuleEditor() != null)
      return ActionsManager.a(this.a).getRuleEditor().b();
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.x
 * JD-Core Version:    0.6.0
 */