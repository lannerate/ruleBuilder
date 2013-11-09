package com.flagleader.builder.widget.a;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class A extends SelectionAdapter
{
  A(v paramv, StyledText paramStyledText)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    this.b.copy();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.A
 * JD-Core Version:    0.6.0
 */