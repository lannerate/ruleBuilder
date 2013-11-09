package com.flagleader.builder.a.f;

import com.flagleader.repository.tree.RuleFlowActivitie;
import com.flagleader.repository.tree.RuleTreeFlow;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class cW
  implements Listener
{
  cW(cK paramcK, int paramInt1, int paramInt2)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    RuleFlowActivitie localRuleFlowActivitie = cG.c(cK.a(this.a)).addNode("RULESET", this.b, this.c);
    cG.a(cK.a(this.a), localRuleFlowActivitie);
    cG.c(cK.a(this.a)).setModified(true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cW
 * JD-Core Version:    0.6.0
 */