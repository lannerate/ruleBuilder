package com.flagleader.builder.a.f;

import com.flagleader.builder.dialogs.e.C;
import com.flagleader.repository.flow.RulePoolNode;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.zest.core.widgets.GraphNode;

class bB
  implements Listener
{
  bB(bx parambx, GraphNode paramGraphNode)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    Shell localShell = new Shell(16);
    C localC = new C(localShell, (RulePoolNode)this.b.getData(), bu.d(bx.a(this.a)));
    if (localC.open() == 0)
      bx.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bB
 * JD-Core Version:    0.6.0
 */