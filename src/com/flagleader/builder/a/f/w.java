package com.flagleader.builder.a.f;

import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.DecisionRelateRule;
import org.agilemore.agilegrid.G;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class w
  implements Listener
{
  w(q paramq, G paramG, Object paramObject)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    o.a(q.a(this.a)).pasteValueElement(this.b.d - o.a(q.a(this.a)).getConditionNum() + 1, ((IElement)this.c).deepClone());
    o.a(q.a(this.a)).setModified(true);
    q.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.w
 * JD-Core Version:    0.6.0
 */