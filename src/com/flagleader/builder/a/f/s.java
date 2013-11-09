package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.b.p;
import com.flagleader.repository.tree.DecisionRelateAction;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class s
  implements Listener
{
  s(q paramq, Object paramObject)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    p localp = new p(o.b(q.a(this.a)).getShell(), o.b(q.a(this.a)), ((DecisionRelateAction)this.b).getThenActions());
    if (localp.open() == 0)
      q.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.s
 * JD-Core Version:    0.6.0
 */