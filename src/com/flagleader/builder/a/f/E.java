package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.b.e;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.l;
import java.util.List;
import org.agilemore.agilegrid.G;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class E
  implements Listener
{
  E(q paramq, G paramG)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    l locall = (l)q.a(this.a).e().get(this.b.c - 1);
    e locale = new e(o.b(q.a(this.a)).getShell(), o.b(q.a(this.a)), o.a(q.a(this.a)).getRelateCondition((IConditionToken)locall.a().get(this.b.d), this.b.d + 1));
    if (locale.open() == 0)
    {
      if (o.a(q.a(this.a)).getConditionNum() <= this.b.d + 1)
      {
        o.a(q.a(this.a)).setConditionNum(o.a(q.a(this.a)).getConditionNum() + 1);
        o.a(q.a(this.a)).setModified(true);
      }
      q.a(this.a).update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.E
 * JD-Core Version:    0.6.0
 */