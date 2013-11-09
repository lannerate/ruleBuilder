package com.flagleader.builder.shell;

import com.flagleader.builder.widget.a.af;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class bS extends SelectionAdapter
{
  bS(bu parambu)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if ((this.a.b.isFocusControl()) && (this.a.g.f()))
      this.a.g.c();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bS
 * JD-Core Version:    0.6.0
 */