package com.flagleader.builder.shell;

import com.flagleader.engine.RuleEngineManager;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TreeItem;

class dl
  implements Listener
{
  dl(dh paramdh)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    RuleEngineManager.getInstance().setActiveProject(dh.a(this.a).getText());
    df.b(dh.b(this.a));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dl
 * JD-Core Version:    0.6.0
 */