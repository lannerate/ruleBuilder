package com.flagleader.builder.a.f;

import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.action.MultiActionToken;
import com.flagleader.repository.tree.DecisionRelateAction;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class B
  implements Listener
{
  B(q paramq, Object paramObject1, Object paramObject2)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    ((DecisionRelateAction)this.b).getThenActions().paste(((IElement)this.c).deepClone());
    q.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.B
 * JD-Core Version:    0.6.0
 */