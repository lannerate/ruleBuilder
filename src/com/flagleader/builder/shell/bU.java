package com.flagleader.builder.shell;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class bU extends SelectionAdapter
{
  bU(bu parambu)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (this.a.c.isFocusControl())
      this.a.c.cut();
    else if (bu.a(this.a).isFocusControl())
      bu.a(this.a).cut();
    else if (this.a.b.isFocusControl())
      this.a.b.cut();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bU
 * JD-Core Version:    0.6.0
 */