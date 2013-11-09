package com.flagleader.builder;

import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.swt.widgets.Shell;

public abstract interface IApplication
{
  public abstract Shell getShell();

  public abstract boolean canLoadClass();

  public abstract String loadNewClass(String paramString);

  public abstract void updateEditor();

  public abstract IRunnableContext getApplication();

  public abstract void setStatus(String paramString);

  public abstract String getFlowPath();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.IApplication
 * JD-Core Version:    0.6.0
 */