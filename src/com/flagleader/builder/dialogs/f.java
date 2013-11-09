package com.flagleader.builder.dialogs;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class f extends g
{
  public f(Shell paramShell)
  {
    super(paramShell);
  }

  protected void createButtonsForButtonBar(Composite paramComposite)
  {
    createButton(paramComposite, 0, b("Ok"), true);
    createButton(paramComposite, 1, b("Cancel"), false);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.f
 * JD-Core Version:    0.6.0
 */