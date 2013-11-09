package com.flagleader.builder.shell;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class bF extends SelectionAdapter
{
  bF(bu parambu)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (this.a.c.isFocusControl())
      this.a.c.copy();
    else if (bu.a(this.a).isFocusControl())
      bu.a(this.a).copy();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bF
 * JD-Core Version:    0.6.0
 */