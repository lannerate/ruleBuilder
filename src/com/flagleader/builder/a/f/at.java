package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.b.d;
import com.flagleader.repository.tree.DecisionValue;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class at
  implements Listener
{
  at(ah paramah, Object paramObject)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    d locald = new d(af.b(ah.a(this.a)).getShell(), af.b(ah.a(this.a)), (DecisionValue)this.b);
    if (locald.open() == 0)
      ah.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.at
 * JD-Core Version:    0.6.0
 */