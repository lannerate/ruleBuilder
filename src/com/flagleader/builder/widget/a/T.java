package com.flagleader.builder.widget.a;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class T extends SelectionAdapter
{
  T(N paramN, StyledText paramStyledText)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    this.b.paste();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.T
 * JD-Core Version:    0.6.0
 */