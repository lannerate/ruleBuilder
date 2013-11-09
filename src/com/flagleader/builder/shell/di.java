package com.flagleader.builder.shell;

import com.flagleader.engine.RuleEngineManager;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class di
  implements Listener
{
  di(dh paramdh)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    dr localdr = new dr(dh.b(this.a));
    if (localdr.open() == 0)
    {
      RuleEngineManager.getInstance().addProject(localdr.a());
      df.b(dh.b(this.a));
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.di
 * JD-Core Version:    0.6.0
 */