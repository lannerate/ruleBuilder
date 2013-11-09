package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;

public class K extends h
{
  public K(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
    setChecked(ActionsManager.a(paramActionsManager).getWindowsManager().h());
  }

  public void run()
  {
    ActionsManager.a(this.a).getWindowsManager().b(!ActionsManager.a(this.a).getWindowsManager().h());
    ActionsManager.a(this.a).getWindowsManager().a();
    setChecked(ActionsManager.a(this.a).getWindowsManager().h());
  }

  public boolean isEnabled()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.K
 * JD-Core Version:    0.6.0
 */