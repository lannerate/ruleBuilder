package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.RuleProject;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class N extends Action
{
  private RuleProject b;

  public N(ActionsManager paramActionsManager, RuleProject paramRuleProject)
  {
    this.b = paramRuleProject;
    setText(this.b.getFilePath());
    setToolTipText(this.b.getFilePath());
    setId(this.b.getFilePath());
    setEnabled(!this.b.isOpened());
  }

  public void run()
  {
    try
    {
      ActionsManager.a(this.a).getShell().setCursor(ActionsManager.a(this.a).getShell().getDisplay().getSystemCursor(1));
      if (ActionsManager.a(this.a).getRulesManager().d() != null)
      {
        ActionsManager.a(this.a).getRulesManager().d().addChildElement(this.b);
        this.b.open();
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

  public boolean isEnabled()
  {
    if (this.b != null)
      return !this.b.isOpened();
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.N
 * JD-Core Version:    0.6.0
 */