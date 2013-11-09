package com.flagleader.builder.a.f;

import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class z
  implements Listener
{
  z(q paramq, Object paramObject1, Object paramObject2)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    ((IConditionToken)this.b).getComparedValue().pasteBusinessObject(this.c);
    q.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.z
 * JD-Core Version:    0.6.0
 */