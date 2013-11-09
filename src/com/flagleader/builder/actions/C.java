package com.flagleader.builder.actions;

import com.flagleader.manager.d.b;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MenuItem;

class C
  implements Listener
{
  C(B paramB, MenuItem paramMenuItem)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    b.a().f(this.b.getSelection());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.C
 * JD-Core Version:    0.6.0
 */