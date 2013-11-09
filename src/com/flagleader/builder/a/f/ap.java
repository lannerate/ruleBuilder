package com.flagleader.builder.a.f;

import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.tree.DecisionValue;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class ap
  implements Listener
{
  ap(ah paramah, Object paramObject1, Object paramObject2)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    ((DecisionValue)this.b).getAssignValue().pasteBusinessObject(this.c);
    ah.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.ap
 * JD-Core Version:    0.6.0
 */