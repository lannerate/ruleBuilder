package com.flagleader.builder.shell;

import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.engine.impl.SingleRuleEngineFactory;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class dk
  implements Listener
{
  dk(dh paramdh, RuleEngineFactory paramRuleEngineFactory)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    ((SingleRuleEngineFactory)this.b).loadAllPackage();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dk
 * JD-Core Version:    0.6.0
 */