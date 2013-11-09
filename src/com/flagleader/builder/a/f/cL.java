package com.flagleader.builder.a.f;

import com.flagleader.builder.dialogs.e.C;
import com.flagleader.repository.tree.RuleFlowActivitie;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.zest.core.widgets.GraphNode;

class cL
  implements Listener
{
  cL(cK paramcK, GraphNode paramGraphNode)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    Shell localShell = new Shell(16);
    C localC = new C(localShell, (RuleFlowActivitie)this.b.getData(), cG.e(cK.a(this.a)));
    if (localC.open() == 0)
      cK.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cL
 * JD-Core Version:    0.6.0
 */