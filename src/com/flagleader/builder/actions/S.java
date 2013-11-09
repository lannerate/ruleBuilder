package com.flagleader.builder.actions;

import com.flagleader.builder.shell.aQ;
import org.eclipse.swt.widgets.Shell;

public class S extends h
{
  public S(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    new aQ().b(new Shell().getDisplay());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.S
 * JD-Core Version:    0.6.0
 */