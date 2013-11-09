package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.RuleProject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

class Q
  implements Listener
{
  Q(P paramP, RuleProject paramRuleProject)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    try
    {
      ActionsManager.a(O.a(P.a(this.a))).getShell().setCursor(ActionsManager.a(O.a(P.a(this.a))).getShell().getDisplay().getSystemCursor(1));
      if (ActionsManager.a(O.a(P.a(this.a))).getRulesManager().d() != null)
      {
        ActionsManager.a(O.a(P.a(this.a))).getRulesManager().d().addChildElement(this.b);
        this.b.open();
        ActionsManager.a(O.a(P.a(this.a))).getRulesManager().d().setNeedSave(true);
        ActionsManager.a(O.a(P.a(this.a))).getRulesManager().d().updateTree();
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    ActionsManager.a(O.a(P.a(this.a))).getShell().setCursor(null);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.Q
 * JD-Core Version:    0.6.0
 */