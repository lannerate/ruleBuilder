package com.flagleader.builder.actions;

import com.flagleader.builder.shell.RuleTraceViewer;
import org.eclipse.swt.widgets.Shell;

public class aa extends h
{
  public aa(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    new RuleTraceViewer(ActionsManager.a(this.a)).b(new Shell().getDisplay());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.aa
 * JD-Core Version:    0.6.0
 */