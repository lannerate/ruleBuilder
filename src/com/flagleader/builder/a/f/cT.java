package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.b.G;
import com.flagleader.repository.tree.RuleFlowTransition;
import com.flagleader.repository.tree.RuleTreeFlow;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.zest.core.widgets.GraphConnection;

class cT
  implements Listener
{
  cT(cK paramcK, GraphConnection paramGraphConnection)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    G localG = new G(cG.e(cK.a(this.a)).getShell(), cG.e(cK.a(this.a)), (RuleFlowTransition)this.b.getData());
    if (localG.open() == 0)
    {
      String str = ((RuleFlowTransition)this.b.getData()).getInfo();
      this.b.setText(str);
      cG.c(cK.a(this.a)).setModified(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cT
 * JD-Core Version:    0.6.0
 */