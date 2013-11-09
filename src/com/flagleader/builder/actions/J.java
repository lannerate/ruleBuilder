package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;

public class J extends h
{
  public J(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
    setChecked(ActionsManager.a(paramActionsManager).getWindowsManager().j());
  }

  public void run()
  {
    ActionsManager.a(this.a).getWindowsManager().d(!ActionsManager.a(this.a).getWindowsManager().j());
    ActionsManager.a(this.a).getWindowsManager().a();
    setChecked(ActionsManager.a(this.a).getWindowsManager().j());
  }

  public boolean isEnabled()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.J
 * JD-Core Version:    0.6.0
 */