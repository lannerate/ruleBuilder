package com.flagleader.builder.shell;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class aO extends SelectionAdapter
{
  aO(StyledText paramStyledText1, StyledText paramStyledText2)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (this.a.isFocusControl())
      this.a.print();
    else if (this.b.isFocusControl())
      this.b.print();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.aO
 * JD-Core Version:    0.6.0
 */