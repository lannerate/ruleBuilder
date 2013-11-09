package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.j.a;
import com.flagleader.repository.tree.RulePackage;

public class d extends h
{
  protected a a;

  public d(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
    this.a = new a(ActionsManager.a(paramActionsManager));
  }

  public boolean isEnabled()
  {
    if (!this.a.a(ActionsManager.a(this.b).getProjectTree().c()))
      return false;
    if ((ActionsManager.a(this.b).getProjectTree().c() instanceof RulePackage))
      return ((RulePackage)ActionsManager.a(this.b).getProjectTree().c()).isCheckOut();
    return true;
  }

  public void run()
  {
    if (this.a != null)
      this.a.b(ActionsManager.a(this.b).getProjectTree().c());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d
 * JD-Core Version:    0.6.0
 */