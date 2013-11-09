package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;

public class ae extends h
{
  protected ak a = null;

  public ae(ActionsManager paramActionsManager, String paramString, ak paramak)
  {
    super(paramActionsManager, paramString);
    this.a = paramak;
  }

  public boolean isEnabled()
  {
    if (this.a != null)
      return this.a.a(ActionsManager.a(this.b).getProjectTree().c());
    return false;
  }

  public void run()
  {
    if (this.a != null)
      this.a.b(ActionsManager.a(this.b).getProjectTree().c());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.ae
 * JD-Core Version:    0.6.0
 */