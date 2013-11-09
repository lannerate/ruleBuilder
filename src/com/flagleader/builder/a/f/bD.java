package com.flagleader.builder.a.f;

import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.flow.RulePoolNode;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.zest.core.widgets.GraphNode;

class bD
  implements Listener
{
  bD(bx parambx, GraphNode paramGraphNode)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    bu.c(bx.a(this.a)).removeFlowElements(((RulePoolNode)this.b.getData()).getFlowUuid());
    this.b.dispose();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bD
 * JD-Core Version:    0.6.0
 */