package com.flagleader.builder.actions;

import com.flagleader.builder.shell.ClassInfoEditor;
import org.eclipse.swt.widgets.Shell;

public class g extends h
{
  public g(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    new ClassInfoEditor().b(new Shell().getDisplay());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g
 * JD-Core Version:    0.6.0
 */