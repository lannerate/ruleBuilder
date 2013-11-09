package com.flagleader.builder.a.f;

import com.flagleader.repository.tree.RuleFlowTransition;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.zest.core.widgets.GraphConnection;

class cU
  implements Listener
{
  cU(cK paramcK, GraphConnection paramGraphConnection)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    ((RuleFlowTransition)this.b.getData()).dispose();
    this.b.dispose();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cU
 * JD-Core Version:    0.6.0
 */