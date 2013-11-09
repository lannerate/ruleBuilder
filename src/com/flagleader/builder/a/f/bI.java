package com.flagleader.builder.a.f;

import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.flow.RulePoolNode;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class bI
  implements Listener
{
  bI(bx parambx, int paramInt1, int paramInt2)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    RulePoolNode localRulePoolNode = bu.c(bx.a(this.a)).addNode("RULETREEFLOW", this.b, this.c);
    bu.a(bx.a(this.a), localRulePoolNode);
    bu.c(bx.a(this.a)).setModified(true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bI
 * JD-Core Version:    0.6.0
 */