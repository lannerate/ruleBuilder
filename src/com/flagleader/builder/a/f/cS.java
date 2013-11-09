package com.flagleader.builder.a.f;

import com.flagleader.repository.tree.RuleFlowActivitie;
import com.flagleader.repository.tree.RuleTreeFlow;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.zest.core.widgets.GraphNode;

class cS
  implements Listener
{
  cS(cK paramcK, GraphNode paramGraphNode)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    if (((RuleFlowActivitie)this.b.getData()).isPointNode())
    {
      cG.c(cK.a(this.a)).removeFlowElements(((RuleFlowActivitie)this.b.getData()).getFlowUuid());
      cK.a(this.a).update();
    }
    else
    {
      cG.c(cK.a(this.a)).removeFlowElements(((RuleFlowActivitie)this.b.getData()).getFlowUuid());
      this.b.dispose();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cS
 * JD-Core Version:    0.6.0
 */