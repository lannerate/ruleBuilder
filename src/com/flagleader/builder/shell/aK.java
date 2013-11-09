package com.flagleader.builder.shell;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class aK extends SelectionAdapter
{
  aK(StyledText paramStyledText1, StyledText paramStyledText2)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (this.a.isFocusControl())
      this.a.selectAll();
    else if (this.b.isFocusControl())
      this.b.selectAll();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.aK
 * JD-Core Version:    0.6.0
 */