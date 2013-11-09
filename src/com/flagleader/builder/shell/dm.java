package com.flagleader.builder.shell;

import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.engine.RuleEngineManager;
import com.flagleader.util.StringUtil;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class dm
  implements Listener
{
  dm(dh paramdh, RuleEngineFactory paramRuleEngineFactory)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    if (!StringUtil.isEmpty(this.b.getName()))
    {
      RuleEngineManager.getInstance().deleteProject(this.b.getName());
      df.b(dh.b(this.a));
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dm
 * JD-Core Version:    0.6.0
 */