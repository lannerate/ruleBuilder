package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.b.e;
import com.flagleader.builder.b.p;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.l;
import java.util.List;
import org.agilemore.agilegrid.G;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class D
  implements Listener
{
  D(q paramq, G paramG)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    l locall = (l)q.a(this.a).e().get(this.b.c - 1);
    Object localObject;
    if (this.b.d == 0)
    {
      localObject = new p(o.b(q.a(this.a)).getShell(), o.b(q.a(this.a)), o.a(q.a(this.a)).getConditions());
      if (((p)localObject).open() == 0)
        q.a(this.a).update();
    }
    else
    {
      localObject = new e(o.b(q.a(this.a)).getShell(), o.b(q.a(this.a)), o.a(q.a(this.a)).getRelateCondition((IConditionToken)locall.a().get(this.b.d - 1), this.b.d));
      if (((e)localObject).open() == 0)
        q.a(this.a).update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.D
 * JD-Core Version:    0.6.0
 */