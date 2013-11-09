package com.flagleader.builder.a.f;

import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.DecisionRule;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class am
  implements Listener
{
  am(ah paramah, Object paramObject)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    af.a(ah.a(this.a)).pasteValueElement(((IElement)this.b).deepClone());
    af.a(ah.a(this.a)).setModified(true);
    ah.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.am
 * JD-Core Version:    0.6.0
 */