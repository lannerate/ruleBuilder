package com.flagleader.builder.shell;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class bw extends SelectionAdapter
{
  bw(bu parambu)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (this.a.c.isFocusControl())
      this.a.c.copy();
    else if (bu.a(this.a).isFocusControl())
      bu.a(this.a).copy();
    else if (this.a.b.isFocusControl())
      this.a.b.copy();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bw
 * JD-Core Version:    0.6.0
 */