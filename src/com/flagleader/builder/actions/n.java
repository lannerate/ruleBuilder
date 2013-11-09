package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;

public class n extends h
{
  public n(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
    setChecked(ActionsManager.a(paramActionsManager).getWindowsManager().g());
  }

  public void run()
  {
    ActionsManager.a(this.a).getWindowsManager().a(!ActionsManager.a(this.a).getWindowsManager().g());
    ActionsManager.a(this.a).getWindowsManager().a();
    setChecked(ActionsManager.a(this.a).getWindowsManager().g());
  }

  public boolean isEnabled()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.n
 * JD-Core Version:    0.6.0
 */