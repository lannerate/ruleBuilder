package com.flagleader.builder.c;

import com.flagleader.manager.c.c.b;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

class u extends SelectionAdapter
{
  u(k paramk, b paramb, Button paramButton)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    this.b.a(this.c.getSelection());
    this.c.dispose();
    this.a.update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.c.u
 * JD-Core Version:    0.6.0
 */