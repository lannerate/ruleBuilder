package com.flagleader.builder.shell;

import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.engine.RuleEngineManager;
import com.flagleader.util.StringUtil;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class dj
  implements Listener
{
  dj(dh paramdh, RuleEngineFactory paramRuleEngineFactory)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    dr localdr = new dr(dh.b(this.a), this.b.getName(), this.b.getRuleBasePath());
    if ((localdr.open() == 0) && (!StringUtil.isEmpty(this.b.getName())))
    {
      RuleEngineManager.getInstance().editProject(this.b.getName(), localdr.a());
      df.b(dh.b(this.a));
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dj
 * JD-Core Version:    0.6.0
 */