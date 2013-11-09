package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.RuleProject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

class a
  implements Listener
{
  a(ActionsManager paramActionsManager, RuleProject paramRuleProject)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    try
    {
      ActionsManager.a(this.a).getShell().setCursor(ActionsManager.a(this.a).getShell().getDisplay().getSystemCursor(1));
      this.b.open();
      if (ActionsManager.a(this.a).getRulesManager().d() != null)
      {
        ActionsManager.a(this.a).getRulesManager().d().setNeedSave(true);
        ActionsManager.a(this.a).getRulesManager().d().updateTree();
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    ActionsManager.a(this.a).getShell().setCursor(null);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.a
 * JD-Core Version:    0.6.0
 */