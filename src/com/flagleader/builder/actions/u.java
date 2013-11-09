package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;

public class u extends h
{
  public u(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
    setChecked(ActionsManager.a(paramActionsManager).getWindowsManager().i());
  }

  public void run()
  {
    ActionsManager.a(this.a).getWindowsManager().c(!ActionsManager.a(this.a).getWindowsManager().i());
    ActionsManager.a(this.a).getWindowsManager().a();
    setChecked(ActionsManager.a(this.a).getWindowsManager().i());
  }

  public boolean isEnabled()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.u
 * JD-Core Version:    0.6.0
 */