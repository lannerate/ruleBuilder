package com.flagleader.builder.shell;

import com.flagleader.builder.widget.editor.p;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class ba extends SelectionAdapter
{
  ba(aQ paramaQ)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    p localp = aQ.b(this.a);
    if (localp != null)
      localp.w();
    else if (aQ.c(this.a).isFocusControl())
      aQ.c(this.a).copy();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.ba
 * JD-Core Version:    0.6.0
 */