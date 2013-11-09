package com.flagleader.builder.actions;

import java.lang.reflect.Method;
import org.eclipse.jface.dialogs.MessageDialog;

public class l extends h
{
  public l(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    try
    {
      Class localClass = Class.forName("DataBuilder");
      Method localMethod = localClass.getMethod("execute", new Class[0]);
      localMethod.invoke(null, new Object[0]);
    }
    catch (Exception localException)
    {
      MessageDialog.openError(null, "", localException.getMessage());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.l
 * JD-Core Version:    0.6.0
 */