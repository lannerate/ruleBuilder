package com.flagleader.builder.actions;

import com.flagleader.builder.dialogs.z;

public class A extends h
{
  public A(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
    setMenuCreator(new B(this));
  }

  public void run()
  {
    new z(ActionsManager.a(this.a)).open();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.A
 * JD-Core Version:    0.6.0
 */