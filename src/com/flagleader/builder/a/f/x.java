package com.flagleader.builder.a.f;

import com.flagleader.repository.tree.DecisionRelateRule;
import org.agilemore.agilegrid.G;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class x
  implements Listener
{
  x(q paramq, G paramG)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    o.a(q.a(this.a)).removeDecisionElement(this.b.d - o.a(q.a(this.a)).getConditionNum() + 1);
    if (o.a(q.a(this.a)).getValueNum() == this.b.d - o.a(q.a(this.a)).getConditionNum() + 1)
      o.a(q.a(this.a)).setValueNum(this.b.d - o.a(q.a(this.a)).getConditionNum());
    o.a(q.a(this.a)).setModified(true);
    q.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.x
 * JD-Core Version:    0.6.0
 */