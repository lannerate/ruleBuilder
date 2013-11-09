package com.flagleader.builder.a.f;

import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.DecisionValue;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class au
  implements Listener
{
  au(ah paramah, Object paramObject)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    if ((this.b instanceof IConditionToken))
      ((IConditionToken)this.b).dispose();
    else if ((this.b instanceof DecisionValue))
      ((DecisionValue)this.b).dispose();
    af.a(ah.a(this.a)).setModified(true);
    ah.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.au
 * JD-Core Version:    0.6.0
 */