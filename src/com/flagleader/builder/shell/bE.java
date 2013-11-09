package com.flagleader.builder.shell;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class bE extends SelectionAdapter
{
  bE(bu parambu)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (this.a.c.isFocusControl())
      this.a.c.cut();
    else if (bu.a(this.a).isFocusControl())
      bu.a(this.a).cut();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bE
 * JD-Core Version:    0.6.0
 */