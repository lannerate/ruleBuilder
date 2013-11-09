package com.flagleader.builder.a.f;

import com.flagleader.repository.rlm.condition.DecisionConditionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.tree.DecisionRule;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class aq
  implements Listener
{
  aq(ah paramah, Object paramObject)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    if ((this.b instanceof DecisionConditionToken))
    {
      ((DecisionConditionToken)this.b).getConditionContainer().addChildElement(new DecisionConditionToken((DecisionConditionToken)this.b));
      af.a(ah.a(this.a)).setModified(true);
      ah.a(this.a).update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aq
 * JD-Core Version:    0.6.0
 */