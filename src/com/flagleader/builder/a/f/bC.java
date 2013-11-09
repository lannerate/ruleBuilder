package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.flow.RulePoolNode;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.zest.core.widgets.GraphNode;

class bC
  implements Listener
{
  bC(bx parambx, GraphNode paramGraphNode)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    bu.d(bx.a(this.a)).getProjectTree().c(((RulePoolNode)this.b.getData()).getRuleUuid());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bC
 * JD-Core Version:    0.6.0
 */