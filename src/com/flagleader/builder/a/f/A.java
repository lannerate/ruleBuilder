package com.flagleader.builder.a.f;

import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.tree.DecisionElementValue;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class A
  implements Listener
{
  A(q paramq, Object paramObject1, Object paramObject2)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    ((DecisionElementValue)this.b).getAssignValue().pasteBusinessObject(this.c);
    q.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.A
 * JD-Core Version:    0.6.0
 */