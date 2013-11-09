package com.flagleader.builder.a.f;

import com.flagleader.repository.rlm.action.MultiActionToken;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.tree.DecisionElementValue;
import com.flagleader.repository.tree.DecisionRelateAction;
import com.flagleader.repository.tree.DecisionRelateRule;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class t
  implements Listener
{
  t(q paramq, Object paramObject)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    if ((this.b instanceof IConditionToken))
      ((IConditionToken)this.b).dispose();
    else if ((this.b instanceof DecisionElementValue))
      ((DecisionElementValue)this.b).dispose();
    else if ((this.b instanceof DecisionRelateAction))
      ((DecisionRelateAction)this.b).getThenActions().dispose();
    o.a(q.a(this.a)).setModified(true);
    q.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.t
 * JD-Core Version:    0.6.0
 */