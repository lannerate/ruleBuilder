package com.flagleader.builder.shell;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class aF extends SelectionAdapter
{
  aF(aD paramaD, StyledText paramStyledText)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    this.b.cut();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.aF
 * JD-Core Version:    0.6.0
 */