package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.shell.TestRuleServerDialog;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.IRulePackage;
import org.eclipse.swt.widgets.Shell;

public class ai extends h
{
  public ai(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    TestRuleServerDialog localTestRuleServerDialog;
    if ((ActionsManager.a(this.a).getProjectTree().c() != null) && ((ActionsManager.a(this.a).getProjectTree().c() instanceof IRulePackage)))
    {
      localTestRuleServerDialog = new TestRuleServerDialog(new Shell(), (IRulePackage)ActionsManager.a(this.a).getProjectTree().c());
      localTestRuleServerDialog.open();
    }
    else
    {
      localTestRuleServerDialog = new TestRuleServerDialog(new Shell());
      localTestRuleServerDialog.open();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.ai
 * JD-Core Version:    0.6.0
 */