package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.RuleFlowActivitie;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.zest.core.widgets.GraphNode;

class cR
  implements Listener
{
  cR(cK paramcK, GraphNode paramGraphNode)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    cG.e(cK.a(this.a)).getProjectTree().c(((RuleFlowActivitie)this.b.getData()).getRuleUuid());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cR
 * JD-Core Version:    0.6.0
 */