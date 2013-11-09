package com.flagleader.builder.shell;

import com.flagleader.builder.widget.editor.p;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class aT extends SelectionAdapter
{
  aT(aQ paramaQ)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    p localp = aQ.b(this.a);
    if (localp != null)
      localp.B();
    else if (aQ.c(this.a).isFocusControl())
      this.a.d.B();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.aT
 * JD-Core Version:    0.6.0
 */