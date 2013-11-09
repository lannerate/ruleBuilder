package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.b.d;
import com.flagleader.repository.tree.DecisionElementValue;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class F
  implements Listener
{
  F(q paramq, Object paramObject)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    d locald = new d(o.b(q.a(this.a)).getShell(), o.b(q.a(this.a)), (DecisionElementValue)this.b);
    if (locald.open() == 0)
      q.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.F
 * JD-Core Version:    0.6.0
 */