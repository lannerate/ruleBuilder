package com.flagleader.builder.a.f;

import com.flagleader.repository.tree.RuleFlowActivitie;
import com.flagleader.repository.tree.RuleTreeFlow;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class cP
  implements Listener
{
  cP(cK paramcK, int paramInt1, int paramInt2)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    RuleFlowActivitie localRuleFlowActivitie = cG.c(cK.a(this.a)).addNode("CONDITION_NODE", this.b, this.c);
    cG.a(cK.a(this.a), localRuleFlowActivitie);
    cG.c(cK.a(this.a)).setModified(true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cP
 * JD-Core Version:    0.6.0
 */