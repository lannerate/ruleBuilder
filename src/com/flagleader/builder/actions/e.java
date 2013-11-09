package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.j.c;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.RulePackage;

public class e extends h
{
  protected c a;

  public e(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
    this.a = new c(ActionsManager.a(paramActionsManager));
  }

  public boolean isEnabled()
  {
    if (!this.a.a(ActionsManager.a(this.b).getProjectTree().c()))
      return false;
    if ((ActionsManager.a(this.b).getProjectTree().c() instanceof RulePackage))
      return ((RulePackage)ActionsManager.a(this.b).getProjectTree().c()).isCheckIn();
    return true;
  }

  public void run()
  {
    if (this.a != null)
      this.a.b(ActionsManager.a(this.b).getProjectTree().c());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.e
 * JD-Core Version:    0.6.0
 */