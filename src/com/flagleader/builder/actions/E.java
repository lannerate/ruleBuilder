package com.flagleader.builder.actions;

import com.flagleader.repository.m;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MenuItem;

class E
  implements Listener
{
  E(B paramB, MenuItem paramMenuItem)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    if (this.b.getSelection())
      m.a().c(1);
    else
      m.a().c(0);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.E
 * JD-Core Version:    0.6.0
 */