package com.flagleader.builder.shell;

import com.flagleader.builder.widget.editor.p;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class bn extends SelectionAdapter
{
  bn(aQ paramaQ)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    p localp = aQ.b(this.a);
    if ((localp != null) && (localp.f()))
      localp.c();
    this.a.d();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bn
 * JD-Core Version:    0.6.0
 */