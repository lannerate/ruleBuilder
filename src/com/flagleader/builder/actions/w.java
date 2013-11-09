package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;

public class w extends h
{
  public w(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    com.flagleader.builder.dialogs.e.w localw = new com.flagleader.builder.dialogs.e.w(ActionsManager.a(this.a).getShell(), ActionsManager.a(this.a));
    localw.open();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.w
 * JD-Core Version:    0.6.0
 */