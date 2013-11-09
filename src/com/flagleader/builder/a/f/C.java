package com.flagleader.builder.a.f;

import com.flagleader.repository.rlm.condition.DecisionConditionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.tree.DecisionRelateRule;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class C
  implements Listener
{
  C(q paramq, Object paramObject)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    if ((this.b instanceof DecisionConditionToken))
    {
      ((DecisionConditionToken)this.b).getConditionContainer().addChildElement(new DecisionConditionToken((DecisionConditionToken)this.b));
      o.a(q.a(this.a)).setModified(true);
      q.a(this.a).update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.C
 * JD-Core Version:    0.6.0
 */