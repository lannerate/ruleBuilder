package com.flagleader.builder.a.f;

import com.flagleader.builder.widget.d;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.tree.DecisionValue;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class an
  implements Listener
{
  an(ah paramah, Object paramObject)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    if ((this.b instanceof IConditionToken))
      new Clipboard(Display.getCurrent()).setContents(new Object[] { ((IConditionToken)this.b).getComparedValue().deepClone() }, new Transfer[] { d.a() });
    else if ((this.b instanceof DecisionValue))
      new Clipboard(Display.getCurrent()).setContents(new Object[] { ((DecisionValue)this.b).getAssignValue().deepClone() }, new Transfer[] { d.a() });
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.an
 * JD-Core Version:    0.6.0
 */