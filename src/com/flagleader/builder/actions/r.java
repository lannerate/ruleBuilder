package com.flagleader.builder.actions;

import com.flagleader.builder.shell.bu;
import org.eclipse.swt.widgets.Shell;

public class r extends h
{
  public r(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    new bu().b(new Shell().getDisplay());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.r
 * JD-Core Version:    0.6.0
 */